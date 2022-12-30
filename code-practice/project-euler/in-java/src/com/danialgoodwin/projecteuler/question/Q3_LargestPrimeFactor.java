/**
 * Created by Danial on 2014-08-31.
 */
package com.danialgoodwin.projecteuler.question;

import java.util.ArrayList;

/** Largest prime factor
 *
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143?
 */
public class Q3_LargestPrimeFactor extends Question {

    @Override
    protected String getQuestionName() {
        return "Q3_LargestPrimeFactor";
    }

    @Override
    public void solve() {
        long numberToFactor = 600851475143L;
        int answer = getLargestPrimeFactor_v1(numberToFactor);
        log("Q3 answer: " + answer);
        answer = getLargestPrimeFactor_v2(numberToFactor);
        log("Q3 answer: " + answer);
    }

    /**
     * This can be improved to work better with larger numbers.
     * Space: O(n), Time: O(n)
     * @param value the number to factor
     * @return prime factor
     */
    private int getLargestPrimeFactor_v1(final long value) {
        ArrayList<Integer> factors = getPrimeFactors(value);

        Integer largestPrimeFactor = Integer.MIN_VALUE;
        for (Integer factor : factors) {
            if (factor > largestPrimeFactor) {
                largestPrimeFactor = factor;
            }
        }

        return largestPrimeFactor;
    }

    /**
     * This can be improved to work better with larger numbers.
     * Space: O(n), Time: O(n), with better space than v1.
     * @param value the number to factor
     * @return prime factor
     */
    private int getLargestPrimeFactor_v2(final long value) {
        long numberToFactor = value;
        int largestPrimeFactor = Integer.MIN_VALUE;
        int numberToFactorSquareRoot = (int) Math.sqrt(numberToFactor);
        System.out.println("numberToFactorSquareRoot: " + numberToFactorSquareRoot);

        boolean[] primes = new boolean[numberToFactorSquareRoot];
        fillArrayMultiples(primes, 1, true);
        primes[0] = false;
        primes[1] = false;
        primes[2] = true;

        // Populate all elements with starting values.
        for (int i = 3; i < primes.length; i++) {
            primes[i] = (i % 2 != 0);
        }

        if (numberToFactor % 2 == 0) {
            largestPrimeFactor = 2;
            numberToFactor /= 2; // do-while.
            while (numberToFactor % 2 == 0) {
                numberToFactor /= 2;
            }
        }

        for (int i = 3; i <= numberToFactorSquareRoot && i <= numberToFactor; i += 2) {
            if (!primes[i]) { continue; }
            fillArrayMultiples(primes, i, false);
            if (numberToFactor % i == 0) {
                largestPrimeFactor = i;
                do {
                    numberToFactor /= i;
                } while (numberToFactor % i == 0);
            }
        }

        return largestPrimeFactor;
    }

    public static ArrayList<Integer> getPrimeFactors(long value) {
        ArrayList<Integer> primes = getOnlyPrimes(10000);
        ArrayList<Integer> factors = new ArrayList<Integer>();

        long numberToFactor = value;
        double numberToFactorSquareRoot = Math.sqrt(numberToFactor);
        for (int prime : primes) {
            if (prime > numberToFactorSquareRoot) {
                break;
            }
            if (numberToFactor % prime == 0) {
                factors.add(prime);
                numberToFactor /= prime; // Makes checks potentially easier.
            }
        }

        return factors;
    }

    /** Returns an array of only prime numbers up to max. */
    public static ArrayList<Integer> getOnlyPrimes(int max) {
        boolean[] primes = getPrimes(max);
        ArrayList<Integer> onlyPrimes = new ArrayList<Integer>();
        onlyPrimes.add(2);

        for (int i = 3; i < max; i += 2) {
            if (primes[i]) {
                onlyPrimes.add(i);
            }
        }

        return onlyPrimes;
    }

    /** Returns a table for whether or not all number up to input max are prime. */
    public static boolean[] getPrimes(int max) {
        boolean[] primes = new boolean[max];
        primes[0] = false;
        primes[1] = false;
        primes[2] = true;

        // Populate all elements with starting values.
        for (int i = 3; i < primes.length; i++) {
            primes[i] = (i % 2 != 0);
        }

        // Set prime and not prime for all values.
        for (int i = 3; i < max; i += 2) {
            if (primes[i]) {
                fillArrayMultiples(primes, i, false);
            }
        }

        return primes;
    }

    /** Fills elements of input multiples in input array with input value,
     * except for the input multiple itself is not changed. */
    public static void fillArrayMultiples(boolean[] array, int multiple, boolean value) {
        for (int i = multiple * 2; i < array.length; i += multiple) {
            array[i] = value;
        }
    }

    /** Fills elements of input multiples in input array with input value,
     * except for the input multiple itself is not changed. */
    public static void fillArrayMultiples(ArrayList<Boolean> array, int multiple, boolean value) {
        for (int i = multiple * 2; i < array.size(); i += multiple) {
            array.set(i, value);
        }
    }

    /** Fills all elements in input array with input value. */
    public static void fillArray(boolean[] array, boolean value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

}
