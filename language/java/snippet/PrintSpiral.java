public class PrintSpiral {

  public static void main(String[] args) {
    int[][] arr = {{1, 2, 3, 4, 5},
                    {6, 7, 8, 9, 10},
                    {11, 12, 13, 14, 15},
                    {16, 17, 18, 19, 20},
                    {21, 22, 23, 24, 25}};
    String spiralOrder = printSpriral(arr);
    System.out.println("spiralOrder=" + spiralOrder);
  }

  public static String printSpriral(int[][] arr) {
    int rowMin = 0;
    int colMin = 0;
    int rowMax = arr.length - 1;
    int colMax = arr[0].length - 1;
    int direction = 0; // right, down, left, up
    StringBuilder sb = new StringBuilder();
    for (int row = rowMin, col = colMin; rowMin <= rowMax && colMin <= colMax; ) {
      sb.append(arr[row][col]).append(" ");
      // Navigate direction.
      switch (direction) {
        case 0: if (col < colMax) { col++; } else { direction = 1; row++; rowMin++; } break;
        case 1: if (row < rowMax) { row++; } else { direction = 2; col--; colMax--; } break;
        case 2: if (col > colMin) { col--; } else { direction = 3; row--; rowMax--; } break;
        case 3: if (row > rowMin) { row--; } else { direction = 0; col++; colMin++; } break;
      }
    }
    return sb.toString();
  }
  
}
