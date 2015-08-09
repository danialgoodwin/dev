/**
 * Created by Danial on 4/25/2015.
 */
package com.danialgoodwin.projecteuler.question;

/** Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

 21 22 23 24 25
 20  7  8  9 10
 19  6  1  2 11
 18  5  4  3 12
 17 16 15 14 13

 It can be verified that the sum of the numbers on the diagonals is 101.

 What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 *
 * Website: https://projecteuler.net/problem=28
 */
public class Q28_NumberSpiralDiagonals extends Question {

    @Override
    protected String getQuestionName() {
        return "Q28_NumberSpiralDiagonals";
    }

    @Override
    public void solve() {
        long answer = getSumOfDiagonalNumbersInSpiral();
        log("answer=" + answer);
    }

    // Thought process: The numbers that are on the diagonals follow a sequence of increasing
    // numbers from the numbers in the center. After increasing four times at the same rate, the
    // rate is increased by two 2 for the next spiral. This calculation would be done in linear time.
    // A possibly faster solution would be to see that the four numbers in each sprial's square
    // can be calculated with a multiplication and division instead of multiple addition. Then,
    // if the center stays a constant number, then it's possible that a constant-time solution could
    // be found with a nice multiplication.
    /** Return the sum of the numbers on the diagonals in a 1001 by 1001 spiral square.
     *
     * Space: O(1), time: O(n)
     * @return sum of numbers on diagonal
     */
    public static long getSumOfDiagonalNumbersInSpiral() {
        final int spiralWidthHeight = 1001;
        final int start = 1;
        final int numberOfSides = 4;
        final int end = spiralWidthHeight * spiralWidthHeight;
        long sum = start;
        for (int current = start, additive = 2; current < end; additive += 2) {
            for (int side = numberOfSides; side > 0; side--) {
                current += additive;
                sum += current;
            }
        }
        return sum;
    }

}
