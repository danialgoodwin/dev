"""
If only 'A':
- TC1: score=16, turns=90, init=35,28,5,

If only 'B':
- TC1: score=2, turns=97, init=35,28,5

"""
import random
import sys

i1s = []
i2s = []
i3s = []
i4s = []
i5s = []
i6s = []


def get_t_f(value: bool) -> str:
    return 'T' if value else 'F'


def create_board(w: int, h: int, value, border=None) -> []:
    board = []
    for i in range(h):
        if i == 0 and border:
            board.append([border] * w)
        elif i == h - 1 and border:
            board.append([border] * w)
        else:
            if border:
                row = []
                row.append(border)
                row.extend([value] * (w-2))
                row.append(border)
                board.append(row)
            else:
                board.append([value] * w)
    return board

"""
Tried for TC6
_1248=2
#1248=2
#1234=2
_1234=8 with choices[(i_value - 1) % 5], 444106106106106106106106106106106106106106
_4321=2
_1234=2 with choices[(i_value - 0) % 5]
_1234=2 with choices[(i_value + 1) % 5]
_1122=2 with choices[(i_value + 1) % 5]
_1122=8 with choices[(i_value - 1) % 5], 333633333333333333333333
_1212=2 with choices[(i_value - 1) % 5]
#1122=8 with choices[(i_value - 1) % 5]
_1111=2
_1122=6, BCDEA, choices[(i_value - 1) % 5], 33366666666666666666666666666
_1122=2, CDEAB
_1122=2, DEABC
_1122=2, EABCD
_1122=6, BACDE
_1234=8, BACDE

Tried for TC10:
2, _1234, BACDE
2, _1234, ABCDE, +++, #_#_  __#_  __#_, 677777777777777777777777777777777777777777777777777777777777777777777
4, _1248, ABCDE, +++, #_#_  __#_  #_#_  __#_, 101110111011101110
2, #1248, ABCDE, +++, #_#_  __#_  __#_, 544444444
2, _1234, ABCDE, ***, #_#_  #_#_, 8888888888888888888888888888888888888888888888888888888888888888888888
6, _1248, ABCDE, ***, #_#_  __#_  #_#_  ##__  ##__, turns=121, 16161632323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232
"""
def get_i_value(c1, c2, c3, c4) -> int:
    def is_true(c):
        return c == '_'

    v1 = 1 if is_true(c1) else 0
    v2 = 2 if is_true(c2) else 0
    v3 = 3 if is_true(c3) else 0
    v4 = 4 if is_true(c4) else 0
    return v1 + v2 + v3 + v4
    # return v1 * v2 * v3 * v4


def get_choice(i_value: int) -> str:
    choices = ['A', 'B', 'C', 'D', 'E']
    return choices[(i_value - 1) % 5]

"""
TC10 WITH ##__  #_#_  #__#  _#_#  __#_  __##  #___
ABCDE, 2:70:BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB
AEBCD, 2:9:EDDDDDDDD
AEBDC, 4:9:ECDCDCDCD
AEDBC, 4:10:ECBBBBBBBB
AEDCC, 8:12:ECCCAAAAAAAA
BEADC, 4:9:ECDCDCDCD
BEDAC, 4:10:ECAAAAAAAA
BEDCA, 4:9:EAEAEAEAE
BEDCC, 8:12:ECCCBBBBBBBB
CEDAB, 2:9:EBBBBBBBB
CEDCC, 8:12:ECCCCCCCCCCC
DEDCC, 8:11:ECCCDCDCDCD
EDBCA, 2:70:DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD
EEACC, 12:14:ECCCEEDDDDDDDD, found __##
EEDCC, 12:14:ECCCEEDDDDDDDD, found __##
---
EEACCC, 22:18:ECCCEECCCCCDCDCDCD, found #___
EEACCE, 12:14:ECCCEEEEEEEEEE
EEDCCA, 12:13:ECCCEEAEAEAEA
EEDCCB, 12:14:ECCCEEBBBBBBBB
EEDCCC, 22:18:ECCCEECCCCCDCDCDCD, found #___
EEDCCD, 12:14:ECCCEEDDDDDDDD
EEDCCE, 12:14:ECCCEEEEEEEEEE
---
EEACCCA, 24:19:ECCCEECCCCCAEAEAEAE
EEACCCB, 22:19:ECCCEECCCCCBBBBBBBB
EEACCCC, 22:19:ECCCEECCCCCCCCCCCCC
EEACCCD, 22:18:ECCCEECCCCCDCDCDCD
EEACCCE, 28:21:ECCCEECCCCCEEEAEAEAEA
EEDCCCA, 24:19:ECCCEECCCCCAEAEAEAE
EEDCCCB, 22:19:ECCCEECCCCCBBBBBBBB
EEDCCCC, 22:19:ECCCEECCCCCCCCCCCCC
EEDCCCD, 22:18:ECCCEECCCCCDCDCDCD
EEDCCCE, 30:22:ECCCEECCCCCEEEDCDCDCDC

"""
def get_choice_v2(c1, c2, c3, c4) -> str:
    all = f'{c1}{c2}{c3}{c4}'
    if all == '##__': return 'E'
    if all == '#_#_': return 'E'
    if all == '#__#': return 'D'
    if all == '_#_#': return 'C'
    if all == '__#_': return 'C'
    if all == '__##': return 'C'
    if all == '#___': return 'E'
    # ---
    if all == '____': return 'A'
    # if all == '#_#_': return 'E'  # 1 # A=4:69:yes,              B=2:70:no, C=2:70:no,       D=2:70:no,      E=10:5:yes
    # if all == '__#_': return 'E'  # 2 # with E,     A=4:9:yes:#_#_, B=2:9:no,  C=8:12:yes:_#_#, D=2:9:no,       E=8:6:yes:EEEDCD
    # if all == '_#_#': return 'A'  # 3 # with EC_BD, A=4:10:no,      B=4:10:no, C=8:12:yes:_#_#, D=4:9:yes:__#_, E=4:10:no
    # if all == '##__': return 'B'  # 4 # A=::, B=::, C=::, D=::, E=::
    # if all == '#__#': return 'C'  # 5 # A=::, B=::, C=::, D=::, E=::
    # if all == '': return 'D'  # A=::, B=::, C=::, D=::, E=::
    return 'D'


"""
TC10:
140:134:DACDBEDDDAADEAAECBECCBCEEABBCACAAECBABBCCCABBBDACACCDDCDAAEDAACBADCBCCEDBBBACABADCACDCAAEAADDCBEDCCEBCDAAEAEDDDBBBACBDAECEDAACEACACBAD
140:68:DCCEDDAACBDDDCBEAECCBDBEAACADAAABCCCDACCAAAACEEEADBDCEBCCACDDCBECABC
124:126:CCCABEAACADDBACBDEDCABBEBEEEECBCDCBCBDADDDEDACCBDCCBBABECDCCCBCAEDCAABEEDBDBCBDDDDEADACBCAAACCCAECCEEDBAEEDDACBBBCCEECCCCBDDCA
114:67:CBBBEACDDBBAEABCBEBEDCBBCDCEAAACDCCCBEACCBEDEECBDDCDAECCBDEBBAEEBAC
108:7:EDBBEED
38:163:ABEDDBADEEEBEEEAAEDDACDCDBACBCEAADBBCABADADBCACDEBACACDBECCEAAACDBEDBCABADBAEEDBCAABCEDBDCDACCDCCEEECDDAEAADCDECDDEDACABDCACBBECECBDCADBBDBEBBBCAEADEADCBBCBACBCBCB
32:143:ADAEEDDEABCBCCAAACCCBADAAABBCDADCCABBBCDDAADBAAEBADBADAEABDBCBCECEBCCEDDEADABBDEBECABBDBCACBAEBACCEADCEEACADABCBEEBDCEBBBCABBCACEAEDBADBADCBDDB
28:148:BDBADAADEECAEDCADDCCBCDCECAACEECAABACEBEBEADACDBDADACDCCEADCEEAAEDDDBBBDADCDBAACAADDCADBCADABCCBBDEBEAECABDADABADADDAAACEEADEABEAAADECBBEBBBAEDACABB
16:42:CBAAAADACCCDBECCABBEBEEBCAEADEEDBECEAEADBC
14:65:ABECBBCCDDADDAEDBCEBBBDDCBABCEECBDCCBDDDEACBBEBEBDCCECBBCBCDCCADD
8:12:ECBBACABCAAA
8:11:EBBDECCACCB
8:8:DECDBDEB
6:10:EAEDCBDDCE
6:8:CEBECBDD
6:7:EEBEBBC
6:7:EEAECEE
4:8:EEBBCDDD
"""
def get_choice_v3() -> str:
    # return 'A'  # TC10:6:121
    # return 'B'  # TC10:2:70
    # return 'C'  # TC10:2:70
    # return 'D'  # TC10:2:70
    # return 'E'  # TC10:6:7
    choices = ['A', 'B', 'C', 'D', 'E']
    return random.choice(choices) # TC10:116:73,122:68,114:44


def get_choice_v4(turn: int) -> str:
    # sequence = 'EEEEEEE'  # TC10,6:7
    # sequence = 'EEEEEEA'  # TC10,106:8
    # sequence = 'EEEEEEAA'  # TC10,106:9
    # sequence = 'EEEEEEAAA'  # TC10,8:41
    # sequence = 'EEEEEEAAB'  # TC10,6:9
    # sequence = 'EEEEEEAAC'  # TC10,8:10
    # sequence = 'EEEEEEAAD'  # TC10,6:9 # end
    # sequence = 'EEEEEEAAD'  # TC4,108:999 # with E repeating
    # sequence = 'EEEEEEAAE'  # TC10,106:9 # end
    sequence = ''  # TC10, #
    # sequence = 'BADCECDCABEBBBAEBEAECCDEBEBCEECEDECDCACECDDEBBBBDCBEEBADEDCCEBBDDDDBAEA'  # TC10,114:71
    if turn >= len(sequence): return 'E'
    return sequence[turn]


def debug(message: str):
    print(message, file=sys.stderr)


def pretty_board(board: []):
    s = ''
    for row in board:
        s += '    ' + str(''.join(row)) + '\n'
    return s


def main():
    width = int(input())
    height = int(input())
    third_init_input = int(input())

    debug(f'width={width}')
    debug(f'height={height}')
    debug(f'third_init_input={third_init_input}')
    # board_all = [[' '] for x in range(width)] * height
    board_all = create_board(width, height, ' ', border='#')

    debug(f'board_all={len(board_all[0])}x{len(board_all)}')

    ivs = ''
    ias = ''
    i1s = ''
    i2s = ''
    i3s = ''
    i4s = ''
    i5s = [[''] for x in range(third_init_input)]
    i6s = [[''] for x in range(third_init_input)]
    i_start = [[''] for x in range(third_init_input)]
    input_56_change_real_direction = [[''] for x in range(third_init_input)]
    input_56_change_relative_direction = [[''] for x in range(third_init_input)]
    input_56_is_new = [[''] for x in range(third_init_input)]
    input_5_is_overlap_with_1234 = [[''] for x in range(third_init_input)]

    turn = 0
    while True:
        first_input = input()
        second_input = input()
        third_input = input()
        fourth_input = input()
        for i in range(third_init_input):
            y, x = [int(j) for j in input().split()]

            input_56_is_new[i].append(get_t_f(board_all[y][x] == ' '))

            board_all[y][x] = f'{i}'
            if turn == 0:
                i5s[i][0] = str(y)
                i6s[i][0] = str(x)
                i_start[i][0] = f'i{i}_start=({x}, {y})'
                i_start[i].append('')
                input_56_change_real_direction[i].append('-')
            else:
                i5s[i].append(str(y))
                i6s[i].append(str(x))
                if i5s[i][turn] != i5s[i][turn - 1] and i6s[i][turn] != i6s[i][turn - 1]:
                    input_56_change_real_direction[i].append('@')
                elif int(i5s[i][turn]) == int(i5s[i][turn - 1]) - 1:
                    input_56_change_real_direction[i].append('U')
                elif int(i5s[i][turn]) == int(i5s[i][turn - 1]) + 1:
                    input_56_change_real_direction[i].append('D')
                elif i5s[i][turn] != i5s[i][turn - 1]:
                    input_56_change_real_direction[i].append('Y')
                elif int(i6s[i][turn]) == int(i6s[i][turn - 1]) - 1:
                    input_56_change_real_direction[i].append('L')
                elif int(i6s[i][turn]) == int(i6s[i][turn - 1]) + 1:
                    input_56_change_real_direction[i].append('R')
                elif i6s[i][turn] != i6s[i][turn - 1]:
                    input_56_change_real_direction[i].append('X')
                else:
                    input_56_change_real_direction[i].append('_')
            i_start[i][1] = f'  >  stop=({x}, {y})'

        input_5_is_overlap_with_1234[0].append(get_t_f(i5s[4][turn] == i5s[0][turn] and i6s[4][turn] == i6s[0][turn]))
        input_5_is_overlap_with_1234[1].append(get_t_f(i5s[4][turn] == i5s[1][turn] and i6s[4][turn] == i6s[1][turn]))
        input_5_is_overlap_with_1234[2].append(get_t_f(i5s[4][turn] == i5s[2][turn] and i6s[4][turn] == i6s[2][turn]))
        input_5_is_overlap_with_1234[3].append(get_t_f(i5s[4][turn] == i5s[3][turn] and i6s[4][turn] == i6s[3][turn]))

        i_value = get_i_value(first_input, second_input, third_input, fourth_input)
        ivs += str(i_value)
        # debug(f'i_value={i_value} ')

        i1s += first_input
        i2s += second_input
        i3s += third_input
        i4s += fourth_input

        # choice = get_choice(i_value)
        # choice = get_choice_v2(first_input, second_input, third_input, fourth_input)
        # choice = get_choice_v3()
        choice = get_choice_v4(turn)
        ias += choice

        debug(f'i_start=\n{pretty_board(i_start)}')
        debug(f'i1s={i1s}')
        debug(f'i2s={i2s}')
        debug(f'i3s={i3s}')
        debug(f'i4s={i4s}')
        debug(f'ias={ias}')
        # debug(f'ivs={ivs}')
        debug(f'input_5_is_overlap_with_1234=\n{pretty_board(input_5_is_overlap_with_1234)}')
        debug(f'input_56_is_new=\n{pretty_board(input_56_is_new)}')
        debug(f'input_56_changes=\n{pretty_board(input_56_change_real_direction)}')
        debug(f'i5s=\n{pretty_board(i5s)}')
        debug(f'i6s=\n{pretty_board(i6s)}')
        debug(f'board_all=\n{pretty_board(board_all)}')

        print(choice)

        turn += 1


if __name__ == '__main__':
    try:
        main()
    except Exception as e:
        # e = sys.exc_info()[0]
        debug(f'e={e}')
        debug(f'e={repr(e)}')
    finally:
        debug(f'STOP')
