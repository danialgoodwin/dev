# Same as calc-interpreter-3.py, with addition of parenthesis support.
# This includes lexer, then inpterpreter.
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

class Interpreter(object):
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
            return token.value
        elif token.type == BRACKET_START:
            self.eat(BRACKET_START)
            result = self.expr()
            self.eat(BRACKET_STOP)
            return result

    def term(self):
        result = self.factor()
        while self.current_token.type in (MULTIPLY, DIVIDE):
            token = self.current_token
            if token.type == MULTIPLY:
                self.eat(MULTIPLY)
                result *= self.factor()
            elif token.type == DIVIDE:
                self.eat(DIVIDE)
                result /= self.factor()
        return result

    def expr(self):
        result = self.term()
        while self.current_token.type in (PLUS, MINUS):
            token = self.current_token
            if token.type == PLUS:
                self.eat(PLUS)
                result += self.term()
            elif token.type == MINUS:
                self.eat(MINUS)
                result -= self.term()
        return result

def main():
    while True:
        try:
            text = raw_input('calc>')
        except EOFError:
            break
        if not text:
            continue
        lexer = Lexer(text)
        interpreter = Interpreter(lexer)
        result = interpreter.expr()
        print(result)

if __name__ == '__main__':
    main()
