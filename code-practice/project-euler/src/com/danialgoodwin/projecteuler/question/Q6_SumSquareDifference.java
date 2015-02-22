/**
 * Created by Danial on 2014-10-03.
 */
package com.danialgoodwin.projecteuler.question;

/**
 * The sum of the squares of the first ten natural numbers is,
 *
 * 12 + 22 + ... + 102 = 385
 * The square of the sum of the first ten natural numbers is,
 *
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 - 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class Q6_SumSquareDifference extends Question {

    @Override
    protected String getQuestionName() {
        return "Q6_SumSquareDifference";
    }

    @Override
    public void solve() {
        int[] numbers = new int[100];
        for (int i = 0; i < 100; i++) {
            numbers[i] = i + 1;
        }

        long answer = getSumSquareDifference(numbers);
        System.out.println("Answer: " + answer);
    }

    /**
     * Solves via brute force.
     * Space: O(), time: O()
     * @param numbers list of numbers to compare
     * @return sum
     */
    private long getSumSquareDifference(int[] numbers) {
        long sumOfSquares = sumOfSquares(numbers);
        log("sumOfSquares: " + sumOfSquares);
        long squareOfSums = squareOfSums(numbers);
        log("squareOfSums: " + squareOfSums);
        return squareOfSums - sumOfSquares;
    }

    public static long sumOfSquares(int[] numbers) {
        long sumOfSquares = 0;
        for (int i : numbers) {
            sumOfSquares += (long) Math.pow(i, 2);
        }
        return sumOfSquares;
    }

    public static long squareOfSums(int[] numbers) {
        long sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        //noinspection UnnecessaryLocalVariable
        long squareOfSums = (long) Math.pow(sum, 2);
        return squareOfSums;
    }

}
