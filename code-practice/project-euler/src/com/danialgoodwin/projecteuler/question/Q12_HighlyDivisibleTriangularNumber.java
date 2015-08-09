/**
 * Created by Danial on 3/2/2015.
 */
package com.danialgoodwin.projecteuler.question;

import com.danialgoodwin.util.FactorUtils;

import java.util.List;

/** What is the value of the first triangle number to have over five hundred divisors?
 * Source: https://projecteuler.net/problem=12 */
public class Q12_HighlyDivisibleTriangularNumber extends Question {

    @Override
    protected String getQuestionName() {
        return "Q12_HighlyDivisibleTriangularNumber";
    }

    @Override
    public void solve() {
        int numberOfFactors = 500;
        int answer = getHighlyDivisibleTriangularNumber(numberOfFactors);
        log("answer: " + answer);
    }

    /** Returns the first triangle number to have greater than the specified number of factors.
     * Space: O(n), time: O(n*n) */
    private int getHighlyDivisibleTriangularNumber(int numberOfFactors) {
        int triangleNumberIndex = 0;
        int triangleNumber = 0;
        int debugMaxFactors = 0;

        while (true) {
            // getNextTriangleNumber
            triangleNumberIndex++;
            triangleNumber += triangleNumberIndex;

            List<Integer> factors = FactorUtils.getAllFactors(triangleNumber);

            if (debugMaxFactors < factors.size()) {
                debugMaxFactors = factors.size();
                System.out.println("" + triangleNumberIndex + "=" + triangleNumber + "{size=" + debugMaxFactors + "}: " + factors);
            }

            if (factors.size() > numberOfFactors) { break; }
        }

        return triangleNumber;
    }

    private int getNumberOfFactors(int triangleNumber) {
        return FactorUtils.getAllFactors(triangleNumber).size();
    }

}
