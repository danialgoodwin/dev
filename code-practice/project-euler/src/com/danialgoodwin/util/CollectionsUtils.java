package com.danialgoodwin.util;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by Danial on 3/19/2015.
 */
public class CollectionsUtils {

    /** No need to instantiate this class. */
    private CollectionsUtils() {}


    /** Return the index with the max value. This searches iteratively. If there are multiple max values, then the
     * first one found will be used.
     * @throws java.lang.NullPointerException if input is null.
     * @throws java.lang.IllegalArgumentException if input is empty
     */
    public static <K, V extends Comparable> K getMaxIndex(Map<K, V> nums) {
        if (nums == null) { throw new NullPointerException("input must not be null"); }
        if (nums.isEmpty()) { throw new IllegalArgumentException("input must have at least one value"); }

        Comparable maxValue = Collections.max(nums.values());
        for (Map.Entry<K, V> entry : nums.entrySet()) {
            if (entry.getValue().compareTo(maxValue) == 0) {
                return entry.getKey();
            }
        }
        throw new IllegalArgumentException("case not handled");
    }

}
