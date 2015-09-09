// Source: https://www.hackerrank.com/challenges/diagonal-difference
public class DiagonalDifference {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int side = sc.nextInt();
    int d1 = 0;
    int d2 = 0;
    for (int x = 1; x <= side; x++) {
        for (int y = 1; y <= side; y++) {
            int val = sc.nextInt();
            if (x == y) { d1 += val; }
            if ((side - x + 1) == y) { d2 += val; }
        }
    }
    System.out.print(String.valueOf(Math.abs(d1 - d2)));
  }
}
