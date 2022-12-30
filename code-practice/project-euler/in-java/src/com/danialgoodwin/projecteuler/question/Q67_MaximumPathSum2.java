/**
 * Created by Danial on 4/13/2015.
 */
package com.danialgoodwin.projecteuler.question;

import com.danialgoodwin.util.FileUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**By starting at the top of the triangle below and moving to adjacent numbers on the row below,
 * the maximum total from top to bottom is 23.

 3
 7 4
 2 4 6
 8 5 9 3

 That is, 3 + 7 + 4 + 9 = 23.

 Find the maximum total from top to bottom of the triangle in the text file.
 *
 * Website: https://projecteuler.net/problem=67
 */
public class Q67_MaximumPathSum2 extends Question {

    @Override
    protected String getQuestionName() {
        return "Q67_MaximumPathSum2";
    }

    @Override
    public void solve() {
        long answer;

        List<String> digits = null;
        try {
//            digits = FileUtils.readAllLines("src/com/danialgoodwin/projecteuler/sourcefile/q18-maximum-path-sum-1-sample.txt", StandardCharsets.UTF_8);
            digits = FileUtils.readAllLines("src/com/danialgoodwin/projecteuler/sourcefile/q67-maximum-path-sum-2.txt", StandardCharsets.UTF_8);
//            log("digits: " + digits.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        answer = getMaximumPathSum(digits);
        log("answer: " + answer);
    }

    /** Return the maximum total from top to bottom of the triangle of digits provided.
     * If the input is null or empty, then returns zero.
     *
     * Space: O(width), time: O(n)
     */
    private static long getMaximumPathSum(List<String> digits) {
        if (digits == null || digits.size() == 0)  { return 0; }
        int[] digitsInCurrentRow;
        int[] digitsInLowerRow = newArrayOfZeros(digits.get(digits.size() - 1).length());

        for (int i = digits.size() - 1; i >= 0; i--) {
            int length = digits.get(i).length();
            digitsInCurrentRow = convertStringOfDigits(digits.get(i));

            // Find and add the greater of the two lower digits for each current digit.
            mergeToMaximumPath(digitsInCurrentRow, digitsInLowerRow);

            digitsInLowerRow = digitsInCurrentRow;
        }

        return digitsInLowerRow[0];
    }

    // Array of lowerDigits should have a size one greater than size of topDigits.
    private static int[] mergeToMaximumPath(int[] topDigits, int[] lowerDigits) {
        int length = topDigits.length;
        for (int i = 0; i < length; i++) {
            int greaterOfLowerDigits = Math.max(lowerDigits[i], lowerDigits[i + 1]);
            topDigits[i] = topDigits[i] + greaterOfLowerDigits;
        }
        return topDigits;
    }

    /** Takes a string of space-separated digits and converts it to a int array.
     * @param digitsString single-space-separated digits
     * @return array of digits from string
     */
    private static int[] convertStringOfDigits(String digitsString) {
        String[] digitsStringArray = digitsString.split(" ");
        int[] digits = new int[digitsStringArray.length];
        for (int i = 0; i < digitsStringArray.length; i++) {
            digits[i] = Integer.parseInt(digitsStringArray[i]);
        }
        return digits;
    }

    /** Create a new array filled with zeros. If the input size is less than zero, then an empty
     *  array will be returned.
     * @param size the size of the array to return */
    private static int[] newArrayOfZeros(int size) {
        if (size < 0) { size = 0; }
        int[] zeros = new int[size];
        Arrays.fill(zeros, 0);
        return zeros;
    }

}
