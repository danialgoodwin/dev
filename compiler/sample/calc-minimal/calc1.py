# More info: http://ruslanspivak.com/lsbasi-part1/
# Usage: Run `python calc.py`, then input "3+4".
# Note: This minimal interpreter only accepts plus sign and single-digit integers.

INTEGER = 'INTEGER'
PLUS = 'PLUS'
EOF = 'EOF' # Indicates that there is no more input left to analyze

class Token(object):
    def __init__(self, type, value):
        self.type = type # One of INTEGER, PLUS, EOF
        self.value = value # One of 0-9, +, or None

    def __str__(self):
        """String representation of this instance."""
        return 'Token({type}, {value})'.format(type=self.type, value=repr(self.value))

    def __repr__(self):
        return self.__str__()


class Interpreter(object):
    def __init__(self, text):
        self.text = text # The input, eg '3+5'
        self.pos = 0 # Index of self.text
        self.current_token = None

    def error(self):
        raise Exception('Error parsing input')

    def get_next_token(self):
        """Lexical analyzer (aka scanner or tokenizer)"""
        text = self.text

        # Check if there is still more input to analyze
        if self.pos > len(text) - 1:
            return Token(EOF, None)

        current_char = text[self.pos]

        if current_char.isdigit():
            token = Token(INTEGER, int(current_char))
            self.pos += 1
            return token

        if current_char == '+':
            token = Token(PLUS, current_char)
            self.pos += 1
            return token

        self.error()

    def eat(self, token_type):
        if self.current_token.type == token_type:
            self.current_token = self.get_next_token()
        else:
            self.error()

    def expr(self):
        """expr -> INTEGER PLUS INTEGER"""
        self.current_token = self.get_next_token()

        # Check that first token is single-digit integer
        left = self.current_token
        self.eat(INTEGER)

        # Check that the next token is a PLUS token
        op = self.current_token
        self.eat(PLUS)

        # Check that the last token is a signle-digit integer
        right = self.current_token
        self.eat(INTEGER)

        # Now, the self.current_token should be set to EOF

        result = left.value + right.value
        return result

def main():
    while True:
        try:
            # For Python 3, replace `raw_input` with `input`
            text = raw_input('calc> ')
        except EOFError:
            break
        if not text:
            continue
        interpreter = Interpreter(text)
        result = interpreter.expr()
        print(result)

if __name__ == '__main__':
    main()
