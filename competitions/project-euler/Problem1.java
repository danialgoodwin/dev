

/** Multiples of 3 and 5
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem1 {

    public static void main(String[] args) {
        int answer = solve();
        System.out.println("P1 Answer: " + answer);
        answer = solve2();
        System.out.println("P1 Answer: " + answer);
    }
    
    /** Solves problem in O(1) space and O(n) time. */
    public static int solve() {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        
        return sum;
    }
    
    /** Solves problem in O(1) space and O(n) time, but faster because it only
     * iterates over the multiples and has no other checks. */
    public static int solve2() {
        int sum = 0;
        for (int i = 3; i < 1000; i += 3) {
            sum += i;
        }
        for (int i = 5; i < 1000; i += 15) {
            sum += i;
        }
        for (int i = 10; i < 1000; i += 15) {
            sum += i;
        }
        
        return sum;
    }

}