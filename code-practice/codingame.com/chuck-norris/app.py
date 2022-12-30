# https://www.codingame.com/ide/puzzle/chuck-norris

import sys


def debug(message):
    print(message, file=sys.stderr)


message = input()
debug(f'message={message}')
s = ''
for c in message:
    debug(f'    c={c}, {ord(c):07b}')
    s += f'{ord(c):07b}'

debug(f's={s}')

i = 1
o = ''
t = ''
for c in s:
    if t == '':
        t = c
    elif t == c:
        i += 1
    else:
        o += '0 ' if t == '1' else '00 '
        o += '0' * i + ' '
        i = 1
        t = c

o += '0 ' if t == '1' else '00 '
o += '0' * i
print(o)
