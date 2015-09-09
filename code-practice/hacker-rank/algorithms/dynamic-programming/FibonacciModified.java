// Source: https://www.hackerrank.com/challenges/fibonacci-modified
public class FibonacciModified {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int n = sc.nextInt();

    BigInteger aBig = BigInteger.valueOf((long) a);
    BigInteger bBig = BigInteger.valueOf((long) b);
    for (int i = 3; i <= n; i++) {
      BigInteger next = aBig.add(bBig.pow(2));
      aBig = bBig;
      bBig = next;
    }
    System.out.print(bBig.toString());
  }
}
