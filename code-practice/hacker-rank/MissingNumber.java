import java.util.Scanner;

/**
 * Created by dan on 9/10/15.
 */
/**
 * Task: Find the missing term in an Arithmetic Progression.

 An Arithmetic Progression is defined as one in which there is a constant difference between the consecutive terms of a given series of numbers. You are provided with consecutive elements of an Arithmetic Progression. There is however one hitch: Exactly one term from the original series is missing from the set of numbers which have been given to you. The rest of the given series is the same as the original AP.  Find the missing term.


 Input Format
 The first line contains an Integer N, which is the number of terms which will be provided as input.
 This is followed by N consecutive Integers, with a space between each pair of integers. All of these are on one line, and they are in AP (other than the point where an integer is missing).


 Output Format
 One Number which is the missing integer from the series.

 Sample Input
 5
 1 3 5 9 11

 Sample Output
 7

 Explanation
 You are provided with 5 integers. As you can can observe, they have been picked from a series, in which the starting term is 1 and the common difference is 2. The only abberration, i.e. the missing term (7), occurs between 5 and 9. This is the missing element which you need to find.

 Constraints
 3 <= N <= 2500
 All integers in the series will lie in the range [-10^6,+10^6].
 */
public class MissingNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int ans = getMissingNum(nums);
        System.out.println(String.valueOf(ans));
    }

    //        x
    // [1, 2, 3, 5]

    //  x
    // [1, 3, 4, 5]

    //     x
    // [1, 2, 4, 5]
    private static int getMissingNum(int[] nums) {
        int diff1 = Integer.MAX_VALUE;
        int diff2 = Integer.MAX_VALUE;
        int diff1Count = 0;
        int diff2Count = 0;
        int firstDiff1Value = Integer.MAX_VALUE;
        int firstDiff2Value = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff1Count + diff2Count > 2) {

            } else if (diff1Count == 0 || diff == diff1) {
                if (diff1Count == 0) { firstDiff1Value = nums[i -1]; }
                diff1Count++;
                diff1 = diff;
            } else if (diff2Count == 0 || diff == diff2) {
                if (diff2Count == 0) { firstDiff2Value = nums[i -1]; }
                diff2Count++;
                diff2 = diff;
            }
        }
        boolean isDiff1Larger = diff1Count > diff2Count;
        if (isDiff1Larger) {
            return firstDiff2Value + diff1;
        } else {
            return firstDiff1Value + diff2;
        }
    }


    static void findingDigits(int[] foo) {
        if (foo == null || foo.length == 0) return;
        for (int num : foo) {
            int temp = num;
            int count = 0;
            while (temp != 0) {
                if ((temp%10 != 0) && (num % (temp%10) == 0)) {
                    count++;
                }
                temp /= 10;
            }
            System.out.println(String.valueOf(count));
        }
    }

}
