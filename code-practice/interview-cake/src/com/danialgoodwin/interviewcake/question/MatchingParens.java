/**
 * Created by Danial on 5/3/2015.
 */
package com.danialgoodwin.interviewcake.question;

/** I like parentheticals (a lot).
 "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing."

 Write a function that, given a sentence like the one above, along with the position of an opening parenthesis, finds the corresponding closing parenthesis.

 Example: if the example string above is input with the number 10 (position of the first parenthesis), the output should be 79 (position of the last parenthesis).
 *
 * Website: https://www.interviewcake.com/question/matching-parens
 */
public class MatchingParens extends Question {

    public static void main(String[] args) {
        String input = "ab(cde)f";
        System.out.println("input=" + input);
        System.out.println("answer=" + findMatchingParens(input, 2));
    }

    @Override
    protected String getQuestionName() {
        return "MatchingParens";
    }

    @Override
    public void solve() {
        main(null);
    }

    /** Return the index of the matching parenthesis, given the index of the open parenthesis.
     * Return -1 if a matching parenthesis isn't found.
     *
     * Idea: This could be improved by checking what type of parenthesis is at the supplied index,
     *       and if is a close-parenthesis, then check left instead of right.
     * Space: O(1), time: O(n)
     * @return index of matching parenthesis, or -1 if none
     */
    private static int findMatchingParens(String input, int openParenIndex) {
        int nestedCount = 1;
        int length = input.length();
        for (int i = openParenIndex + 1; i < length; i++) {
            if (input.charAt(i) == '(') {
                nestedCount++;
            } else if (input.charAt(i) == ')') {
                nestedCount--;
            }
            if (nestedCount == 0) { return i; }
        }
        return -1;
    }

    // Note: This is the old version counting from the beginning of input
    private static int findMatchingParens_OldVersion(String input, int openParenIndex) {
        int nestedCount = 0;
        int length = input.length();

        // Find out if firstParenIndex is nested
        for (int i = 0; i < openParenIndex; i++) {
            if (input.charAt(i) == '(') {
                nestedCount++;
            } else if (input.charAt(i) == ')') {
                nestedCount--;
            }
        }

        // Continue counting parens until match is found.
        for (int i = openParenIndex + 1; i < length; i++) {
            if (input.charAt(i) == '(') {
                nestedCount++;
            } else if (input.charAt(i) == ')') {
                nestedCount--;
            }
            if (nestedCount == 0) { return i; }
        }

        return -1;
    }

}
