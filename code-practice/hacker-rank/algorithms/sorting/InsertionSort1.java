// Source: https://www.hackerrank.com/challenges/insertionsort1
public class InsertionSort1 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int s = in.nextInt();
    int[] ar = new int[s];
    for(int i = 0; i < s; i++) {
      ar[i] = in.nextInt();
    }
    insertIntoSorted(ar);
  }

  public static void insertIntoSorted(int[] ar) {
    int length = ar.length;
    int v = ar[length - 1];
    for (int i = length - 1; i >= 0; i--) {
      if (i != 0 && v < ar[i - 1]) { // Shift.
        ar[i] = ar[i - 1];
        print(ar);
      } else { // Insert and stop.
        ar[i] = v;
        print(ar);
        break;
      }
    }
  }

  public static void print(int[] ar) {
    StringBuilder sb = new StringBuilder(ar.length * 2);
    for (int i : ar) {
      sb.append(i).append(" ");
    }
    System.out.println(sb.substring(0, sb.length() - 1));
  }

}
