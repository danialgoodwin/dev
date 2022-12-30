package com.danialgoodwin.util;

import java.util.List;

/**
 * Created by Danial on 3/19/2015.
 */
public class ArrayUtils {

    /** No need to instantiate this class. */
    private ArrayUtils() {}

    /** Return the index with the max value. This searches iteratively. If there are multiple max values, then the
     * first one found will be used.
     * @throws java.lang.NullPointerException if input is null. */
    public static int getMaxIndex(int[] nums) {
        if (nums == null) { throw new NullPointerException("input must not be null"); }

        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /** Return the index with the max value. This searches iteratively. If there are multiple max values, then the
     * first one found will be used.
     * @throws java.lang.NullPointerException if input is null.
     * @throws java.lang.IllegalArgumentException if input is empty
     */
    public static int getMaxIndex(List<Integer> nums) {
        if (nums == null) { throw new NullPointerException("input must not be null"); }
        if (nums.isEmpty()) { throw new IllegalArgumentException("input must have at least one value"); }

        Integer max = Integer.MIN_VALUE;
        int maxIndex = 0;
        int length = nums.size();
        for (int i = 0; i < length; i++) {
            if (max < nums.get(i)) { // TODO: Should probably check for null here.
                max = nums.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // Need to find a way to compare less than for Number.
//    /** Return the index with the max value. This searches iteratively. If there are multiple max values, then the
//     * first one found will be used.
//     * @throws java.lang.NullPointerException if input is null.
//     * @throws java.lang.IllegalArgumentException if input is empty
//     */
//    public static <T extends Number> int getMaxIndex(List<T> nums) {
//        if (nums == null) { throw new NullPointerException("input must not be null"); }
//        if (nums.isEmpty()) { throw new IllegalArgumentException("input must have at least one value"); }
//
//        Number max = Integer.MIN_VALUE;
//        int maxIndex = 0;
//        int length = nums.size();
//        for (int i = 0; i < length; i++) {
//            if (max < nums.get(i)) {
//                max = nums.get(i);
//                maxIndex = i;
//            }
//        }
//        return maxIndex;
//    }

}
