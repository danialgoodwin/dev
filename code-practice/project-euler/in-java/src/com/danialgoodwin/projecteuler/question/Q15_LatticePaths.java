/**
 * Created by Danial on 3/30/2015.
 */
package com.danialgoodwin.projecteuler.question;

import com.danialgoodwin.MathUtils;

import java.math.BigInteger;

/** Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are
 * exactly 6 routes to the bottom right corner. How many such routes are there through a 20x20 grid?
 *
 * Website: https://projecteuler.net/problem=15
 */
public class Q15_LatticePaths extends Question {

    @Override
    protected String getQuestionName() {
        return "Q15_LatticePaths";
    }

    @Override
    public void solve() {
        int width = 20;
        int height = 20;
        BigInteger answer = getNumberOfLatticePaths(width, height);
        log("answer: " + answer.toString());
    }

    /** Return the number of unique lattice/edge paths from corner to corner on a grid of squares.
     * Note: The sum of width and height currently must be less than MAX_LONG, otherwise
     * an IllegalArgumentException will be thrown.
     *
     * Thought process: Combinatorics class of problem. Use nCr equation that matches Pascal's triangle: n! / r!((n-r)!)
     *
     * Space: O(n), time: O(n). Bits are allocated for BigInteger for doing factorial. Though, much less than using
     * an iterative or recursive solution. Current implementation could be improved by pre-simplifying the expression
     * before calling the factorial method.
     * @param width must be greater than 0
     * @param height must be greater than 0
     * @return number of paths, or 0 if invalid inputs
     */
    private static BigInteger getNumberOfLatticePaths(int width, int height) {
        if (width < 0 || height < 0) { return BigInteger.ZERO; }
        if (width == 0 || height == 0) { return BigInteger.ONE; }
        if (width + height < 0) { throw new IllegalArgumentException("Sum of input currently must be less than LONG_MAX"); }

        long n = width + height;
        long r = width; // Arbitrarily choose either width or height, result would be same.
//        long numPaths = MathUtils.factorial(r + 1, n) / MathUtils.factorial(n - r);
//        long numPaths = MathUtils.factorial(n) / (MathUtils.factorial(r) * MathUtils.factorial(n - r));
        BigInteger numPaths = MathUtils.factorial(n).divide(MathUtils.factorial(r).multiply(MathUtils.factorial(n - r)));
        return numPaths;
    }

}
