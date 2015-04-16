/**
 * Created by Danial on 4/16/2015.
 */
package com.danialgoodwin.projecteuler.question;

import com.danialgoodwin.util.FactorUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

 For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

 Evaluate the sum of all the amicable numbers under 10000.
 *
 * Website: https://projecteuler.net/problem=21
 */
public class Q21_AmicableNumbers extends Question {

    @Override
    protected String getQuestionName() {
        return "Q21_AmicableNumbers";
    }

    @Override
    public void solve() {
        int low = 1;
        int high = 10000;
        int answer = getSumOfAmicableNumbers(low, high);
        log("answer=" + answer);
    }

    /** Return the sum of the amicable numbers for n. */
    private static int getSumOfAmicableNumbers(int lowBound, int highBound) {
        int sum = 0;
        for (Integer num : findAmicableNumbers(lowBound, highBound)) {
            sum += num;
        }
        return sum;
    }

    // Ideas:
    // - 1. Could brute force by checking all numbers from lower to higher and the number is points to
    //   - To optimize, could remember the sum for all the numbers that have been checked already.
    //   - Better optimization would be a boolean array so that each number is checked a max of one time.
    // - 2. Could calculate the amicable numbers starting from divisors themselves, there could be a
    //       system of equations to use. At first it could be brute forcing all the possible factor
    //       between lowBound and highBound, but could find some optimizations with even/odd, maybe
    //       more. Multiplying numbers should be faster than factorization, though we would also be
    //       considering more numbers this way.
    // For initial productivity/prototyping, seems quicker to just do the first, especially because
    // most of the needed functions are already available.
    /** Return list of amicable numbers. If none are found, then return an empty list.
     * @param lowBound lower bound, inclusive
     * @param highBound higher bound, exclusive
     */
    private static List<Integer> findAmicableNumbers(int lowBound, int highBound) {
        List<Integer> amicables = new ArrayList<>();
        int length = highBound - lowBound;
        boolean[] hasChecked = new boolean[length];
        Arrays.fill(hasChecked, false);

        for (int i = lowBound; i < highBound; i++) {
            int divisorSum;
            if (!hasChecked[i - lowBound]) {
                divisorSum = getSumOfDivisors(i);
                hasChecked[i - lowBound] = true;
            } else {
                // Has been checked already.
                continue;
            }

            // Only check possible values. Lower numbers have already been checked.
            if (divisorSum > i && divisorSum < length && !hasChecked[divisorSum - lowBound]) {
                int otherDivisorSum = getSumOfDivisors(divisorSum);
                if (otherDivisorSum == i) {
                    amicables.add(i);
                    amicables.add(divisorSum);
                }
            }
        }

        return amicables;
    }

    /** Return the sum of the proper divisors for n. Return 0 for n <= 1. */
    private static int getSumOfDivisors(int n) {
        int sum = 0;
        for (Integer num : getDivisors(n)) {
            sum += num;
        }
        return sum;
    }

    /** Return the proper divisors for n or an empty list is n <= 1. */
    private static List<Integer> getDivisors(int n) {
        List<Integer> divisors = FactorUtils.getAllFactors(n);
        if (!divisors.isEmpty()) {
            // Would just do remove(n), but it would be confused with remove(index) instead of
            // remove(Object). So, removing last instead because list is sorted.
            divisors.remove(divisors.size() - 1);
        }
        return divisors;
    }

}
