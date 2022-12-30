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

    def maybe_sonar(self, opp_potential_positions: []) -> Optional[int]:
        if self.is_used_sonar or self.sonar_cooldown: return None
        # Nah, just do it once as soon as possible
        # if len(opp_potential_positions) < 4: return None  # Arbitrary value
        # TODOv2: This can be improved to a grouping of possibilities
        opp_position = opp_potential_positions[len(opp_potential_positions) / 2]
        self.is_used_sonar = True
        return utils.get_sector(opp_position[0], opp_position[1])
