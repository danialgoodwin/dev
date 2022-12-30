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

