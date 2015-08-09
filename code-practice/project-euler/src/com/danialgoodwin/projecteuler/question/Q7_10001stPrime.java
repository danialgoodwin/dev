/**
 * Created by Danial on 2014-10-4..
 */
package com.danialgoodwin.projecteuler.question;

import com.danialgoodwin.util.PrimeUtils;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10001st prime number?
 */
public class Q7_10001stPrime extends Question {

    private static PrimeUtils mPrime = PrimeUtils.getInstance(10001);

    @Override
    protected String getQuestionName() {
        return "Q7_10001stPrime";
    }

    @Override
    public void solve() {
        int nthprime = 10001;
        int answer = getNthPrime(nthprime);
        log("Answer: " + answer);
    }

    /**
     * Space: O(), time: O()
     * @param position which prime
     * @return prime number at nth position
     */
    private int getNthPrime(int position) {
        //noinspection UnnecessaryLocalVariable
        int answer = mPrime.getNthPrime(10001);
        return answer;
    }

}
