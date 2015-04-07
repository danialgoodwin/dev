/**
 * Created by Danial on 4/7/2015.
 */
package com.danialgoodwin.interviewcake.question;

import java.util.Random;

/** You have a function rand5() that generates a random integer from 1 to 5. Use it to write a function rand7() that generates a random integer from 1 to 7.
 * rand5() returns each integer with equal probability. rand7() must also return each integer with equal probability.
 *
 *
 * Website: https://www.interviewcake.com/question/simulate-7-sided-die
 */
public class Simulate7SidedDieQuestion extends Question {

    private static Random mRandom = new Random();
    private static int mStartingInt = 1;


    @Override
    protected String getQuestionName() {
        return "Simulate7SidedDie";
    }

    @Override
    public void solve() {
        log("rand5(): " + rand5());
        log("rand7(): " + rand7());
    }

    /** Return a random number between 1 and 5, inclusive. */
    private static int rand5() {
        return mRandom.nextInt(5) + 1;
    }

    /** Return a random number between 1 and 7, inclusive.
     * Space: O(1), time: O(1)
     */
    private static int rand7() {
//        return (rand5() + rand5()) * 7 / 10; // Can't use because it favors the middle numbers.
//        return (rand5() + rand5()) % 7 + 1; // Can't use because it 1,2,3 have a slightly higher chance.

        // But, if you keep state, then over the long-run, all outcomes could have same probability.
        mStartingInt = (mStartingInt + 1) % 7 + 1;
        return (mStartingInt + (rand5() - 1) * 5 + rand5() - 1) % 7 + 1;
    }

}
