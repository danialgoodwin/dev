import random
import sys


"""
C00=2,2,2,2,2,2,2,2,2,2
C01=104,16,16,2,2,2,2,2,2,108 (_,desc)
C10=6,6,6,2,2,2,2,2,2,4
C11=6,6,6,2,2,2,2,2,2,4
---
C000=14,14,14,2,2,2,2,2,2,6
C001=104,16,16,2,2,2,2,2,2,108
C011=104,16,16,2,2,2,2,2,2,108
---
C0010=104,16,16,2,2,2,2,2,2,108
C0011=2,104,2,2,2,106,104,104,2
C0011=2,4,104,2,2,2,2,2,2,2
C0011=2,2,108,104,104,2,2,2,2,8
---
C0010=104,16,16,10,112,6,10,4,4,108
C1010=6,22,22,22,10,10,8,4,4,8
---
C00100=104,16,16,10,112,6,10,4,4,108
C00101=104,16,16,10,112,6,10,4,4,108
----------
# C3_IS_ACT_ON_DISTANCE_1 = False
C3_IS_ACT_ON_DISTANCE_1 = True
----------
----------
----------
C0000=2,2,2,10,10,10,6,4,4,2
C0010=104,16, 16,10,112,6, 10,4,  4,  108
C0020=2,  104,2, 10,10, 18,18,106,106,2
C0030=10,10, 18,18,106,106,2
C0110=104,16, 16,2,114,110,114,106,106,108
C0120=2,  104,2, 2,12,10,12,6,6,2
"""

C1_VALID_C = '_'  # high (>100) 2, 5, 7, 8, 9; low (<30): 1, 3, 6, 10
# C1_VALID_C = '#'  # high (>100) 2, 5, 7, 8, 9; low (<30): 1, 3, 6, 10

# C2_IS_ASCENDING = False
C2_IS_ASCENDING = True

# C3_MODE_AT_DISTANCE_1 = None
C3_MODE_AT_DISTANCE_1 = 'E'                 # 10#_#_,11__#_,42#_#_
# C3_MODE_AT_DISTANCE_1 = 'self'              # 10#_#_,44#_#_,70#_#_
# C3_MODE_AT_DISTANCE_1 = 'self-except-#__#'

C4_IS_RANDOM_BACKUP_MOVE = False
# C4_IS_RANDOM_BACKUP_MOVE = True

# C5_IS_ACT_ON_p__p = False
# C5_IS_ACT_ON_p__p = True



KEY = {' ': 'A', 'A': 'B', 'B': 'C', 'C': 'D', 'D': 'E', 'E': 'E'}


def debug(message: str):
    print(message, file=sys.stderr)


def pretty_board(board: []):
    s = ''
    for row in board:
        s += '    ' + str(''.join(row)) + '\n'
    return s


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


def main():
    width = int(input())
    height = int(input())
    third_init_input = int(input())

    board = create_board(width, height, ' ', border=' ')
    debug(f'board={len(board[0])}x{len(board)}')

    turn = 0
    while True:
        i1 = input()
        i2 = input()
        i3 = input()
        i4 = input()

        i_s = f'{i1}{i2}{i3}{i4}'

        p = [[0, 0]] * third_init_input
        d = [('', 0)] * (third_init_input - 1)
        valid_moves = []
        if i1 == C1_VALID_C:
            valid_moves.append('A')
        if i2 == C1_VALID_C:
            valid_moves.append('B')
        if i3 == C1_VALID_C:
            valid_moves.append('C')
        if i4 == C1_VALID_C:
            valid_moves.append('D')

        for i in range(third_init_input):
            p[i] = [int(j) for j in input().split()]
            y, x = p[i]
            board[y][x] = KEY[board[y][x]]

        for i in range(third_init_input - 1):
            d[i] = 'ABCDE'[i], abs(p[i][0] - p[4][0]) + abs(p[i][1] - p[4][1])

        d.sort(key=lambda t: t[1], reverse=not C2_IS_ASCENDING)

        choice = random.choice(['A', 'B', 'C', 'D', 'E']) if C4_IS_RANDOM_BACKUP_MOVE else 'E'
        if d[0 if C2_IS_ASCENDING else 3][1] == 1:
            if C3_MODE_AT_DISTANCE_1 == 'E':
                choice = 'E'
            elif C3_MODE_AT_DISTANCE_1 == 'self-except-#__#':
                if i_s == '#__#':
                    for x in d:
                        if x[0] in valid_moves:
                            choice = x[0]
                            break
                else:
                    choice = d[0 if C2_IS_ASCENDING else 3][0]
            elif C3_MODE_AT_DISTANCE_1 == 'self':
                choice = d[0 if C2_IS_ASCENDING else 3][0]
            else:
                for x in d:
                    if x[0] in valid_moves:
                        choice = x[0]
                        break
        else:
            for x in d:
                if x[0] in valid_moves:
                    choice = x[0]
                    break

        debug(i_s)
        debug(f'choice={choice}')
        debug(f'd={d}')
        debug(f'board=\n{pretty_board(board)}')

        print(choice)
        # print(new_move)
        # print('ABCDE'[turn % 5])
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




