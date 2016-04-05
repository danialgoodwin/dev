# Calculation interpreter built peeking at example
# Supports simple plus and minus, ex: 1+2, 3-1

INTEGER, EOF = 'INTEGER', 'EOF'
PLUS, MINUS = 'PLUS', 'MINUS'

class Token(object):
    def __init__(self, token_type, value):
        self.type = token_type
        self.value = value

class Interpreter(object):
    def __init__(self, text):
        self.text = text
        self.pos = 0
        self.current_token = None

    def get_next_token(self):
        text = self.text
        if self.pos >= len(text):
            return Token(EOF, None)

        while text[self.pos].isspace():
            self.pos += 1
            if self.pos >= len(text):
                return Token(EOF, None)

        current_char = text[self.pos]

        if current_char.isdigit():
            digit_start_index = self.pos
            digit_stop_index = self.pos + 1
            while digit_stop_index < len(text) and text[digit_stop_index].isdigit():
                digit_stop_index += 1
            self.pos = digit_stop_index
            return Token(INTEGER, int(text[digit_start_index:digit_stop_index]))

        if current_char == '+':
            self.pos += 1
            return Token(PLUS, current_char)

        if current_char == '-':
            self.pos += 1
            return Token(MINUS, current_char)

        raise Exception('Parse error, unexpected input: ' + current_char)

    def run(self):
        first_token = self.get_next_token()
        if first_token.type != INTEGER:
            raise Exception('ParseError, expected integer')
        result = first_token.value
        self.current_token = self.get_next_token()
        while self.current_token.type in (PLUS, MINUS):
            if self.current_token.type == MINUS:
                result = result - self.get_next_token().value
            elif self.current_token.type == PLUS:
                result = result + self.get_next_token().value
            else:
                raise Exception('ParseError, expected + or -')
            self.current_token = self.get_next_token()

        return result

while True:
    try:
        user_input = raw_input('calc>')
    except EOFError:
        print('EOFError')
        break
    if not user_input:
        continue
    print(Interpreter(user_input).run())
