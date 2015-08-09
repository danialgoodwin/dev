/**
 * Created by Danial on 3/10/2015.
 */
package com.danialgoodwin.projecteuler.question;

import com.danialgoodwin.util.FileUtils;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/** Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
 * Website: https://projecteuler.net/problem=13 */
public class Q13_LargeSum extends Question {

    @Override
    protected String getQuestionName() {
        return "Q13_LargeSum";
    }

    @Override
    public void solve() {
        String answer;

        List<String> digits = null;
        try {
            digits = FileUtils.readAllLines("src/com/danialgoodwin/projecteuler/sourcefile/q13-large-sum.txt", StandardCharsets.UTF_8);
//            log("digits: " + digits.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        answer = getFirstNDigitsOfSum(digits, 10);
        log("answer: " + answer);
    }

    /** Calculate the sum of the list of numbers, then return the first N digits.
     * Space: O(1), time: O(n). A speed improvement would be to only calculate the first 11-12 digits of each string,
     * theoretically. But, can't rely on that 100% because of large carry-over with so many numbers. So, would have to
     * to at least the first 15 digits to be even more sure of no carr-over propagation.
     * @param digitStrings list of digits to add, must be all numbers
     * @param numberOfDigits the number of first digits to return
     * @return first N digits of sum
     * @throws java.lang.NumberFormatException if there are any non-digits in the digitStrings list
     */
    public String getFirstNDigitsOfSum(List<String> digitStrings, int numberOfDigits) {
        if (digitStrings == null || digitStrings.isEmpty()) { return "0000000000"; }

        BigInteger bigSum = BigInteger.ZERO;
        for (String digitString : digitStrings) {
            bigSum = bigSum.add(new BigInteger(digitString));
        }
        String sumString = bigSum.toString();

        log("getFirstNDigitsOfSum(). bigSum=" + sumString);
        return sumString.substring(0, numberOfDigits);
    }

}
