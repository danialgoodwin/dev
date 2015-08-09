/**
 * Created by Danial on 4/20/2015.
 */
package com.danialgoodwin.projecteuler.question;

import com.danialgoodwin.MathUtils;

import java.math.BigInteger;

/** A permutation is an ordered arrangement of objects. For example, 3124 is one possible
 * permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or
 * alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

 012   021   102   120   201   210

 What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

Website: https://projecteuler.net/problem=24
 */
public class Q24_LexicographicPermutations extends Question {

    @Override
    protected String getQuestionName() {
        return "Q24_LexicographicPermutations";
    }

    @Override
    public void solve() {
//        String answer = getNthLexicographicPermutation("0123456789", 1000000);
        String answer = getNthLexicographicPermutation("0123456789", 999999);
        log("answer=" + answer);
//        log("answer=" + getNthLexicographicPermutation("012", 0));
//        log("answer=" + getNthLexicographicPermutation("012", 1));
//        log("answer=" + getNthLexicographicPermutation("012", 2));
//        log("answer=" + getNthLexicographicPermutation("012", 3));
//        log("answer=" + getNthLexicographicPermutation("012", 4));
//        log("answer=" + getNthLexicographicPermutation("012", 5));

//        log("answer=" + getNthLexicographicPermutation("0123", 0));
//        log("answer=" + getNthLexicographicPermutation("0123", 1));
//        log("answer=" + getNthLexicographicPermutation("0123", 2));
//        log("answer=" + getNthLexicographicPermutation("0123", 3));
//        log("answer=" + getNthLexicographicPermutation("0123", 4));
//        log("answer=" + getNthLexicographicPermutation("0123", 5));
//        log("answer=" + getNthLexicographicPermutation("0123", 6));
//        log("answer=" + getNthLexicographicPermutation("0123", 7));
//        log("answer=" + getNthLexicographicPermutation("0123", 8));
//        log("answer=" + getNthLexicographicPermutation("0123", 9));
//        log("answer=" + getNthLexicographicPermutation("0123", 10));
//        log("answer=" + getNthLexicographicPermutation("0123", 11));
//        log("answer=" + getNthLexicographicPermutation("0123", 12));
//        log("answer=" + getNthLexicographicPermutation("0123", 13));
//        log("answer=" + getNthLexicographicPermutation("0123", 14));
//        log("answer=" + getNthLexicographicPermutation("0123", 15));
//        log("answer=" + getNthLexicographicPermutation("0123", 16));
//        log("answer=" + getNthLexicographicPermutation("0123", 17));
//        log("answer=" + getNthLexicographicPermutation("0123", 18));
//        log("answer=" + getNthLexicographicPermutation("0123", 19));
//        log("answer=" + getNthLexicographicPermutation("0123", 20));
//        log("answer=" + getNthLexicographicPermutation("0123", 21));
//        log("answer=" + getNthLexicographicPermutation("0123", 22));
//        log("answer=" + getNthLexicographicPermutation("0123", 23));
    }

    /** Return the nth lexicographic permutation.
     * Space: O(log(n)) due to recursive, time: O(log(n))
     * @param s the list of characters to permutate, should already be in lexicographic order
     * @param n which permutation to return*/
    private static String getNthLexicographicPermutation(String s, int n) {
        if (s == null || s.length() <= 1) { return s; }
        if (n == 0) { return s; } // Just an optimization.
        long numberOfChoicesPerGroup = MathUtils.factorialSmall(s.length() - 1);
        int indexToUse = (int) (n / numberOfChoicesPerGroup);
        int nextIndex = (int) (n % numberOfChoicesPerGroup);
        String ch = s.substring(indexToUse, indexToUse + 1);
        return ch + getNthLexicographicPermutation(s.substring(0, indexToUse) + s.substring(indexToUse + 1, s.length()), nextIndex);
    }

    // An idea, maybe useful in future. Or maybe not.
    /** Return the exponent of the largest power of two that is less than or equal to max. */
//    private static int findNearestPowerOfTwoRoundDown(int max) {
//
//    }

}
