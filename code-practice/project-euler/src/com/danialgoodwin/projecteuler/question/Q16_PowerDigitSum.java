/**
 * Created by Danial on 4/6/2015.
 */
package com.danialgoodwin.projecteuler.question;

import java.math.BigInteger;

/** 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26. What is the sum of the digits of the number 2^1000?
 * Website: https://projecteuler.net/problem=16
 */
public class Q16_PowerDigitSum extends Question {

    @Override
    protected String getQuestionName() {
        return "Q16_PowerDigitSum";
    }

    @Override
    public void solve() {
        BigInteger num = new BigInteger("2").pow(1000);
        long answer = getSumOfDigits(num);
        log("answer=" + answer);
    }

    /** Return the sum of digits of the input number.
     * Space: O(n), time: O(n). An optimization in space would be to iterate through each character in the string
     * rather than using `toCharArray()` because that one creates a copy of the array backing. */
    private long getSumOfDigits(BigInteger num) {
        if (num == null) { return 0; }

        long sumOfDigits = 0;

        String digits = num.toString();
        for (char c : digits.toCharArray()) {
            sumOfDigits += Character.getNumericValue(c);
        }

        return sumOfDigits;
    }

}
