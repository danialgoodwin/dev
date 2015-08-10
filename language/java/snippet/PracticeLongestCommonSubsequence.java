

public class PracticeLongestCommonSubsequence {

  public static void main(String[] args) {
    String a = "12345";
    String b = "13579";
    String lcs = getLongestCommonSubsequence(a, b);
    System.out.println("lcs=" + lcs);
  }

  // Note: An optimization could be to keep track of max number in first
  // double-loop then use that number for initial StringBuilder size.
  public static String getLongestCommonSubsequence(String a, String b) {
    if (a == null || b == null || a.isEmpty() || b.isEmpty()) { return ""; }

    int[][] lengths = new int[a.length() + 1][b.length() + 1];
    for (int i = 0; i < a.length(); i++) {
      for (int j = 0; j < b.length(); j++) {
        if (a.charAt(i) == b.charAt(j)) {
          lengths[i + 1][j + 1] = lengths[i][j] + 1;
        } else {
          lengths[i + 1][j + 1] = Math.max(lengths[i + 1][j], lengths[i][j + 1]);
        }
      }
    }

    // Read the substring from the table.
    StringBuilder sb = new StringBuilder();
    for (int x = a.length(), y = b.length(); x != 0 && y != 0; ) {
      if (lengths[x][y] == lengths[x - 1][y]) {
        x--;
      } else if (lengths[x][y] == lengths[x][y - 1]) {
        y--;
      } else {
        assert a.charAt(x - 1) == b.charAt(y - 1);
        sb.append(a.charAt(x - 1));
        x--;
        y--;
      }
    }

    return sb.reverse().toString();
  }

}
