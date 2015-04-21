/**
 * Created by Danial on 4/20/2015.
 */
package com.danialgoodwin.projecteuler.question;

import java.math.BigInteger;

/** The Fibonacci sequence is defined by the recurrence relation:

 Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 Hence the first 12 terms will be:

 F1 = 1
 F2 = 1
 F3 = 2
 F4 = 3
 F5 = 5
 F6 = 8
 F7 = 13
 F8 = 21
 F9 = 34
 F10 = 55
 F11 = 89
 F12 = 144
 The 12th term, F12, is the first term to contain three digits.

 What is the first term in the Fibonacci sequence to contain 1000 digits?
 *
 *
 * Website: https://projecteuler.net/problem=25
 */
public class Q25_1000DigitFibonacciNumber extends Question {

    @Override
    protected String getQuestionName() {
        return "Q24_1000DigitFibonacciNumber";
    }

    @Override
    public void solve() {
        int numDigits = 1000;
        long answer = getFirstFibonacciTermWithNdigits(numDigits);
        log("answer=" + answer);
    }

    /** Return the first term in the Fibonacci sequence to contain n digits, where n >= 1.
     * Space: O(1), time: O(n), though more accurately, the rate at which fibonacci increases. */
    private static long getFirstFibonacciTermWithNdigits(int numDigits) {
        if (numDigits <= 0) { throw new IllegalArgumentException("numDigits must be >= 1"); }
        if (numDigits >= String.valueOf(Long.MAX_VALUE).length()) { return getFirstFibonacciTermWithNdigitsLarge(numDigits); }

        long indexOfLeadTerm = 1;
        int leadTerm = 1;
        int previousTerm = 0;
        while (String.valueOf(leadTerm).length() < numDigits) {
            int temp = leadTerm;
            leadTerm += previousTerm;
            previousTerm = temp;
            indexOfLeadTerm++;
        }
        return indexOfLeadTerm;
    }

    /** Return the first term in the Fibonacci sequence to contain n digits, where n >= 1. */
    private static long getFirstFibonacciTermWithNdigitsLarge(int numDigits) {
        if (numDigits <= 0) { throw new IllegalArgumentException("numDigits must be >= 1"); }
        if (numDigits < String.valueOf(Long.MAX_VALUE).length()) { return getFirstFibonacciTermWithNdigits(numDigits); }

        long indexOfLeadTerm = 1;
        BigInteger leadTerm = BigInteger.ONE;
        BigInteger previousTerm = BigInteger.ZERO;
        while (String.valueOf(leadTerm).length() < numDigits) {
            BigInteger temp = leadTerm;
            leadTerm = leadTerm.add(previousTerm);
            previousTerm = temp;
            indexOfLeadTerm++;
        }
        return indexOfLeadTerm;
    }

}
