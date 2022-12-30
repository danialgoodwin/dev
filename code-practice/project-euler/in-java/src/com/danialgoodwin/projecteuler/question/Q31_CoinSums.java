/**
 * Created by Danial on 5/1/2015.
 */
package com.danialgoodwin.projecteuler.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 It is possible to make £2 in the following way:

 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 How many different ways can £2 be made using any number of coins?
 *
 * Website: https://projecteuler.net/problem=31
 */
public class Q31_CoinSums extends Question {

    @Override
    protected String getQuestionName() {
        return "Q31_CoinSums";
    }

    @Override
    public void solve() {
        List<Integer> coinValues = getCoinValues();
        int sum = 200;
        long answer = countCoinSumCombinations(coinValues, sum);
        log("answer=" + answer);
    }

    private static Map<Integer, Long> mSumCombinationCounts = new HashMap<>();

    private static long countCoinSumCombinations(List<Integer> coinValues, int sum) {
        return countCoinSumCombinationsViaTopDown(coinValues, 0, sum);
//        if (sum < 0) { return 0; }
//        if (sum == 0) { return 1; } // One way to make zero sum is with no coins.
//
//        for (int i = 1; i <= sum; i++) {
//            countCoinSumCombinationsViaBottomUp(coinValues, 0, i);
//        }
//        return countCoinSumCombinationsViaBottomUp(coinValues, 0, sum);
    }

    // Idea: Dynamic programming, memoization: count how many ways to get 1, then 2, then 3.. up to sum.
    // Note: This doesn't actually work like the idea yet.
//    private static long countCoinSumCombinationsViaBottomUp(List<Integer> coinValues, int maxValueIndexToUse, int sum) {
//        if (sum < 0) { return 0; }
//        if (sum == 0) { return 1; } // One way to make zero sum is with no coins.
//
//        long count = 0;
//        for (int i = maxValueIndexToUse; i < coinValues.size(); i++) {
//            Integer coinValue = coinValues.get(i);
//            count += countCoinSumCombinationsViaBottomUp(coinValues, i, sum - coinValue);
//        }
//        return count;
//    }

    private static long countCoinSumCombinationsViaTopDown(List<Integer> coinValues, int maxValueIndexToUse, int sum) {
        if (sum < 0) { return 0; }
        if (sum == 0) { return 1; } // One way to make zero sum is with no coins.

        long count = 0;
        for (int i = maxValueIndexToUse; i < coinValues.size(); i++) {
            Integer coinValue = coinValues.get(i);
            count += countCoinSumCombinationsViaTopDown(coinValues, i, sum - coinValue);
        }
        return count;
    }

//    private static long countCoinSumPermutations(List<Integer> coinValues, int sum) {
//        if (sum < 0) { return 0; }
//        if (sum == 0) { return 1; } // One way to make zero sum is with no coins.
//
//        for (int i = 1; i <= sum; i++) {
//            countCoinSumCombinationsViaBottomUp(coinValues, i);
//        }
//        return countCoinSumCombinationsViaBottomUp(coinValues, sum);
//    }

    // Idea: Dynamic programming, memoization: count how many ways to get 1, then 2, then 3.. up to sum.
//    private static long countCoinSumPermutationsViaBottomUp(List<Integer> coinValues, int sum) {
//        if (sum < 0) { return 0; }
//        if (sum == 0) { return 1; } // One way to make zero sum is with no coins.
//        if (mSumCombinationCounts.containsKey(sum)) { return mSumCombinationCounts.get(sum); }
//
//        long count = 0;
//        for (Integer coinValue : coinValues) {
//            count += countCoinSumPermutationsViaBottomUp(coinValues, sum - coinValue);
//        }
//        mSumCombinationCounts.put(sum, count);
//        System.out.println("sum=" + sum + ", count=" + count);
//        return count;
//    }

    // Current answer provides "5137456285977209020", which is wrong, probably permutation (and had overflow)
//    private static long countCoinSumPermutationsViaTopDown(List<Integer> coinValues, int sum) {
//        if (sum < 0) { return 0; }
//        if (sum == 0) { return 1; } // One way to make zero sum is with no coins.
//        if (mSumCombinationCounts.containsKey(sum)) { return mSumCombinationCounts.get(sum); }
//
//        long count = 0;
//        for (Integer coinValue : coinValues) {
//            count += countCoinSumPermutationsViaTopDown(coinValues, sum - coinValue);
//        }
//        mSumCombinationCounts.put(sum, count);
//        return count;
//    }

    private static List<Integer> getCoinValues() {
        List<Integer> coinValues = new ArrayList<>();
        coinValues.add(1);
        coinValues.add(2);
        coinValues.add(5);
        coinValues.add(10);
        coinValues.add(20);
        coinValues.add(50);
        coinValues.add(100);
        coinValues.add(200);
//        coinValues.add(200);
//        coinValues.add(100);
//        coinValues.add(50);
//        coinValues.add(20);
//        coinValues.add(10);
//        coinValues.add(5);
//        coinValues.add(2);
//        coinValues.add(1);
        return coinValues;
    }

}
