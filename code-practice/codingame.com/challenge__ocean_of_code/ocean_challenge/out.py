import sys
from types import ModuleType

class MockModule(ModuleType):
    def __init__(self, module_name, module_doc=None):
        ModuleType.__init__(self, module_name, module_doc)
        if '.' in module_name:
            package, module = module_name.rsplit('.', 1)
            get_mock_module(package).__path__ = []
            setattr(get_mock_module(package), module, self)

    def _initialize_(self, module_code):
        self.__dict__.update(module_code(self.__name__))
        self.__doc__ = module_code.__doc__

def get_mock_module(module_name):
    if module_name not in sys.modules:
        sys.modules[module_name] = MockModule(module_name)
    return sys.modules[module_name]

def modulize(module_name, dependencies=[]):
    for d in dependencies: get_mock_module(d)
    return get_mock_module(module_name)._initialize_

##===========================================================================##

@modulize('constants')
def _constants(__name__):
    ##----- Begin constants.py ---------------------------------------------------##
    # For dan-bot
    DEFAULT_RECURSION = 7  # Arbitrary-ish

    # Via game
    DEFAULT_HEALTH = 6
    TORPEDO_RANGE = 4
    SILENCE_RANGE = 4
    DIRECTION_WEST = 'W'
    DIRECTION_EAST = 'E'
    DIRECTION_NORTH = 'N'
    DIRECTION_SOUTH = 'S'
    POWER_TORPEDO = 'TORPEDO'
    POWER_SONAR = 'SONAR'
    POWER_MINE = 'MINE'
    POWER_SILENCE = 'SILENCE'
    ACTION_TRIGGER = 'TRIGGER'
    ACTION_SURFACE = 'SURFACE'
    ACTION_MOVE = 'MOVE'

    ##----- End constants.py -----------------------------------------------------##
    return locals()

@modulize('Tree')
def _Tree(__name__):
    ##----- Begin Tree.py --------------------------------------------------------##
    from typing import Optional
from .constants import DEFAULT_RECURSION


class Tree:
    def __init__(self, x: int = None, y: int = None, height: int = 1):
        self.x = x
        self.y = y
        self.height: int = height
        self.north: Optional[Tree] = None
        self.south: Optional[Tree] = None
        self.east: Optional[Tree] = None
        self.west: Optional[Tree] = None

    def __str__(self):
        return f'\n{" " * (DEFAULT_RECURSION - self.height)}Tree(x={self.x}, y={self.y}, height={self.height}, north={self.north}, south={self.south}, east={self.east}, west={self.west})'

    ##----- End Tree.py ----------------------------------------------------------##
    locals()

@modulize('utils.utils')
def _utils(__name__):
    ##----- Begin utils/utils.py -------------------------------------------------##
    from .constants import DIRECTION_EAST, DIRECTION_SOUTH, DIRECTION_WEST, DIRECTION_NORTH


def is_invalid_position(w: int, h: int, x: int, y: int) -> bool:
    if x < 0 or x >= w or y < 0 or y >= h: return False


def copy_board(board: []) -> []:
    return [x[:] for x in board]


def opposite_direction(dir: str) -> str:
    if dir == DIRECTION_EAST: return DIRECTION_WEST
    if dir == DIRECTION_WEST: return DIRECTION_EAST
    if dir == DIRECTION_NORTH: return DIRECTION_SOUTH
    if dir == DIRECTION_SOUTH: return DIRECTION_NORTH


def direction(from_x, from_y, to_x, to_y) -> []:
    x_distance = abs(from_x - to_x)
    y_distance = abs(from_y - to_y)
    x_direction = DIRECTION_EAST if from_x < to_x else DIRECTION_WEST
    y_direction = DIRECTION_SOUTH if from_y < to_y else DIRECTION_NORTH
    if x_distance > y_distance:
        return [x_direction, y_direction]
    else:
        return [y_direction, x_direction]


def distance(x1, y1, x2, y2) -> int:
    return abs(int(x1) - int(x2)) + abs(int(y1) - int(y2))


def get_sector(x, y) -> int:
    sector_side_size = 5
    x_sector_add = x // sector_side_size + 1
    y_sector_add = y // sector_side_size * 3
    return x_sector_add + y_sector_add


    ##----- End utils/utils.py ---------------------------------------------------##
    return locals()

@modulize('Board')
def _Board(__name__):
    ##----- Begin Board.py -------------------------------------------------------##
    from .utils import utils


class Board:
    def __init__(self, water: []):
        self.water: [] = water
        self.available: [] = utils.copy_board(water)
        self.w: int = len(water[0])
        self.h: int = len(water)

    def is_water(self, x: int, y: int) -> bool:
        if x < 0 or x >= self.w or y < 0 or y >= self.h: return False
        return self.water[y][x]

    def is_available(self, x: int, y: int) -> bool:
        if self.is_water(x, y): return False
        return self.available[y][x]

    def set_unavailable(self, x: int, y: int):
        self.available[y][x] = False

    def reset(self):
        self.available = utils.copy_board(self.water)

    ##----- End Board.py ---------------------------------------------------------##
    locals()

@modulize('Bot')
def _Bot(__name__):
    ##----- Begin Bot.py ---------------------------------------------------------##
    from .constants import DEFAULT_HEALTH
from .Board import Board

class Bot:
    def __init__(self, board: Board, start_health=6):
        self.health: int = start_health
        self.board: Board = board

    ##----- End Bot.py -----------------------------------------------------------##
    locals()

@modulize('Dan')
def _Dan(__name__):
    ##----- Begin Dan.py ---------------------------------------------------------##
    from typing import Optional

from .Tree import Tree
from .Bot import Bot
from .constants import POWER_SONAR, POWER_TORPEDO, POWER_SILENCE, POWER_MINE, SILENCE_RANGE, DIRECTION_EAST, \
    DIRECTION_NORTH, DIRECTION_SOUTH, DIRECTION_WEST
from .Board import Board
from .utils import utils


class Dan(Bot):
    def __init__(self, start_x: int, start_y: int, board: Board):
        super().__init__(board)
        self.position = Tree(start_x, start_y)
        board.set_unavailable(start_x, start_y)

        # Powers
        self.torpedo_cooldown = -1
        self.sonar_cooldown = -1
        self.silence_cooldown = -1
        self.mine_cooldown = -1
        self.mine_positions = []
        self.last_torpedo_position = None
        self.is_used_sonar = False

    def move(self, x: int, y: int):
        self.position.x = x
        self.position.y = y
        self.board.set_unavailable(x, y)

    def surface(self):
        self.board.reset()
        self.board.set_unavailable(self.position.x, self.position.y)

    def torpedo(self, x: int, y: int):
        self.last_torpedo_position = (x, y)

    def mine(self, direction: str):
        pass  # TODO

    def trigger(self, x: int, y: int):
        pass  # TODO

    def choose_power_to_charge(self) -> str:
        if not self.is_used_sonar and self.sonar_cooldown: return POWER_SONAR
        if len(self.mine_positions) < 3: return POWER_MINE
        if self.torpedo_cooldown: return POWER_TORPEDO
        if self.silence_cooldown: return POWER_SILENCE
        return POWER_MINE

    def maybe_silence(self, is_hit: bool, opp_potential_positions: []) -> (str, int):
        if not is_hit or self.silence_cooldown: return None
        # TODOv2: This can be improved to maybe head towards a grouping of possibilities
        opp_position = opp_potential_positions[0]
        opp_directions = utils.direction(self.position.x, self.position.y, opp_position[0], opp_position[1])
        opposite_directions = [utils.opposite_direction(opp_directions[0]), utils.opposite_direction(opp_directions[1])]

        for d in opp_directions.extend(opposite_directions):
            for dist in range(SILENCE_RANGE, 1, -1):
                if d == DIRECTION_EAST:
                    if self.board.is_available(self.position.x + dist, self.position.y): return DIRECTION_EAST, dist
                elif d == DIRECTION_WEST:
                    if self.board.is_available(self.position.x - dist, self.position.y): return DIRECTION_WEST, dist
                elif d == DIRECTION_SOUTH:
                    if self.board.is_available(self.position.x, self.position.y + dist): return DIRECTION_SOUTH, dist
                elif d == DIRECTION_NORTH:
                    if self.board.is_available(self.position.x, self.position.y - dist): return DIRECTION_NORTH, dist
        return None

    def maybe_sonar(self, opp_potential_positions: []) -> int:
        if self.is_used_sonar or self.sonar_cooldown: return None
        # Nah, just do it once as soon as possible
        # if len(opp_potential_positions) < 4: return None  # Arbitrary value
        # TODOv2: This can be improved to a grouping of possibilities
        opp_position = opp_potential_positions[len(opp_potential_positions) / 2]
        self.is_used_sonar = True
        return utils.get_sector(opp_position[0], opp_position[1])

    ##----- End Dan.py -----------------------------------------------------------##
    locals()

@modulize('Opponent')
def _Opponent(__name__):
    ##----- Begin Opponent.py ----------------------------------------------------##
    from .Bot import Bot
from .constants import DIRECTION_NORTH, DIRECTION_SOUTH, DIRECTION_EAST, DIRECTION_WEST, TORPEDO_RANGE, \
    SILENCE_RANGE
from .Board import Board
from .utils import utils


class Opponent(Bot):
    def __init__(self, board: Board):
        super().__init__(board)
        self.possible_positions = []  # TODO: This should be a set rather than list
        self.possible_mine_positions = utils.copy_board(self.board.water)
        self._initialize_possible_positions()

    def _initialize_possible_positions(self):
        positions = []
        for j in range(self.board.h):
            for i in range(self.board.w):
                if self.board.is_water(i, j):
                    positions.append((i, j))
        self.possible_positions = positions

    def moved(self, direction: str):
        new_possible_positions = []
        if direction == DIRECTION_NORTH:
            for p in self.possible_positions:
                if self.board.is_water(p[0], p[1] - 1):
                    new_possible_positions.append((p[0], p[1] - 1))
        elif direction == DIRECTION_SOUTH:
            for p in self.possible_positions:
                if self.board.is_water(p[0], p[1] + 1):
                    new_possible_positions.append((p[0], p[1] + 1))
        elif direction == DIRECTION_EAST:
            for p in self.possible_positions:
                if self.board.is_water(p[0] + 1, p[1]):
                    new_possible_positions.append((p[0] + 1, p[1]))
        elif direction == DIRECTION_WEST:
            for p in self.possible_positions:
                if self.board.is_water(p[0] - 1, p[1]):
                    new_possible_positions.append((p[0] - 1, p[1]))
        self.possible_positions = new_possible_positions

    def surfaced(self, sector: int):
        valid_x_min = ((sector - 1) % 3) * 5
        valid_x_max = valid_x_min + 4
        valid_y_min = ((sector - 1) // 3) * 5
        valid_y_max = valid_y_min + 4
        positions = []
        for p in self.possible_positions:
            if p[0] < valid_x_min or p[0] > valid_x_max or p[1] < valid_y_min or p[1] > valid_y_max:
                continue
            positions.append(p)
        self.possible_positions = positions

    def used_torpedo(self, x: int, y: int):
        positions = []
        for p in self.possible_positions:
            if utils.distance(x, y, p[0], p[1]) <= TORPEDO_RANGE:
                positions.append(p)
        self.possible_positions = positions

    def silenced(self):
        def silenced_possibilities(x: int, y: int) -> []:
            possibilities = []
            ranges = range(-SILENCE_RANGE, SILENCE_RANGE + 1)
            for i in ranges:
                if self.board.is_water(x + i, y):
                    possibilities.append((x + i, y))
            for i in ranges:
                if self.board.is_water(x, y + i):
                    possibilities.append((x, y + i))
            return possibilities

        positions = []
        for p in self.possible_positions:
            positions.extend(silenced_possibilities(p[0], p[1]))
        self.possible_positions = positions

    # TODOv2: Can be improved to discount more mines by keeping track of where the opponent was when the mine was placed
    def mine_triggered(self, x: int, y: int):
        self.possible_mine_positions[y][x] = False

    # TODO: This may have to check for surfaced() and not not move if so
    def direct_hit(self, x: int, y: int, direction: str):
        """This should be called before silenced()."""
        self.possible_positions = [(x, y)]
        self.moved(direction)

    def indirect_hit(self, x: int, y: int, direction: str):
        pass
        # positions = []
        # for p in self.possible_positions:
        #     pass
        # # TODO
        # return positions

    def get_possible_positions_in_torpedo_range(self, x, y) -> []:
        positions = []
        for p in self.possible_positions:
            if utils.distance(p[0], p[1], x, y) <= TORPEDO_RANGE:
                positions.append(p)
        positions.sort(key=lambda p: utils.distance(p[0], p[1], x, y), reverse=True)
        return positions


    ##----- End Opponent.py ------------------------------------------------------##
    locals()

@modulize('app')
def _app(__name__):
    ##----- Begin app.py ---------------------------------------------------------##
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

    ##----- End app.py -----------------------------------------------------------##
    locals()
