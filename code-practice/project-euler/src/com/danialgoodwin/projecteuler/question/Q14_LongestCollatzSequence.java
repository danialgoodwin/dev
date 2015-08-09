/**
 * Created by Danial on 3/19/2015.
 */
package com.danialgoodwin.projecteuler.question;

import com.danialgoodwin.model.Pair;
import com.danialgoodwin.util.ArrayUtils;
import com.danialgoodwin.util.CollectionsUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Which starting number, under one million, produces the longest Collatz chain?
 * Website: https://projecteuler.net/problem=14
 */
public class Q14_LongestCollatzSequence extends Question {

    @Override
    protected String getQuestionName() {
        return "Q14_LongestCollatzSequence";
    }

    @Override
    public void solve() {
        long answer = getLongestCollatzSequenceStartNumberViaMemoizeMap(1000000);
//        long answer = getLongestCollatzSequenceStartNumberViaMemoizeList(1000000);
        log("answer=" + answer);
    }

    /**
     *
     * Space: O(n), time: O(n)
     * @param max positive number for max possible starting sequence
     */
    private long getLongestCollatzSequenceStartNumberViaMemoizeMap(int max) {
        if (max <= 0) { return 0; }

        Map<Long, Integer> sequenceLengths = new HashMap<>(max * 4);

        sequenceLengths.put(1L, 1);
        for (int i = 2; i <= max; i++) {
//            if (i % 100 == 0) {
//            log("calculateSequenceLength for " + i);
//            }
            try {
                calculateSequenceLengthRecursively(sequenceLengths, i);
//            sequenceLengths.add(i, calculateSequenceLengthIteratively(i));
            } catch (StackOverflowError error) {
                log("StackOverflowError at i=" + i);
                sequenceLengths.put((long) i, calculateSequenceLengthIteratively(sequenceLengths, i));
            }
        }

        return CollectionsUtils.getMaxIndex(sequenceLengths);
    }

    /**
     * @param num must be a valid index in sequenceLengths
     */
    private static int calculateSequenceLengthRecursively(Map<Long, Integer> sequenceLengths, long num) {
        if (sequenceLengths.get(num) != null && sequenceLengths.get(num) != 0) { return sequenceLengths.get(num); }

        if ((num & 1) == 0) {
//        if (num % 2 == 0) {
            int sequenceLength = calculateSequenceLengthRecursively(sequenceLengths, num >> 1) + 1;
            sequenceLengths.put(num, sequenceLength);
        } else {
            int sequenceLength = calculateSequenceLengthRecursively(sequenceLengths, 3 * num + 1) + 1;
            sequenceLengths.put(num, sequenceLength);
        }
        return sequenceLengths.get(num);
    }

    /**
     *
     * Space: O(n), time: O(n)
     * Note: Using a HashSet<Integer, Integer> may be better in space and time, by a constant amount.
     * @param max positive number for max possible starting sequence
     */
    private int getLongestCollatzSequenceStartNumberViaMemoizeList(int max) {
        if (max <= 0) { return 0; }

        // Fill the int[] with all the sequence lengths.
        int maxSize = max * 100;
        List<Integer> sequenceLengths = new ArrayList<>(maxSize);
        for (int i = 0; i < maxSize; i++) {
            sequenceLengths.add(0);
        }
        sequenceLengths.set(1, 1);
        for (int i = 2; i <= max; i++) {
//            if (i % 100 == 0) {
            log("calculateSequenceLength for " + i);
//            }
            calculateSequenceLengthRecursively(sequenceLengths, i);
//            sequenceLengths.add(i, calculateSequenceLengthIteratively(i));
        }

        // Find the max value;
        int maxIndex = ArrayUtils.getMaxIndex(sequenceLengths.subList(0, max + 1));

        return sequenceLengths.get(maxIndex);
    }

    /**
     * @param num must be a valid index in sequenceLengths
     */
    private static int calculateSequenceLengthRecursively(List<Integer> sequenceLengths, int num) {
        if (sequenceLengths.get(num) != 0) { return sequenceLengths.get(num); }

        if (num % 2 == 0) {
            int sequenceLength = calculateSequenceLengthRecursively(sequenceLengths, num >> 1) + 1;
            sequenceLengths.set(num, sequenceLength);
        } else {
            int sequenceLength = calculateSequenceLengthRecursively(sequenceLengths, 3 * num + 1) + 1;
            sequenceLengths.set(num, sequenceLength);
        }
        return sequenceLengths.get(num);
    }

    /**
     * @param num must be greater than 0
     */
    private static int calculateSequenceLengthIteratively(int num) {
        int length = 1;
        int currentNum = num;
        while (currentNum != 1) {
            if (currentNum % 2 == 0) {
                currentNum = currentNum >> 1;
            } else {
                currentNum = currentNum * 3 + 1;
            }
            length++;
        }
        return length;
    }

    /**
     * @param num must be greater than 0
     */
    private static int calculateSequenceLengthIteratively(Map<Long, Integer> sequenceLengths, int num) {
        int length = 1;
        long currentNum = num;
        while (sequenceLengths.get(currentNum) == null && currentNum != 1) {
            if (currentNum % 2 == 0) {
                currentNum = currentNum >> 1;
            } else {
                currentNum = currentNum * 3 + 1;
            }
            length++;
        }

        if (sequenceLengths.get(currentNum) == null) {
            return length;
        } else {
            return sequenceLengths.get(currentNum) + length - 1;
        }
    }



    // These use an int[] which wouldn't easily allow the sequence to go above the max, so using ArrayList for ease of expanding.
//    /**
//     *
//     * Space: O(n), time: O(n)
//     * @param max positive number for max possible starting sequence
//     */
//    private static int getLongestCollatzSequenceStartNumberViaMemoizePrimitiveArray(int max) {
//        if (max <= 0) { return 0; }
//
//        // Fill the int[] with all the sequence lengths.
//        int[] sequenceLengths = new int[max + 1];
//        int[1] = 1;
//        for (int i = 2; i <= max; i++) {
//            calculateSequenceLength(sequenceLengths, i);
////            sequenceLengths[i] = calculateSequenceLength(sequenceLengths, i);
//        }
//
//        // Find the max value;
//        int maxIndex = ArrayUtils.getMaxIndex(sequenceLengths);
//
//        return sequenceLengths[maxIndex];
//    }
//
//    private static int calculateSequenceLength(int[] sequenceLengths, int i) {
//        if (i <= 0 || i > sequenceLengths.length) { throw new IllegalArgumentException("i must be a valid index in sequenceLengths"); }
//        if (sequenceLengths[i] != 0) { return sequenceLengths[i]; }
//
//        if (i % 2 == 0) {
//            sequenceLengths[i] = calculateSequenceLength(sequenceLengths, i / 2) + 1;
//        } else {
//            sequenceLengths[i] = calculateSequenceLength(sequenceLengths, 3 * i + 1) + 1;
//        }
//        return sequenceLengths[i];
//    }

}
