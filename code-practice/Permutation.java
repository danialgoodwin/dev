import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {
  public static void main(String[] args) {
    permutate("abc");
  }

  public static List<String> permutate(String input) {
    List<String> perms = new ArrayList<>();
    permutateHelperWithList(perms, "", input);
    System.out.println("permsList=" + perms);
    System.out.println("permsSet.size=" + perms.size());

    Set<String> permsSet = new HashSet<>();
    permutateHelperWithSet(permsSet, "", input);
    System.out.println("permsSet=" + permsSet);
    System.out.println("permsSet.size=" + permsSet.size());

    Set<String> permsBack = new HashSet<>();
    permutateHelperViaBacktracking(permsBack, new StringBuilder(input), 0);
    System.out.println("permsBack=" + permsSet);
    System.out.println("permsBack.size=" + permsSet.size());

    return perms;
  }

  // Idea: Get permutations by filling one character at a time and removing it from remaining choices for next character to fill.
  // Note: Doesn't ignore repeat characters.. could just use a set for that.
  // Time: O(N!), can be made smaller by using more space to hold pre-calculated permutations.
  private static void permutateHelperWithList(List<String> perms, String first, String remaining) {
    if (remaining == null || remaining.isEmpty()) { return; }
    int length = remaining.length();
    if (length == 1) { perms.add(first + remaining); return; }

    for (int i = 0; i < length; i++) {
      String newFirst = first + String.valueOf(remaining.charAt(i));
      String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1, length);
      permutateHelperWithList(perms, newFirst, newRemaining);
    }
  }

  // Idea: Get permutations by filling one character at a time and removing it from remaining choices for next character to fill.
  // Time: O(N!), can be made smaller by using more space to hold pre-calculated permutations.
  private static void permutateHelperWithSet(Set<String> perms, String first, String remaining) {
    if (remaining == null || remaining.isEmpty()) { return; }
    int length = remaining.length();
    if (length == 1) { perms.add(first + remaining); return; }

    for (int i = 0; i < length; i++) {
      String newFirst = first + String.valueOf(remaining.charAt(i));
      String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1, length);
      permutateHelperWithSet(perms, newFirst, newRemaining);
    }
  }

  private static void permutateHelperViaBacktracking(Set<String> perms, StringBuilder input, int start) {
    int length = input.length();
    if (start == length - 1) { perms.add(input.toString()); return; }

    for (int i = start; i < length; i++) {
      swap(input, start, i);
      permutateHelperViaBacktracking(perms, input, start + 1);
      swap(input, start, i);
    }
  }

  private static StringBuilder swap(StringBuilder sb, int a, int b) {
    char swap = sb.charAt(a);
    sb.setCharAt(a, sb.charAt(b));
    sb.setCharAt(b, swap);
    return sb;
  }

}
