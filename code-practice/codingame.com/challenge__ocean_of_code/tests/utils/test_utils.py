from ...ocean_challenge.utils import utils


def test_copy_board():
    a = [[1], [2], [3]]
    b = utils.copy_board(a)
    assert b == [[1], [2], [3]]
    b[0][0] = 42
    assert a == [[1], [2], [3]]
    assert b == [[42], [2], [3]]


def test_distance():
    assert utils.distance(0, 0, 2, 2) == 4
    assert utils.distance(0, 1, 1, 2) == 2
    assert utils.distance(2, 1, 1, 0) == 2


def test_get_sector():
    assert utils.get_sector(0, 0) == 1
    assert utils.get_sector(1, 1) == 1
    assert utils.get_sector(0, 4) == 1
    assert utils.get_sector(4, 4) == 1
    assert utils.get_sector(5, 4) == 2
    assert utils.get_sector(14, 0) == 3
    assert utils.get_sector(4, 5) == 4
    assert utils.get_sector(9, 9) == 5
    assert utils.get_sector(10, 9) == 6
    assert utils.get_sector(0, 14) == 7
    assert utils.get_sector(9, 10) == 8
    assert utils.get_sector(14, 14) == 9

