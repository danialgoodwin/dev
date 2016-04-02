# Minimal calculator interpreter to take input of two single digit integers
# with an addition sign between the numbers. No whitespace allowed.
# More Info: https://ruslanspivak.com/lsbasi-part1/

# Token types
INTEGER, PLUS, EOF = 'INTEGER', 'PLUS', 'EOF'

class Token(object):
    def __init__(self, token_type, value):
        # token type: INTEGER, PLUS, EOF
        self.type = token_type
        # token value: 0-9 or + or None
        self.value = value

    def __str__(self):
        """String representation of the class instance.

        Examples:
            Token(INTEGER, 3)
            Token(PLUS, '+')
        """
        return 'Token({type}, {value})'.format(
            type=self.type,
            value=repr(self.value)
        )

    def __repr__(self):
        return self.__str__()

class Interpreter(object):
    def __init__(self, text):
        # client string input, e.g. "3+5"
        self.text = text
        # self.pos is an index into self.text
        self.pos = 0
        # current token instance
        self.current_token = None

    def error(self):
        raise Exception('Error parsing input')

    def get_next_token(self):
        """Lexical analyzer (also known as scanner or tokenizer).

        This method is responsible for breaking a sentence apart into tokens.
        One token at a time.
        """
        text = self.text

        # if self.pos index is past the end of the self.text, then return EOF
        # token because there is no more input left to convert into tokens
        if self.pos > len(text) - 1:
            return Token(EOF, None)

        # get a character at the position self.pos and decide what token to
        # create based on the single character
        current_char = text[self.pos]

        # if the character is a digit then convert it to an integer, create
        # an INTEGER token, increment self.pos index to point to the next
        # character after the digit and return the INTEGER token
        if current_char.isdigit():
            digit_start_index = self.pos
            digit_stop_index = self.pos + 1
            while digit_stop_index < len(text) and text[digit_stop_index].isdigit():
                digit_stop_index += 1
            token = Token(INTEGER, int(text[digit_start_index:digit_stop_index]))
            self.pos = digit_stop_index
            return token

        if current_char == '+':
            token = Token(PLUS, current_char)
            self.pos += 1
            return token

        self.error()

    def eat(self, token_type):
        # compare the current token type with the passed token type and if they
        # match then "eat" the current token and assign the next token to the
        # self.current_token, otherwise raise an exception.
        if self.current_token.type == token_type:
            self.current_token = self.get_next_token()
        else:
            self.error()

    def expr(self):
        """expr -> INTEGER PLUS INTEGER"""
        # set current token to the first token taken from the input
        self.current_token = self.get_next_token()

        # we expect the current token to be a single-digit integer
        left = self.current_token
        self.eat(INTEGER)

        # we expect the current token to be a '+' token now
        op = self.current_token
        self.eat(PLUS)

        # we expect the current token to be a single-digit integer now
        right = self.current_token
        self.eat(INTEGER)
        # after the above call the self.current_token is set to EOF token

        # at this point INTEGER PLUS INTEGER sequence of tokens has been
        # successfully found and the method can just return the result of
        # adding two integers, thus effectively interpreting client input
        result = left.value + right.value
        return result

def main():
    while True:
        try:
            # To run under Python3 replace 'raw_input' call with 'input'
            try:
                text = raw_input('calc> ')
            except NameError:  # Python3
                text = input('calc> ')
        except EOFError:
            print('EOFError')
            break
        if not text:
            continue
        interpreter = Interpreter(text)
        result = interpreter.expr()
        print(result)

def test():
    interpreter = Interpreter('3+5')
    print(interpreter.get_next_token())
    print(interpreter.get_next_token())
    print(interpreter.get_next_token())
    print(interpreter.get_next_token())
    print(interpreter.get_next_token())

if __name__ == '__main__':
    test()
    main()
