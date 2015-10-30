/**
 * Created by dan on 10/29/15.
 */
package com.anonsage.question;

/**
 * Given an array of ints, return a string identifying the range of numbers

 Example
 Input arr - [0 1 2 7 21 22 1098 1099]
 Output - "0-2,7,21-22,1098-1099"

 * More info: http://www.careercup.com/question?id=5738850972336128
 */
public class IntArrayRange {

    private static void log(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 7, 21, 22, 1098, 1099};
        String ranges = ranges(nums);
        log("ranges=" + ranges);
        ranges = ranges2(nums);
        log("ranges2=" + ranges);

        int[] nums2 = {0, 1, 2, 7, 21, 22, 1098, 1099, 1111};
        ranges = ranges(nums2);
        log("ranges=" + ranges);
        ranges = ranges2(nums2);
        log("ranges2=" + ranges);
    }

    // Assuming array is already sorted.
    public static String ranges(int[] nums) {
        if (nums == null || nums.length == 0) { return ""; }
        if (nums.length == 1) { return String.valueOf(nums[0]); }

        StringBuilder sb = new StringBuilder();
        for (int i = 0;;) {
            int rangeStart = nums[i];
            sb.append(rangeStart);
            int rangeEnd = rangeStart;
            while (++i < nums.length && nums[i] == rangeEnd + 1) {
                rangeEnd++;
            }
            if (rangeStart != rangeEnd) {
                sb.append("-" + rangeEnd);
            }
            if (i >= nums.length) { break; }
            sb.append(",");
        }
        return sb.toString();
    }

    // Assuming array is already sorted.
    public static String ranges2(int[] nums) {
        if (nums == null || nums.length == 0) { return ""; }

        StringBuilder sb = new StringBuilder();
        int start = nums[0];
        int end = start;
        for (int i = 1; i < nums.length; i++) {
            boolean isIncrement = nums[i] - 1 == nums[i - 1];
            if (isIncrement) {
                end = nums[i];
            } else {
                sb.append(start);
                if (start != end) { sb.append("-").append(end); }
                sb.append(",");
                end = start = nums[i];
            }
        }
        sb.append(start);
        if (start != end) { sb.append("-").append(end); }
        return sb.toString();
    }

}
