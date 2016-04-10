# Same as calc-interpreter-4.py, except using AST (Abstract Syntax Tree).
# This includes lexer, then parser, then inpterpreter.
# Calculation interpreter implemented following a grammer:
#     expr: term ((PLUS | MINUS) term)*
#     term: factor ((MUL | DIV) factor)*
#     factor: INTEGER | BRACKET_START expr BRACKET_STOP

INTEGER, EOF = 'INTEGER', 'EOF'
PLUS, MINUS, MULTIPLY, DIVIDE = 'PLUS', 'MINUS', 'MULTIPLY', 'DIVIDE'
BRACKET_START, BRACKET_STOP = 'BRACKET_START', 'BRACKET_STOP'

class Token(object):
    def __init__(self, type, value):
        self.type = type
        self.value = value

class Lexer(object):
    def __init__(self, text):
        self.text = text
        self.pos = 0
        self.current_char = self.text[self.pos]

    def advance(self):
        self.pos += 1
        if self.pos >= len(self.text):
            self.current_char = None
        else:
            self.current_char = self.text[self.pos]

    def skip_whitespace(self):
        while self.current_char is not None and self.current_char.isspace():
            self.advance()

    def integer(self):
        result = ''
        while self.current_char is not None and self.current_char.isdigit():
            result += self.current_char
            self.advance()
        return int(result)

    def get_next_token(self):
        while self.current_char is not None:
            if self.current_char.isspace():
                self.skip_whitespace()
                continue

            if self.current_char.isdigit():
                return Token(INTEGER, self.integer())

            if self.current_char == '+':
                self.advance()
                return Token(PLUS, '+')

            if self.current_char == '-':
                self.advance()
                return Token(MINUS, '-')

            if self.current_char == '*':
                self.advance()
                return Token(MULTIPLY, '*')

            if self.current_char == '/':
                self.advance()
                return Token(DIVIDE, '/')

            if self.current_char == '[' or self.current_char == '(':
                self.advance()
                return Token(BRACKET_START, '[')

            if self.current_char == ']' or self.current_char == ')':
                self.advance()
                return Token(BRACKET_STOP, ']')

            raise Exception('LexerError, unexpected character: ' + current_char)
        return Token(EOF, None)

class AST(object):
    pass

class BinOp(AST):
    def __init__(self, left, op, right):
        self.left = left
        self.token = self.op = op
        self.right = right

class Num(AST):
    def __init__(self, token):
        self.token = token
        self.value = token.value

class Parser(object):
    def __init__(self, lexer):
        self.lexer = lexer
        self.current_token = self.lexer.get_next_token()

    def eat(self, token_type):
        if self.current_token.type == token_type:
            self.current_token = self.lexer.get_next_token()
        else:
            raise Exception('InterpreterError, unexpected type: ' + self.current_token)

    def factor(self):
        token = self.current_token
        if token.type == INTEGER:
            self.eat(INTEGER)
            return Num(token)
        elif token.type == BRACKET_START:
            self.eat(BRACKET_START)
            node = self.expr()
            self.eat(BRACKET_STOP)
            return node

    def term(self):
        node = self.factor()
        while self.current_token.type in (MULTIPLY, DIVIDE):
            token = self.current_token
            if token.type == MULTIPLY:
                self.eat(MULTIPLY)
            elif token.type == DIVIDE:
                self.eat(DIVIDE)
            node = BinOp(left=node, op=token, right=self.factor())
        return node

    def expr(self):
        node = self.term()
        while self.current_token.type in (PLUS, MINUS):
            token = self.current_token
            if token.type == PLUS:
                self.eat(PLUS)
            elif token.type == MINUS:
                self.eat(MINUS)
            node = BinOp(left=node, op=token, right=self.term())
        return node

    def parse(self):
        return self.expr()

# Interpreter

class NodeVisitor(object):
    def visit(self, node):
        method_name = 'visit_' + type(node).__name__
        visitor = getattr(self, method_name, self.generic_visit)
        return visitor(node)

    def generic_visit(self, node):
        raise Exception('No visit_{} method'.format(type(node).__name__))

class Interpreter(NodeVisitor):
    def __init__(self, parser):
        self.parser = parser

    def visit_BinOp(self, node):
        if node.op.type == PLUS:
            return '(+ ' + self.visit(node.left) + ' ' + self.visit(node.right) + ')'
        elif node.op.type == MINUS:
            return '(- ' + self.visit(node.left) + ' ' + self.visit(node.right) + ')'
        elif node.op.type == MULTIPLY:
            return '(* ' + self.visit(node.left) + ' ' + self.visit(node.right) + ')'
        elif node.op.type == DIVIDE:
            return '(/ ' + self.visit(node.left) + ' ' + self.visit(node.right) + ')'
        else:
            return '({op} {left} {right})'.format(
                left=left_val,
                right=right_val,
                op=node.op.value
            )


    def visit_Num(self, node):
        return str(node.value)

    def interpret(self):
        tree = self.parser.parse()
        return self.visit(tree)

def main():
    while True:
        try:
            text = raw_input('calc>')
        except EOFError:
            break
        if not text:
            continue
        lexer = Lexer(text)
        parser = Parser(lexer)
        interpreter = Interpreter(parser)
        result = interpreter.interpret()
        print(result)

if __name__ == '__main__':
    main()
