/**
 * Created by Danial on 4/24/2015.
 */
package com.danialgoodwin.projecteuler.question;

import com.danialgoodwin.util.PrimeUtils;

/** Euler discovered the remarkable quadratic formula:

 n² + n + 41

 It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly divisible by 41.

 The incredible formula  n² − 79n + 1601 was discovered, which produces 80 primes for the consecutive values n = 0 to 79. The product of the coefficients, −79 and 1601, is −126479.

 Considering quadratics of the form:

 n² + an + b, where |a| < 1000 and |b| < 1000

 where |n| is the modulus/absolute value of n
 e.g. |11| = 11 and |−4| = 4
 Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0.
 *
 * Website: https://projecteuler.net/problem=27
 */
public class Q27_QuadraticPrimes extends Question {

    private static PrimeUtils mPrimeUtils = PrimeUtils.getInstance(10000);

    @Override
    protected String getQuestionName() {
        return "Q27_QuadraticPrimes";
    }

    @Override
    public void solve() {
        int maxA = 1000;
        int maxB = 1000;
        int answer = getProductOfCoefficientsForMaxQuadraticPrimes(maxA, maxB);
        log("answer=" + answer);
    }

    /** Return the product of coefficients, a and b, for the quadratic expression that products
     * the maximum number of primes for consecutive values of n.
     *
     * Space: O(1), time: O(n * m)
     * @param maxA max range for a, exclusive
     * @param maxB max range for b, exclusive
     * @return product
     */
    private static int getProductOfCoefficientsForMaxQuadraticPrimes(int maxA, int maxB) {
        int product = 0;
        int maxCount = 0;
        for (int a = -maxA + 1; a < maxA; a++) {
            for (int b = -maxB + 1; b < maxB; b++) {
                int n = 0;
                while (mPrimeUtils.isPrime(n * n + a * n + b)) {
                    n++;
                }
                if (maxCount < n) {
                    maxCount = n;
                    product = a * b;
//                    System.out.println("maxCount=" + maxCount + ", " + a + " * " + b + " = " + product);
                }
            }
        }
        return product;
    }

}
