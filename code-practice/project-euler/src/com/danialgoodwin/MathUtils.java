/**
 * Created by Danial on 2/9/2015.
 */
package com.danialgoodwin;

import java.math.BigInteger;
import java.util.List;

/** Static helper methods related to mathematical operations. */
public class MathUtils {

    /**
     * Return the greatest of multiple {@code long} values. That is, the
     * result is the argument closer to the value of
     * {@link Long#MAX_VALUE}. If the arguments have the same value,
     * the result is that same value.
     *
     * @param a a value to compare
     * @param nums variable amount of values to compare
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

    // These factorial methods using int and long quickly become too small for factorials, so BigInteger is used instead.
    /** Return the factorial value of the input.
     * Note: Numbers can quickly overwhelm the MAX_LONG and cause wrap-around.
     * Note: Currently, negative numbers are not supported and will throw an IllegalArgumentException. */
//    public static long factorial(int num) {
//        if (num < 0) { throw new IllegalArgumentException("Input must be non-negative"); }
//        if (num == 0) { return 1; } // Source: http://mathforum.org/dr.math/faq/faq.0factorial.html
//
//        long product = 1;
//        for (int i = num; i > 0; i--) {
//            product *= i;
//        }
//        System.out.println("factorial(" + num + ")=" + product);
//        return product;
//    }
//
//    /** Return the factorial value of the input, from start to end, inclusive.
//     * Currently, negative numbers are not supported and will throw an IllegalArgumentException. */
//    public static long factorial(int start, int end) {
//        if (start < 0 || end < 0 || end < start) { throw new IllegalArgumentException("Input must be non-negative"); }
//        if (start == 0 && end == 0) { return 1; } // Source: http://mathforum.org/dr.math/faq/faq.0factorial.html
//
//        long product = 1;
//        for (int i = start; i <= end; i++) {
//            product *= i;
//        }
//        System.out.println("factorial(" + start + "," + end + ")=" + product);
//        return product;
//    }

    /** Return the factorial value of the input.
     * Note: Numbers can quickly overwhelm the MAX_LONG and cause wrap-around.
     * Note: Currently, negative numbers are not supported and will throw an IllegalArgumentException. */
    public static BigInteger factorial(long num) {
        if (num < 0) { throw new IllegalArgumentException("Input must be non-negative"); }
        if (num == 0) { return BigInteger.ONE; } // Source: http://mathforum.org/dr.math/faq/faq.0factorial.html

        BigInteger product = BigInteger.ONE;
        for (BigInteger i = new BigInteger("" + num); i.compareTo(BigInteger.ZERO) > 0; i = i.subtract(BigInteger.ONE)) {
            product = product.multiply(i);
        }
        System.out.println("factorial(" + num + ")=" + product);
        return product;
    }

    /** Return sum digits. */
    public static long sum(List<Integer> digits) {
        long sum = 0;
        for (Integer digit : digits) {
            sum += digit;
        }
        return sum;
    }

}
