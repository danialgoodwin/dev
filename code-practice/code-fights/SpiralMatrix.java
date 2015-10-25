
/**
Fill the square matrix of the given size n spirally clockwise from the upper left corner with numbers from 1 to n * n.

Example:
For n = 3 the output should be

[[1,2,3],
[8,9,4],
[7,6,5]]
[input] integer n

The matrix size, 1 ≤ n ≤ 50.
[output] array.array.integer
           
More info: https://codefights.com/challenge/Y7os7Mwk6kKqMdRec
*/
int[][] SpiralMatrix(int n) {
  int[][] nums = new int[n][n];

  int direction = 0;

  int minRow = 0;
  int maxRow = n - 1;
  int minCol = 0;
  int maxCol = n - 1;
  int curRow = 0;
  int curCol = 0;

  int max = n * n;
  for (int i = 1; i <= max; i++) {
    nums[curRow][curCol] = i;

    switch (direction) {
      case 0: if (curCol == maxCol) { curRow++; minRow++; direction = 1; } else { curCol++; } break; // Go right
      case 1: if (curRow == maxRow) { curCol--; maxCol--; direction = 2; } else { curRow++; } break; // Go down
      case 2: if (curCol == minCol) { curRow--; maxRow--; direction = 3; } else { curCol--; } break; // Go left
      case 3: if (curRow == minRow) { curCol++; minCol++; direction = 0; } else { curRow--; } break; // Go up
    }
  }

  return nums;
}
