
import java.util.List;
import java.util.LinkedList;

/**
 * 2520 is the smallest number that can be divided by each of the numbers
 * from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of
 * the numbers from 1 to 20?
 */
public class Problem5 {

    private static final int INVALID_INPUT = -1;

    private static Prime mPrime = Prime.getInstance();

    public static void main(String[] args) {
        int answer = solve();
        System.out.println("P5 Answer: " + answer);
    }
    
        // Idea 0: Keep incrementing by 1 (or 20/max) and test all numbers for remainder is zero.
        // Idea 1: Create sieve.
        // Idea 2: Find Least Common Denominator algo.
        // Idea 3: Find common factors, and multiple.
        // Idea 4: Euclid's Algorithm
        // Idea 5: Count factors in a more algorithmic way by iterating through and up.
    /** Solves problem in O() time and O() space. */
    public static int solve() {
        List<Integer> numbers = new LinkedList<Integer>();
        for (int i = 2; i <= 20; i++) { // 1-20 as per specs, and 1 isn't needed because it doesn't contribute to LCM.
            numbers.add(i);
        }
        
        Timer timer = new Timer();
        timer.start();
        int answer = solveViaCountDivisors(numbers);
        timer.stop();
        System.out.println("solveViaCountDivisors() time: " + timer.getLapTime());
        
        return answer;
    }
    
    /** Returns the least common multiple of all numbers in list.
     * If list is null or empty, then returns INVALID_INPUT = -1.
     * Note: The current version of this copies the input because so that it
     * can be manipulated without affecting the original list. */
    public static int solveViaCountDivisors(List<Integer> numbersInput) {
        // 0. Check validity of input.
        // 1. Have a mutable list of all numbers that need to be evenly divided. // O(n) space, LinkedList for fast deletion and no random access needed. Also, smaller numbers are near the front and more likely to be removed first. Though, there are quite a few random accesses because not using iterator.
        // 2. Remove all ones.
        // 3. Divide all that are evenly divible by 2, record 2, repeat until no other records can be evenly divided by 2. // O(n) space.
        // 4. Repeat 2-3 for increasing primes. // O(n) or o(n*log(n)) time
        // 5. Multiply all recorded numbers that were evenly divisible, which will be the LCM.
        
        if (numbersInput == null || numbersInput.isEmpty()) { return INVALID_INPUT; }
        
        List<Integer> numbers = new LinkedList<Integer>(numbersInput);
        
        int lcm = 1;
        for (int prime = 2; !numbers.isEmpty(); prime = mPrime.getNext(prime)) {
            System.out.println("prime: " + prime);
            int maxNumberOfFactor = 0;
            for (int index = 0; index < numbers.size(); index++) {
                System.out.println("index: " + index);
                // Avoid repetitive unnecessary checks if value is one.
                if (numbers.get(index) == 1) {
                    numbers.remove(index);
                    continue;
                }
                int numberOfFactor = 0;
                while (numbers.get(index) % prime == 0) {
                    numbers.set(index, numbers.get(index) / prime);
                    numberOfFactor++;
                    if (numberOfFactor > maxNumberOfFactor) {
                        maxNumberOfFactor = numberOfFactor;
                        lcm *= prime;
                    }
                    // Avoid repetitive unnecessary checks if value is one.
                    if (numbers.get(index) == 1) {
                        numbers.remove(index);
                        index--; // Needed so that no indexes are skipped using this method.
                        break; // Escape while-loop so that index -1 isn't accessed.
                    }
                }
            }
        }
        
        return lcm;
    }
    
    public static int solveViaCompareAllFactors(List<Integer> numbers) {
        // 1. Have a list of all numbers that need to be evenly divided.
        // 2. Find and save factors for all of the numbers. // O(k*n) space.
        // 3. Iterate through all the saved factors, multiply the answer by factors with the most for their number.
        return INVALID_INPUT;
    }

}