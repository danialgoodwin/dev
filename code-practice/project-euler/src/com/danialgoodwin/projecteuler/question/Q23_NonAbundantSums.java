/**
 * Created by Danial on 4/17/2015.
 */
package com.danialgoodwin.projecteuler.question;

import com.danialgoodwin.util.FactorUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

/** A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

 A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

 As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

 Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 *
 * Website: https://projecteuler.net/problem=23
 */
public class Q23_NonAbundantSums extends Question {

    @Override
    protected String getQuestionName() {
        return "Q23_NonAbundantSums";
    }

    @Override
    public void solve() {
        long answer = calculateSumOfNumbersNotSumOfTwoAbundantNumbers();
        log("answer=" + answer);
    }

    private static long calculateSumOfNumbersNotSumOfTwoAbundantNumbers() {
        final int MAX = 28123; // Number provide by specs.
        boolean[] isSumOfTwoAbundantNumbers = new boolean[MAX];
        Arrays.fill(isSumOfTwoAbundantNumbers, false);
        List<Integer> abundantNumbers = getAbundantNumbers(1, MAX);
        for (Integer abundantNumber1 : abundantNumbers) {
            for (Integer abundantNumber2 : abundantNumbers) {
                if (abundantNumber1 + abundantNumber2 < MAX) {
                    isSumOfTwoAbundantNumbers[abundantNumber1 + abundantNumber2] = true;
                }
            }
        }

        // Calculate sum.
        int sum = 0;
        for (int i = 0; i < isSumOfTwoAbundantNumbers.length; i++) {
            boolean isSumOfTwoAbundantNumber = isSumOfTwoAbundantNumbers[i];
            if (!isSumOfTwoAbundantNumber) {
                sum += i;
            }
        }

        return sum;
    }

    /** Return list of abundant numbers between lowBound and highBound, inclusive. If none, then
     * return an empty list. */
    private static List<Integer> getAbundantNumbers(int lowBound, int highBound) {
        List<Integer> numbers = new ArrayList<>();
        for (int num = lowBound; num <= highBound; num++) {
            if (isAbundant(num)) { numbers.add(num); }
        }
        return numbers;
    }

    private static boolean isAbundant(int n) {
        int sum = 0;
        for (Integer divisor : FactorUtils.getDivisors(n)) {
            sum += divisor;
        }
        return sum > n;
    }

}
