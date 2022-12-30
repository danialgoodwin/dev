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
