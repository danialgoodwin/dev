/**
 * Created by Danial on 2/9/2014.
 */
package com.danialgoodwin.util;

import java.util.LinkedList;

/** Static helper methods for determining factors of a number. */
public class FactorUtils {

    private static PrimeUtils mPrime = PrimeUtils.getInstance();

    /** No need to instantiate this class. */
    private FactorUtils() {}

    /** Returns all the prime factors in order from least to greatest. There
     * may be repeat factors. Ex: For 12, returns 2,2,3. Returns empty list
     * for numbers less than or equal to 1. */
    public static LinkedList<Integer> calculatePrimeFactors(int numberInput) {
        LinkedList<Integer> factors = new LinkedList<Integer>();

        for (int prime = 2, number = numberInput; number > 1; prime = mPrime.getNext(prime)) {
            while (number % prime == 0) {
                number /= prime;
                factors.add(prime);
            }
        }

        return factors;
    }

    /** The intuition for this is zigzagging up and right in a multiplication
     * chart until the value if found or is out of bounds. Chart is symmetrical,
     * so could also be seen as down and left instead. If factors are not found,
     * then returns empty list. (TODO: Eventually, we could distinguish for prime?)
     * @param number should be greater than four
     */
    public static LinkedList<Integer> calculateTwoFactorsViaLinearSearchUsingMultiplication(int number) {
        LinkedList<Integer> factors = new LinkedList<Integer>();
        if (number < 4) { return factors; }
        int indexX = (int) Math.sqrt(number);
        int indexY = indexX;
        while (indexX < Integer.MAX_VALUE && indexY > 0) {
            long mult = indexX * indexY; // Prevents edge-case overflow.
            if (mult < number) {
                indexX++;
            } else if (mult > number) {
                indexY--;
            } else {
                if (indexY != 1) { factors.add(indexY); } // Choosing smaller number first.
                factors.add(indexX);
                return factors;
            }
        }
        factors.add(indexX); // Adds the prime number to list.
        return factors;
    }

    /** The intuition for this is zigzagging up and right in a multiplication
     * chart until the value if found or is out of bounds. Chart is symmetrical,
     * so could also be seen as down and left instead. If factors are not found,
     * then returns empty list. (TODO: Eventually, we could distinguish for prime?)
     * @param number should be greater than four
     */
    public static LinkedList<Integer> calculateTwoFactorsViaLinearSearchUsingAddition(int number) {
        LinkedList<Integer> factors = new LinkedList<Integer>();
        if (number < 4) { return factors; }
        int indexX = (int) Math.sqrt(number);
        int indexY = indexX;
        long mult = indexX * indexY; // The long prevents edge-case overflow.
        while (indexX < Integer.MAX_VALUE && indexY > 0) {
            if (mult < number) {
                indexX++;
                mult += indexY;
            } else if (mult > number) {
                indexY--;
                mult -= indexX;
            } else {
                if (indexY != 1) { factors.add(indexY); } // Choosing smaller number first.
                factors.add(indexX);
                return factors;
            }
        }
        factors.add(indexX); // Adds the prime number to list.
        return factors;
    }

    /** Returns at most two factors of input. */
    public static LinkedList<Integer> calculateTwoFactorsViaPrimeFactorsSearch(int number) {
        LinkedList<Integer> factors = calculatePrimeFactors(number);

        // Debug/test only
        //for (int i = 0; i < factors.size() - i; i++) {
        //    for (int j = i; j < factors.size(); j++) {
        //        int mult = i * j;
        //        if (mult > 100000 && mult < 999999) {
        //            mult = 0;
        //        }
        //    }
        //}

        while (factors.size() > 2) {
            if (factors.get(0) > factors.get(1)) {
                factors.set(1, factors.get(1) * factors.get(2));
            } else {
                factors.set(0, factors.get(0) * factors.get(2));
            }
            factors.remove(2);
        }

        return factors;
    }

}