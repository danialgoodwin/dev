import java.util.Scanner;

public class Calc {
  private static void log(String message) {
    System.out.println(message);
  }

  public static void main(String[] args) {
    log("main()");
    Scanner sc = new Scanner(System.in);
    while (true) {
      try {
        String text = sc.nextLine();
        if (text.isEmpty()) { break; }
        Lexer lexer = new Lexer(text);
        Parser parser = new Parser(lexer);
        Interpreter interpreter = new Interpreter(parser);
        int output = interpreter.interpret();
        log(String.valueOf(output));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private static class Token {
    public static final int EOF = 0;
    public static final int NUMBER = 1;
    public static final int PLUS = 2;
    public static final int MINUS = 3;
    public static final int MULTIPLY = 4;
    public static final int DIVIDE = 5;
    public static final int BRACKET_START = 6;
    public static final int BRACKET_STOP = 7;

    public final int type;
    public final String value;
    public Token(int type, String value) {
      this.type = type;
      this.value = value;
    }
  }

  private static class Lexer {
    private final String mText;
    private int mPosition = 0;
    private char mCurrentChar;

    public Lexer(String text) {
      mText = text;
      mCurrentChar = text.charAt(0);
    }

    public boolean advance() {
      mPosition++;
      if (mPosition >= mText.length()) {
        return false;
      } else {
        mCurrentChar = mText.charAt(mPosition);
        return true;
      }
    }

    public void skipWhitespace() {
      while (Character.isWhitespace(mCurrentChar) && advance()) { /* Advancing in condition */ }
    }

    public String number() {
      StringBuilder number = new StringBuilder();
      while (Character.isDigit(mCurrentChar)) {
        number.append(mCurrentChar);
        if (!advance()) { break; }
      }
      return number.toString();
      // return Integer.parse(number.toString());
    }

    public Token getNextToken() {
      skipWhitespace();
      if (mPosition >= mText.length()) { return new Token(Token.EOF, ""); }
      if (Character.isDigit(mCurrentChar)) { return new Token(Token.NUMBER, number()); }
      if (mCurrentChar == '+') { advance(); return new Token(Token.PLUS, "+"); }
      if (mCurrentChar == '-') { advance(); return new Token(Token.MINUS, "-"); }
      if (mCurrentChar == '*') { advance(); return new Token(Token.MULTIPLY, "*"); }
      if (mCurrentChar == '/') { advance(); return new Token(Token.DIVIDE, "/"); }
      if (mCurrentChar == '[') { advance(); return new Token(Token.BRACKET_START, "["); }
      if (mCurrentChar == ']') { advance(); return new Token(Token.BRACKET_STOP, "]"); }
      throw new RuntimeException("LexerError, unexpected character: " + mCurrentChar);
    }

  }

  private static class AbstractSyntaxTree {}

  private static class UnaryOperatorNode extends AbstractSyntaxTree {
    public final Token token;
    public final AbstractSyntaxTree expr;
    public UnaryOperatorNode(Token token, AbstractSyntaxTree expr) {
      this.token = token;
      this.expr = expr;
    }
  }

  private static class BinaryOperatorNode extends AbstractSyntaxTree {
    public final Token token;
    public final AbstractSyntaxTree left;
    public final AbstractSyntaxTree right;
    public BinaryOperatorNode(Token token, AbstractSyntaxTree left, AbstractSyntaxTree right) {
      this.token = token;
      this.left = left;
      this.right = right;
    }
  }

  private static class NumberNode extends AbstractSyntaxTree {
    public final Token token;
    public NumberNode(Token token) {
      this.token = token;
    }
  }

  private static class Parser {
    private Lexer mLexer;
    private Token mCurrentToken;

    public Parser(Lexer lexer) {
      mLexer = lexer;
      mCurrentToken = mLexer.getNextToken();
    }

    private void eat(int tokenType) {
      if (mCurrentToken.type == tokenType) {
        mCurrentToken = mLexer.getNextToken();
      } else {
        throw new RuntimeException("ParserException, unexpected type: " + tokenType);
      }
    }

    private AbstractSyntaxTree factor() {
      Token token = mCurrentToken;
      switch (token.type) {
        case Token.PLUS: eat(Token.PLUS); return new UnaryOperatorNode(token, factor());
        case Token.MINUS: eat(Token.MINUS); return new UnaryOperatorNode(token, factor());
        case Token.NUMBER: eat(Token.NUMBER); return new NumberNode(token);
        case Token.BRACKET_START:
          eat(Token.BRACKET_START);
          AbstractSyntaxTree node = expr();
          eat(Token.BRACKET_STOP);
          return node;
        default:
          throw new RuntimeException("ParserException, unexpected factor token type: " + token.type);
      }
    }

    private AbstractSyntaxTree term() {
      AbstractSyntaxTree node = factor();
      while (mCurrentToken.type == Token.MULTIPLY || mCurrentToken.type == Token.DIVIDE) {
        Token token = mCurrentToken;
        switch (token.type) {
          case Token.MULTIPLY: eat(Token.MULTIPLY); break;
          case Token.DIVIDE: eat(Token.DIVIDE); break;
        }
        node = new BinaryOperatorNode(token, node, factor());
      }
      return node;
    }

    private AbstractSyntaxTree expr() {
      AbstractSyntaxTree node = term();
      while (mCurrentToken.type == Token.PLUS || mCurrentToken.type == Token.MINUS) {
        Token token = mCurrentToken;
        switch (token.type) {
          case Token.PLUS: eat(Token.PLUS); break;
          case Token.MINUS: eat(Token.MINUS); break;
        }
        node = new BinaryOperatorNode(token, node, term());
      }
      return node;
    }

    public AbstractSyntaxTree parse() {
      return expr();
    }

  }

  // Interpreter

  private static class NodeVisitor {}

  private static class Interpreter extends NodeVisitor {
    private Parser mParser;

    public Interpreter(Parser parser) {
      mParser = parser;
    }

    // This would be improved with polymorphism
    private int visit(AbstractSyntaxTree node) {
      if (node instanceof NumberNode) {
        return visitNumberNode((NumberNode) node);
      } else if (node instanceof BinaryOperatorNode) {
        return visitBinaryOperatorNode((BinaryOperatorNode) node);
      } else if (node instanceof UnaryOperatorNode) {
        return visitUnaryOperatorNode((UnaryOperatorNode) node);
      }
      throw new RuntimeException("InterpreterException, unexpected visit node: " + node);
    }

    private int visitBinaryOperatorNode(BinaryOperatorNode node) {
      switch (node.token.type) {
        case Token.PLUS: return visit(node.left) + visit(node.right);
        case Token.MINUS: return visit(node.left) - visit(node.right);
        case Token.MULTIPLY: return visit(node.left) * visit(node.right);
        case Token.DIVIDE: return visit(node.left) / visit(node.right);
        default: throw new RuntimeException("InterpreterException, unexpected binary node: " + node);
      }
    }

    private int visitUnaryOperatorNode(UnaryOperatorNode node) {
      switch (node.token.type) {
        case Token.PLUS: return visit(node.expr);
        case Token.MINUS: return -1 * visit(node.expr);
        default: throw new RuntimeException("InterpreterException, unexpected unary node: " + node);
      }
    }

    private int visitNumberNode(NumberNode node) {
      return Integer.parseInt(node.token.value);
    }

    public int interpret() {
      return visit(mParser.parse());
    }

  }

}
