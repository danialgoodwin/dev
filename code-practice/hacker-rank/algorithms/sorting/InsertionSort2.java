// Source: https://www.hackerrank.com/challenges/insertionsort2
public class InsertionSort2 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int s = in.nextInt();
    int[] ar = new int[s];
    for (int i = 0; i < s; i++) {
      ar[i] = in.nextInt();
    }
    insertionSortPart2(ar);
  }

  public static void insertionSortPart2(int[] ar) {
    int length = ar.length;
    for (int i = 1; i < length; i++) {
      int v = ar[i];
      for (int j = i; j >= 0; j--) {
        if (j != 0 && v < ar[j - 1]) { // Shift
          ar[j] = ar[j - 1];
        } else { // Insert and break;
          ar[j] = v;
          break;
        }
      }
      print(ar);
    }
  }

  private static void print(int[] ar) {
    for (int n: ar) {
       System.out.print(n + " ");
    }
    System.out.println("");
  }

}
