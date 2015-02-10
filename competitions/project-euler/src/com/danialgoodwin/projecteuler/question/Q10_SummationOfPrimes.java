/**
 * Created by Danial on 2014-02-10.
 */
package com.danialgoodwin.projecteuler.question;

import com.danialgoodwin.util.PrimeUtils;

import java.util.List;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 *
 * Answer: 142913828922
 */
public class Q10_SummationOfPrimes extends Question {

    private PrimeUtils mPrimeUtils;

    {
        mPrimeUtils = PrimeUtils.getInstance();
    }

    @Override
    protected String getQuestionName() {
        return "Q10_SummationOfPrimes";
    }

    @Override
    public void solve() {
        int max = 2000000 - 1;
        long answer = getSumOfPrimes(max);
        log("Answer: " + answer);
    }

    /**
     * Space: O(n), time: O(n)
     * @param max primes from 2 to this number
     * @return sum of primes up to below
     */
    private long getSumOfPrimes(int max) {
        long sum = 0;
        List<Integer> primes = mPrimeUtils.getPrimes(2, max);
        for (Integer prime : primes) {
            sum += prime;
        }
        return sum;
    }

}
