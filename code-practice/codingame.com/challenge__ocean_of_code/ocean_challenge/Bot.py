from .constants import DEFAULT_HEALTH
from .Board import Board

class Bot:
    def __init__(self, board: Board, start_health=DEFAULT_HEALTH):
        self.health: int = start_health
        self.board: Board = board
