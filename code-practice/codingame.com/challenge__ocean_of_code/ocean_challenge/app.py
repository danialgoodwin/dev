import logging
import random
import sys
from typing import Optional
from .constants import TORPEDO_RANGE, ACTION_MOVE, ACTION_SURFACE, ACTION_TRIGGER, POWER_TORPEDO, POWER_SONAR, POWER_SILENCE, POWER_MINE, DEFAULT_RECURSION
from .Tree import Tree
from .utils import utils
from .Dan import Dan
from .Opponent import Opponent
from .Board import Board

logging.basicConfig(level=logging.DEBUG)

shootable_torpedo_distances = [*range(-TORPEDO_RANGE, -1), *range(2, TORPEDO_RANGE + 1)]


def move_via_direction(start_x, start_y, direction: str, range) -> (int, int):
    if direction == 'N': return start_x, start_y - range
    if direction == 'S': return start_x, start_y + range
    if direction == 'E': return start_x + range, start_y
    return start_x, start_y


    # class Opponent:
    # TODOv2 Maybe use similar for mine action
    # def is_possible_position(self, x, y):
    #     for p in self.possible_positions:
    #         if p[0] == x and p[1] == y:
    #             return True
    #     return False



class Game:
    def __init__(self, water: [], x: int, y: int):
        self.water = water
        self.dan = Dan(x, y, Board(water))
        self.opp = Opponent(Board(water))
        self.width = len(water[0])
        self.height = len(water)

    def debug(self, message: str):
        print(f'({self.dan.position.x}, {self.dan.position.y}): {message}', file=sys.stderr)

    def update_opponent_position(self, opponent_orders: str, is_opp_direct_hit, is_opp_hit):
        """First get all the updates, then do something about it. This way, it will be easier to re-arrange the 'do
            something' part.
        """
        opp_actions = opponent_orders.split('|')
        direction = None
        sector = None
        is_use_mine = False
        is_initial_move = False
        if len(opp_actions) == 1 and len(opp_actions[0]) == 3:
            is_initial_move = True
        for action in opp_actions:
            tokens = action.split()
            if tokens[0] == ACTION_MOVE:
                direction = tokens[1]
            elif tokens[0] == ACTION_SURFACE:
                sector = tokens[1]
            elif tokens[0] == ACTION_TRIGGER:
                trigger_x = tokens[1]
                trigger_y = tokens[2]
            elif tokens[0] == POWER_TORPEDO:
                opp_torpedo_x = int(tokens[1])
                opp_torpedo_y = int(tokens[2])
                self.opp.used_torpedo(opp_torpedo_x, opp_torpedo_y)
            elif tokens[0] == POWER_SONAR:
                sonar_sector = tokens[1]
            elif tokens[0] == POWER_SILENCE:
                self.opp.silenced()
            elif tokens[0] == POWER_MINE:
                is_use_mine = True

        if is_opp_direct_hit:
            torpedo_x = self.dan.last_torpedo_position[0]
            torpedo_y = self.dan.last_torpedo_position[1]
            self.opp.direct_hit(torpedo_x, torpedo_y, direction)
        elif is_opp_hit:
            torpedo_x = self.dan.last_torpedo_position[0]
            torpedo_y = self.dan.last_torpedo_position[1]
            self.opp.indirect_hit(torpedo_x, torpedo_y, direction)
        elif sector:
            self.opp.surfaced(int(sector))
        elif direction:
            self.opp.moved(direction)
        elif is_initial_move:
            # Do nothing
            pass
        else:  # TODO: Did another action besides moving?
            # self.opp.surfaced(int(sector))
            pass

    def get_shot(self) -> (int, int):
        if self.dan.torpedo_cooldown: return None, None
        self.debug('Torpedo ready...')

        target_positions = self.opp.get_possible_positions_in_torpedo_range(self.dan.position.x, self.dan.position.y)
        self.debug(f'target_positions={target_positions}')
        if not target_positions:
            return None, None
        # Option 1: Shoot furthest target (eventually, depending on dan.health)
        if len(target_positions) == 1:
            return target_positions[0]
        # TODO: Option 2: Shoot largest grouping of targets
        # return target_positions[0]
        return None, None

    def debug_board(self, board: []):
        s = ''
        for row in board:
            s += f'\n    {row}'
        self.debug(f'{s}')

    @staticmethod
    def generate_moves(availability_board: [], start_x: int, start_y: int, max_recursion) -> Optional[Tree]:
        if max_recursion <= 0: return None
        if utils.is_invalid_position(len(availability_board[0]), len(availability_board), start_x, start_y): return None
        if not availability_board[start_y][start_x]: return None
        new_availability_board = utils.copy_board(availability_board)
        new_availability_board[start_y][start_x] = False
        tree = Tree()
        tree.north = Game.generate_moves(new_availability_board, start_x, start_y - 1, max_recursion - 1)
        tree.south = Game.generate_moves(new_availability_board, start_x, start_y + 1, max_recursion - 1)
        tree.east = Game.generate_moves(new_availability_board, start_x + 1, start_y, max_recursion - 1)
        tree.west = Game.generate_moves(new_availability_board, start_x - 1, start_y, max_recursion - 1)
        tree.x = start_x
        tree.y = start_y
        tree.height = max(
            tree.north.height if tree.north else 0,
            tree.south.height if tree.south else 0,
            tree.east.height if tree.east else 0,
            tree.west.height if tree.west else 0) + 1
        return tree

    def get_move(self) -> (Tree, str):
        available = utils.copy_board(self.dan.board.available)
        available[self.dan.position.y][self.dan.position.x] = True  # Workaround for generate_moves(...) checking for availability
        current_position = Game.generate_moves(available, self.dan.position.x, self.dan.position.y, DEFAULT_RECURSION)
        # self.debug(f'current_position={current_position}')
        max_height = 0
        next_position = current_position
        direction = None
        if current_position.north and current_position.north.height > max_height: max_height = current_position.north.height; next_position = current_position.north; direction = 'N'
        if current_position.east and current_position.east.height > max_height: max_height = current_position.east.height; next_position = current_position.east; direction = 'E'
        if current_position.south and current_position.south.height > max_height: max_height = current_position.south.height; next_position = current_position.south; direction = 'S'
        if current_position.west and current_position.west.height > max_height: max_height = current_position.west.height; next_position = current_position.west; direction = 'W'
        return next_position, direction

    def start(self):
        while True:
            x, y, my_life, opp_life, torpedo_cooldown, sonar_cooldown, silence_cooldown, mine_cooldown = [int(i) for i in input().split()]
            sonar_result = input()
            opponent_orders = input()
            is_opponent_direct_hit = self.opp.health - 2 == opp_life
            is_opponent_hit = self.opp.health - 1 == opp_life
            is_dan_hit = self.dan.health != my_life

            self.dan.health = my_life
            self.dan.position.x = x
            self.dan.position.y = y
            self.dan.torpedo_cooldown = torpedo_cooldown
            self.dan.sonar_cooldown = sonar_cooldown
            self.dan.silence_cooldown = silence_cooldown
            self.dan.mine_cooldown = mine_cooldown

            self.opp.health = opp_life
            self.update_opponent_position(opponent_orders, is_opponent_direct_hit, is_opponent_hit)

            self.debug(f'opp.possible_positions={self.opp.possible_positions}')

            dan_actions = []

            sonar_sector = self.dan.maybe_sonar(self.opp.possible_positions)
            if sonar_sector:
                perform_sonar_action = f'{POWER_SONAR} {sonar_sector}'
                dan_actions.append(perform_sonar_action)

            shot_x, shot_y = self.get_shot()
            if shot_x:
                self.dan.torpedo(shot_x, shot_y)
                perform_torpedo_action = f'{POWER_TORPEDO} {shot_x} {shot_y} | '
                # TODOv2: torpedo_action = f' | TORPEDO {shot_x} {shot_y}'
                dan_actions.append(perform_torpedo_action)

            silence_direction, silence_range = self.dan.maybe_silence(is_dan_hit, self.opp.possible_positions)
            if silence_direction:
                perform_silence_action = f'{POWER_SILENCE} {silence_direction} {silence_range}'
                dan_actions.append(perform_silence_action)
                dan_move = move_via_direction(self.dan.position.x, self.dan.position.y, silence_direction, silence_range)
                self.dan.move(dan_move[0], dan_move[1])

            next_position, direction = self.get_move()
            if direction:
                self.dan.move(next_position.x, next_position.y)
                perform_move_action = f'{ACTION_MOVE} {direction} {self.dan.choose_power_to_charge()}'
                dan_actions.append(perform_move_action)
            else:
                self.dan.surface()
                self.debug(f'No moves available')
                perform_move_action = ACTION_SURFACE
                dan_actions.append(perform_move_action)

            print(' | '.join(dan_actions))


def create_water_board() -> []:
    board = []
    width, height, my_id = [int(i) for i in input().split()]
    for i in range(height):
        line = input()
        row = []
        for c in line:
            row.append(c == '.')
        board.append(row)
    return board


def get_initial_position(water_board: []) -> (int, int):
    for i in range(10):
        x = random.randrange(len(water_board[0]))
        y = random.randrange(len(water_board))
        if water_board[y][x]:
            return x, y
    for x in range(len(water_board[0])):
        for y in range(len(water_board)):
            if water_board[y][x]:
                return x, y


def main():
    water_board = create_water_board()
    start_x, start_y = get_initial_position(water_board)
    print(f'{start_x} {start_y}')

    game = Game(water_board, start_x, start_y)
    game.start()


if __name__ == '__main__':
    main()
