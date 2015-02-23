/**
 * Created by Danial on 2/9/2015.
 */
package com.danialgoodwin;

/** Static helper methods related to mathematical operations. */
public class MathUtils {

    /**
     * Returns the greatest of multiple {@code long} values. That is, the
     * result is the argument closer to the value of
     * {@link Long#MAX_VALUE}. If the arguments have the same value,
     * the result is that same value.
     *
     * @param a an argument
     * @param nums variable amount of argument
     * @return the largest value
     */
    public static long max(long a, long... nums) {
        if (nums == null) { return a; }
        long max = a;
        for (long num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

}
