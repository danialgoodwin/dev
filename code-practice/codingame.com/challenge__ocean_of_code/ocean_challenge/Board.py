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
