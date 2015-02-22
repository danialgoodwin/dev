/**
 * Created by Danial on 2014-09-16.
 */
package com.danialgoodwin.projecteuler.question;

import com.danialgoodwin.util.Stopwatch;

/**
 * A palindromic number reads the same both ways. The largest palindrome
 * made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Q4_LargestPalindromeProduct extends Question {

    @Override
    protected String getQuestionName() {
        return "Q4_LargestPalindromeProduct";
    }

    @Override
    public void solve() {
        Stopwatch timer = new Stopwatch();
        timer.start();
        int answer = getLargestPalindromeFromProductOfTwo3DigitNumbers_v2();
        log("solveViaSpecialized() time: " + timer.getLapTime()); // 1 ms.
        timer.reset();

        timer.start();
        answer = getLargestPalindromeFromProductOfTwo3DigitNumbers_v1();
        System.out.println("solveViaBruteForce() time: " + timer.getLapTime()); // 57 ms, 58 ms, 66 ms.
        timer.reset();

        timer.start();
        answer = getLargestPalindromeFromProductOfTwo3DigitNumbers_v2();
        System.out.println("solveViaSpecialized() time: " + timer.getLapTime()); // 1 ms, 0 ms.
        timer.reset();
    }

    /**
     * Solves via brute force: Tests all combinations of 3-digit numbers as palindrome.
     * Space: O(1), Time: O(n^2)
     */
    private int getLargestPalindromeFromProductOfTwo3DigitNumbers_v1() {
        int maxPalin = Integer.MIN_VALUE;
        for (int i = 100; i <= 999; i++) {
            for (int j = 100; j <= 999; j++) {
                int mult = i * j;
                if (isPalindrome(mult)) {
                    if (mult > maxPalin) {
                        maxPalin = mult;
                    }
                }
            }
        }
        return maxPalin;
    }

    /**
     * Solves via starting with palindrome, then determines whether or not it has 3-digit factors.
     * Space: O(1), Time: O(n*n)?, much faster than v1.
     */
    private int getLargestPalindromeFromProductOfTwo3DigitNumbers_v2() {
        for (int i = 999; i >= 100; i--) {
            String palinString = String.valueOf(i) + reverse(String.valueOf(i));
            int palin = Integer.parseInt(palinString);
            Pair pair = find3DigitFactorPair(palin);
            if (pair != null) {
                System.out.println("" + pair.x + " * " + pair.y + " = " + palin);
                return palin;
            }
        }
        return 0;
    }

    /** Returns a factor pair if found, otherwise null. */
    public static Pair find3DigitFactorPair(int value) {
        if (value < 100 * 100 || value > 999 * 999) { return null; }
        int sqrt = (int) Math.sqrt(value);
        return find3DigitFactorPairRecurse(new Pair(sqrt, sqrt), value);
    }

    /** The intuition for this is zigzagging up and right in a multiplication
     * chart until the value if found or is out of bounds. Chart is symmetrical,
     * so could also choose to go down and left instead. */
    private static Pair find3DigitFactorPairRecurse(Pair index, int value) {
        if (index.x < 100 || index.y < 100 ||
                index.x > 999 || index.y > 999) { return null; }

        int mult = index.x * index.y;
        if (mult < value) {
            index.x++;
            return find3DigitFactorPairRecurse(index, value);
        } else if (mult > value) {
            index.y--;
            return find3DigitFactorPairRecurse(index, value);
        } else {
            return index;
        }
    }

    /** Returns true if input is a palidrone, otherwise false. This treats
     * negative numbers just like positive numbers. */
    public static boolean isPalindrome(int input) {
        int pos = input;
        if (input < 0) { pos = -input; }

        if (input >= 0 && input <= 9) {
            return true;
        } else {
            char[] array = String.valueOf(pos).toCharArray();
            int length = array.length;
            for (int i = 0; i < length / 2; i++) {
                if (array[i] != array[length - 1 - i]) {
                    return false;
                }
            }
            return true;
        }
    }

    /** Returns the input in reverse order */
    public static String reverse(String input) {
        if (input == null) { return null; }
        if (input.isEmpty()) { return input; }

        if (input.length() == 3) {
            return "" + input.charAt(2) + input.charAt(1) + input.charAt(0);
        } else {
            char[] array = input.toCharArray();
            int length = input.length();
            for (int i = 0; i < length / 2; i++) {
                char temp = array[i];
                array[i] = array[length - 1 - i];
                array[length - 1 - i] = temp;
            }
            return array.toString();
        }
    }
    /** A mutable class for holding a pair of int. */
    private static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
