/**
 * Created by Danial on 2/9/2015.
 */
package com.danialgoodwin.projecteuler.question;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which, a^2 + b^2 = c^2
 *
 For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

 There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the product abc.
 */
public class Q9_SpecialPythagoreanTriplet extends Question {

    @Override
    protected String getQuestionName() {
        return "Q9_SpecialPythagoreanTriplet";
    }

    @Override
    public void solve() {
        int sum = 1000;
        long answer = getPythagoreanTripletProductForSum(sum);
        log("Answer: " + answer);
    }

    private long getPythagoreanTripletProductForSum(int sum) {
        return getProduct(getPythagoreanTripletForSum(sum));
    }

    /** Returns the Pythagorean triplet that adds up to `sum` or null if no such triplet */
    private int[] getPythagoreanTripletForSum(final int sumGoal) {
        for (int a = 1; a < sumGoal - 2; a++) {
            for (int b = a; a + b < sumGoal - 1; b++) {
                int c = sumGoal - a - b;
                if (Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2) == 0) {
                    return new int[] {a, b, c};
                }
            }
        }
        return null;
    }

    /** Returns the product of all the digits in the array. */
    private long getProduct(int[] numbers) {
        if (numbers == null || numbers.length == 0) { return 0; }

        int product = 1;
        for (int number : numbers) {
            product *= number;
        }
        return product;
    }

    /** Returns the sum of all the digits in the array. */
    private long getSum(int[] numbers) {
        if (numbers == null || numbers.length == 0) { return 0; }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

}
