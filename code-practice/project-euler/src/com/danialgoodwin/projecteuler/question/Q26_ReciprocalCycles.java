/**
 * Created by Danial on 4/23/2015.
 */
package com.danialgoodwin.projecteuler.question;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/** A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

 1/2	= 	0.5
 1/3	= 	0.(3)
 1/4	= 	0.25
 1/5	= 	0.2
 1/6	= 	0.1(6)
 1/7	= 	0.(142857)
 1/8	= 	0.125
 1/9	= 	0.(1)
 1/10	= 	0.1
 Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

 Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 *
 * Website: https://projecteuler.net/problem=26
 */
public class Q26_ReciprocalCycles extends Question {

    @Override
    protected String getQuestionName() {
        return "Q26_ReciprocalCycles";
    }

    @Override
    public void solve() {
        int bound = 1000;
        int answer = findLongestRepeatingDecimal(bound);
        log("answer=" + answer);
    }

    /** Return the denominator for the longest repeating decimal for fractions from 1/1, 1/2, 1/3, 1/4 to 1/highBound.
     *
     * Thoughts:
     * - In order for a fraction to be terminating, the denominator is divisible by 2 or 5.
     * - Repeating decimals can be represented as a fraction above repeating 9s (then optional 0s for non-repeating part). Ex: 9,90,99,900,990,999,9000,9900,9990,9999
     * - The value over the most 9s is the one that is most repeating.
     *
     * Space: O(1), time: O(n * n), optimizations include: not considering terminal decimals; and
     *     the search for repeating9s0s could be done better; assuming longest repeats would have
     *     no non-repeating digits would simplify things more.
     * @param highBound max denominator to consider, exclusive
     * @return denominator
     */
    private static int findLongestRepeatingDecimal(int highBound) {
        if (highBound < 1) { return 1; }
        BigInteger denominatorWithLongestRepeats = BigInteger.ONE;
        int maxRepeats = 0;
        for (int i = 1; i < highBound; i++) {
            BigInteger denominator = new BigInteger("" + i);
            List<Integer> primeFactors = getPrimeFactors(denominator);

            // Ignore non-repeating decimals.
            if (primeFactors.size() == 1) {
                if (primeFactors.contains(2) || primeFactors.contains(5)) { continue; }
            } else if (primeFactors.size() == 2) {
                if (primeFactors.contains(2) && primeFactors.contains(5)) { continue; }
            }

            // Find repeating decimals by converting fraction to have denominator of repeating 9s.
            String repeating9s0s = "9";
            BigInteger repeating9s = new BigInteger("9");
            int totalDigits = 1;
            while (!repeating9s.mod(denominator).equals(BigInteger.ZERO)) {
                int indexOfZero = repeating9s0s.indexOf("0");
                if (indexOfZero == -1) {
//                if (repeating9s % 10 == 9) {
                    totalDigits++;
                    repeating9s0s = "9" + getZeros(totalDigits - 1);
//                    repeating9s0s = "" + (9 * Math.round(Math.pow(10, totalDigits - 1)));
                } else {
                    repeating9s0s = repeating9s0s.substring(0, indexOfZero) + "9" + repeating9s0s.substring(indexOfZero + 1);
                }
                repeating9s = new BigInteger(repeating9s0s);
            }

            int numberOfNines = repeating9s0s.lastIndexOf("9") + 1;
            if (numberOfNines > maxRepeats) {
                maxRepeats = numberOfNines;
                denominatorWithLongestRepeats = denominator;
            }
        }
        return Integer.parseInt(denominatorWithLongestRepeats.toString());
    }

    private static String getZeros(int numZeros) {
        if (numZeros <= 0) { return ""; }
        String zeros = "";
        for (int j = numZeros; j > 0; j--) {
            zeros += "0";
        }
        return zeros;
    }

    // TODOv2: Complete this to increase efficiency.
    private static List<Integer> getPrimeFactors(BigInteger number) {
        BigInteger smallerNumber = number;
        List<Integer> factors = new ArrayList<>();
        return factors;
    }

}
