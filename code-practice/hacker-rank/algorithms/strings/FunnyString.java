// Source: https://www.hackerrank.com/challenges/funny-string
public class FunnyString {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    for (int i = 0; i < tests; i++) {
      boolean isFunny = isFunny(sc.next());
      System.out.println((isFunny? "" : "Not ") + "Funny");
    }
  }

  public static boolean isFunny(String in) {
    boolean isFunny = true;
    int length = in.length();
    for (int i = 0; i < length - 1; i++) {
      if (Math.abs(in.charAt(i) - in.charAt(i+1)) != Math.abs(in.charAt(length-i-1) - in.charAt(length-i-2))) {
          isFunny = false;
          break;
      }
    }
    return isFunny;
  }
}
