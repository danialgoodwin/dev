/**
 * Created by Danial on 4/30/2015.
 */
package com.danialgoodwin.interviewcake.question;

import java.util.*;

/** We have an array of integers, where:

 The integers are in the range 1..n1..n
 The array has a length of n+1n+1
 It follows that our array has at least one integer which appears at least twice. But it may have
 several duplicates, and each duplicate may appear more than twice.

 Write a function which finds any integer that appears more than once in our array.

 We're going to run this function on our new, super-hip Macbook Pro With Retina Display™. Thing is,
 the damn thing came with the RAM soldered right to the motherboard, so we can't upgrade our RAM.
 So we need to optimize for space!
 *
 * Website: https://www.interviewcake.com/question/find-duplicate-optimize-for-space
 */
public class FindDuplicateOptimizeForSpace extends Question {

    public static void main(String[] args) {
        List<Integer> numbers = createListOfNumbers();
        System.out.println("numbers=" + numbers);
        System.out.println("answer=" + findDuplicates(numbers));
    }

    @Override
    protected String getQuestionName() {
        return "FindDuplicateOptimizeForSpace";
    }

    @Override
    public void solve() {
        main(null);
    }

    /** Return a new list that contains all the duplicate numbers from input. Or, if there are no
     * duplicates (or input is null), then return empty list.
     * Note: Null values will be ignored.
     *
     * Space: O(n/2), time: O(n * log n), which is limited by sorting.
     * @param numbers non-null values
     * @return list of duplicate numbers or empty list
     */
    private static List<Integer> findDuplicates(List<Integer> numbers) {
        List<Integer> repeats = new ArrayList<>();
        if (numbers == null || numbers.isEmpty()) { return repeats; }
        Collections.sort(numbers);
        Integer previousValue = numbers.get(0);
        int length = numbers.size();
        for (int i = 1; i < length; i++) {
            Integer num = numbers.get(i);
            if (num != null && num.equals(previousValue) &&
                    (repeats.isEmpty() ||
                    !repeats.isEmpty() && !repeats.get(repeats.size() - 1).equals(num))) {
                repeats.add(num);
            }
            previousValue = num;
        }
        return repeats;
    }


    private static List<Integer> createListOfNumbers() {
        int size = 10;
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>(size);
        for (int i = size; i > 0; i--) {
            numbers.add(random.nextInt(size));
        }
        return numbers;
    }

}
