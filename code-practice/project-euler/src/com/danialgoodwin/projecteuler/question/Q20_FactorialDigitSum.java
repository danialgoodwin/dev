/**
 * Created by Danial on 4/14/2015.
 */
package com.danialgoodwin.projecteuler.question;

import com.danialgoodwin.MathUtils;

/** n! means n × (n − 1) × ... × 3 × 2 × 1

 For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

 Find the sum of the digits in the number 100!
 *
 * Website: https://projecteuler.net/problem=20
 */
public class Q20_FactorialDigitSum extends Question {

    @Override
    protected String getQuestionName() {
        return "Q20_FactorialDigitSum";
    }

    @Override
    public void solve() {
        int answer = factorialDigitSum(100);
        log("answer=" + answer);
    }

    /** Return the sum of the digits in the number n!. */
    private static int factorialDigitSum(int n) {
        int sum = 0;
        String value = MathUtils.factorial(n).toString();
        for (int i = value.length() - 1; i >= 0; i--) {
            sum += Character.digit(value.charAt(i), 10);
        }
        return sum;
    }

}
