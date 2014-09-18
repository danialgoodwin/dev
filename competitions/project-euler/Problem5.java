
/**
 * 2520 is the smallest number that can be divided by each of the numbers
 * from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of
 * the numbers from 1 to 20?
 */
public class Problem5 {

    public static void main(String[] args) {
        int answer = solve();
        System.out.println("P5 Answer: " + answer);
    }
    
    /** Solves problem in O() time and O() space. */
    public static int solve() {
        
    }
    
    public static int solveViaBruteForce() {
        // Idea 0: Keep incrementing by 1 (or 20/max) and test all numbers for remainder is zero.
        // Idea 1: Create sieve.
        // Idea 2: Find Least Common Denominator algo.
        // Idea 3: Find common factors, and multiple.
        // Idea 4: Euclid's Algorithm
        // Idea 5: Count factors in a more algorithmic way by iterating through and up.
        
    }
    
    public static int solveViaCountDivisors() {
        // 1. Have a mutable list of all numbers that need to be evenly divided. // O(n) space, probably use LinkedList.
        // 2. Remove all ones.
        // 3. Divide all that are evenly divible by 2, record 2, repeat until no other records can be evenly divided by 2. // O(n) space.
        // 4. Repeat 2-3 for increasing primes.
        // 5. Multiply all recorded numbers that were evenly divisible, which will be the LCM.
    }
    
    public static int solveViaCompareAllFactors() {
        // 1. Have a list of all numbers that need to be evenly divided.
        // 2. Find and save factors for all of the numbers. // O(k*n) space.
        // 3. Iterate through all the saved factors, multiply the answer by factors with the most for their number.
    }

}