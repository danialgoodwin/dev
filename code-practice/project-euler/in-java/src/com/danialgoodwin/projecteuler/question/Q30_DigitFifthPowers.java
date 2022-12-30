/**
 * Created by Danial on 4/30/2015.
 */
package com.danialgoodwin.projecteuler.question;

import java.util.ArrayList;
import java.util.List;

/** Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

 1634 = 14 + 64 + 34 + 44
 8208 = 84 + 24 + 04 + 84
 9474 = 94 + 44 + 74 + 44
 As 1 = 14 is not a sum it is not included.

 The sum of these numbers is 1634 + 8208 + 9474 = 19316.

 Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 *
 * Website: https://projecteuler.net/problem=30
 */
public class Q30_DigitFifthPowers extends Question {

    @Override
    protected String getQuestionName() {
        return "Q30_DigitFifthPowers";
    }

    @Override
    public void solve() {
        int power = 5;
        int lowBound = 2;
        int highBound = 1000000;
        long answer = getSumOfDigitPowers(power, lowBound, highBound);
        log("answer=" + answer);
    }

    // Solved via brute force checking each digit between lowBound and highBound.
    // Space: O(1), time: O(n * log n), where n is each number between highBound - lowBound, and
    //    the log n comes from summing of the digits in those numbers.
    public long getSumOfDigitPowers(int power, int lowBound, int highBound) {
        long sum = 0;
        List<Long> digitPowerSums = getDigitPowerSums(power, lowBound, highBound);
        for (Long i : digitPowerSums) {
            sum += i;
        }
        return sum;
    }

    private List<Long> getDigitPowerSums(int power, int lowBound, int highBound) {
        List<Long> digitPowerSums = new ArrayList<>();
        for (int i = lowBound; i < highBound; i++) {
            long digitPowerSum = getDigitPowerSum(i, power);
            if (digitPowerSum == i) {
                log("digitPowerSum=" + digitPowerSum);
                digitPowerSums.add(digitPowerSum);
            }
        }
        return digitPowerSums;
    }

    private long getDigitPowerSum(int value, int power) {
        int sum = 0;
        for (int newValue = value; newValue > 0; newValue /= 10) {
            int lastDigit = newValue % 10;
            sum += Math.round(Math.pow(lastDigit, power));
        }
        return sum;
    }

}
