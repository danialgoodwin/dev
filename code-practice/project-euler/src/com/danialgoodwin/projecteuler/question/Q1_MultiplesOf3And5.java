/**
 * Created by Danial on 2014-08-30.
 */
package com.danialgoodwin.projecteuler.question;

/** Multiples of 3 and 5
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Q1_MultiplesOf3And5 extends Question {

    @Override
    protected String getQuestionName() {
        return "Q1_MultiplesOf3And5";
    }

    @Override
    public void solve() {
        int below = 1000;
        int answer = getSumOfAllMultiplesOf3And5_v1(below);
        log("V1 answer: " + answer);
        answer = getSumOfAllMultiplesOf3And5_v2(below);
        log("V2 answer: " + answer);
    }

    /**
     * Space: O(1), Time: O(n)
     * @param below find only multiples below this number
     * @return sum, which may overflow
     */
    private int getSumOfAllMultiplesOf3And5_v1(int below) {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     * Space: O(1), Time: O(n), but faster than v1 because this only iterates over the multiples and has no other checks.
     * @param below find only multiples below this number
     * @return sum, which may overflow
     */
    private int getSumOfAllMultiplesOf3And5_v2(int below) {
        int sum = 0;
        for (int i = 3; i < 1000; i += 3) {
            sum += i;
        }
        for (int i = 5; i < 1000; i += 15) {
            sum += i;
        }
        for (int i = 10; i < 1000; i += 15) {
            sum += i;
        }

        return sum;
    }

}
