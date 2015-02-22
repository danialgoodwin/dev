/**
 * Created by Danial on 2014-08-30.
 */
package com.danialgoodwin.projecteuler.question;

/** Even Fibonacci numbers
 *
 * Each new term in the Fibonacci sequence is generated by adding the previous
 * two terms. By starting with 1 and 2, the first 10 terms will be:
 *     1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * By considering the terms in the Fibonacci sequence whose values do not
 * exceed four million, find the sum of the even-valued terms.
 */
public class Q2_EvenFibonacciNumbers extends Question {

    @Override
    protected String getQuestionName() {
        return "Q2_EvenFibonacciNumbers";
    }

    @Override
    public void solve() {
        int max = 4000000;
        int answer = getSumOfEvenFibonacciNumbers(max);
        log("Q2 answer: " + answer);
    }

    /**
     * Space: O(1), Time: O(n).
     * @param max the maximum value for fibonacci numbers in sequence
     * @return sum, which may overflow
     */
    private int getSumOfEvenFibonacciNumbers(int max) {
        int sum = 0;
        int previousTerm = 1;
        int currentTerm = 1;
        while (currentTerm <= max) {
            if (currentTerm % 2 == 0) {
                sum += currentTerm;
            }
            int temp = currentTerm;
            currentTerm += previousTerm;
            previousTerm = temp;
        }

        return sum;
    }

}