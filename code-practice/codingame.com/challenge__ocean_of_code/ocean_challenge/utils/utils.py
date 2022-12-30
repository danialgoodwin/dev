from ..constants import DIRECTION_EAST, DIRECTION_SOUTH, DIRECTION_WEST, DIRECTION_NORTH


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

