/**
 * Created by Danial on 5/12/2015.
 */
package com.danialgoodwin.projecteuler.question;

import java.util.*;

/** We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

 The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.

 Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.

 HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 *
 * Website: https://projecteuler.net/problem=32
 */
public class Q32_PandigitalProducts extends Question {

    private static final Set<Character> PANDIGITAL_1_TO_9;

    static {
        PANDIGITAL_1_TO_9 = new HashSet<>();
        PANDIGITAL_1_TO_9.add('1');
        PANDIGITAL_1_TO_9.add('2');
        PANDIGITAL_1_TO_9.add('3');
        PANDIGITAL_1_TO_9.add('4');
        PANDIGITAL_1_TO_9.add('5');
        PANDIGITAL_1_TO_9.add('6');
        PANDIGITAL_1_TO_9.add('7');
        PANDIGITAL_1_TO_9.add('8');
        PANDIGITAL_1_TO_9.add('9');
    }

    @Override
    protected String getQuestionName() {
        return "Q32_PandigitalProducts";
    }

    @Override
    public void solve() {
        long answer = findSumOfProductsFor1To9Pandigitals();
        log("answer=" + answer);
    }

    private static long findSumOfProductsFor1To9Pandigitals() {
        Integer sum = 0;
        for (Integer i : getProductsFor1To9Pandigitals()) {
            sum += i;
        }
        return sum;
    }

    private static List<Integer> getProductsFor1To9Pandigitals() {
        List<Integer> products = new ArrayList<>();
        for (int i = 1; i < 9876543; i++) {
            for (int j = 1; j < 9876543; j++) {

            }
        }
        return products;
    }

    // Numbers in input string only.
    // An optimization would be to only add chars to `valid` by seeing which ones are missing,
    //    rather than adding all and removing.
    /** Returns all the possible multipliers for a 1-9 pandigital. */
    private static List<Integer> getPossibleMultipliers(String multiplicands) {
        Set<Character> valid = new HashSet<>(PANDIGITAL_1_TO_9);
        char[] multiplicandChars = multiplicands.toCharArray();
        Arrays.sort(multiplicandChars);
        for (char ch : multiplicandChars) {
            valid.remove(ch);
        }
        return getPermutations(valid);
    }

    private static List<Integer> getPermutations(Set<Character> input) {
        List<Integer> permutations = new ArrayList<>();
        for (Character ch : input) {
            for (Integer permutation : permutations) {

            }
        }
        return permutations;
    }

}
