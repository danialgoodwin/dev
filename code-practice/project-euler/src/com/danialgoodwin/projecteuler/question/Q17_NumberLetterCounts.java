/**
 * Created by Danial on 4/8/2015.
 */
package com.danialgoodwin.projecteuler.question;

import java.util.HashMap;
import java.util.Map;

/**If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and
 * 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance
 * with British usage.
 *
 * Website: https://projecteuler.net/problem=17
 */
public class Q17_NumberLetterCounts extends Question {

    private static final Map<Integer, Integer> mLetterCounts = new HashMap<>();
    private static final int mNumberLetterCounts1to9;
    private static final int mNumberLetterCounts1to19;
    private static final int mNumberLetterCounts1to99;
    private static final int mNumberLetterCounts1to999;

    static {
        mLetterCounts.put(1, "one".length());
        mLetterCounts.put(2, "two".length());
        mLetterCounts.put(3, "three".length());
        mLetterCounts.put(4, "four".length());
        mLetterCounts.put(5, "five".length());
        mLetterCounts.put(6, "six".length());
        mLetterCounts.put(7, "seven".length());
        mLetterCounts.put(8, "eight".length());
        mLetterCounts.put(9, "nine".length());
        mLetterCounts.put(10, "ten".length());
        mLetterCounts.put(11, "eleven".length());
        mLetterCounts.put(12, "twelve".length());
        mLetterCounts.put(13, "thirteen".length());
        mLetterCounts.put(14, "fourteen".length());
        mLetterCounts.put(15, "fifteen".length());
        mLetterCounts.put(16, "sixteen".length());
        mLetterCounts.put(17, "seventeen".length());
        mLetterCounts.put(18, "eighteen".length());
        mLetterCounts.put(19, "nineteen".length());
        mLetterCounts.put(20, "twenty".length());
        mLetterCounts.put(30, "thirty".length());
        mLetterCounts.put(40, "forty".length());
        mLetterCounts.put(50, "fifty".length());
        mLetterCounts.put(60, "sixty".length());
        mLetterCounts.put(70, "seventy".length());
        mLetterCounts.put(80, "eighty".length());
        mLetterCounts.put(90, "ninety".length());
//        mLetterCounts.put(100, "onehundred".length());
        mLetterCounts.put(1000, "onethousand".length());

        mNumberLetterCounts1to9 = getCountOfLettersInNumbers1to9();
        mNumberLetterCounts1to19 = getCountOfLettersInNumbers1to19();
        mNumberLetterCounts1to99 = getCountOfLettersInNumbers1to99();
        mNumberLetterCounts1to999 = getCountOfLettersInNumbers1to999();
    }

    @Override
    protected String getQuestionName() {
        return "Q17_NumberLetterCounts";
    }

    @Override
    public void solve() {
        int answer = mNumberLetterCounts1to999 + mLetterCounts.get(1000);
        log("answer=" + answer);
    }

    private static int getCountOfLettersInNumbers1to999() {
        int count = mNumberLetterCounts1to99;
        int countHundred = "hundred".length();
        int countAnd = "and".length();
        for (int i = 1; i <= 9; i++) {
            int highOrderCount = mLetterCounts.get(i) + countHundred;
            count += highOrderCount;
            highOrderCount += countAnd;
            count = count + (highOrderCount * 99 + mNumberLetterCounts1to99);
        }
        logg("getCountOfLettersInNumbers1to999()=" + count);
        return count;
    }

    private static int getCountOfLettersInNumbers1to99() {
        int count = mNumberLetterCounts1to19;
        for (int i = 20; i <= 90; i += 10) {
            int highOrderCount = mLetterCounts.get(i);
            count = count + (highOrderCount * 10 + mNumberLetterCounts1to9);
        }
        logg("getCountOfLettersInNumbers1to99()=" + count);
        return count;
    }

    private static int getCountOfLettersInNumbers1to19() {
        int count = 0;
        for (int i = 1; i <= 19; i++) {
            count += mLetterCounts.get(i);
        }
        logg("getCountOfLettersInNumbers1to19()=" + count);
        return count;
    }

    private static int getCountOfLettersInNumbers1to9() {
        int count = 0;
        for (int i = 1; i <= 9; i++) {
            count += mLetterCounts.get(i);
        }
        logg("getCountOfLettersInNumbers1to9()=" + count);
        return count;
    }

    private static void logg(String message) {
        System.out.println(message);
    }

}
