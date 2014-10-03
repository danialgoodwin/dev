
import java.lang.Math;

/**
 * The sum of the squares of the first ten natural numbers is,
 *
 * 12 + 22 + ... + 102 = 385
 * The square of the sum of the first ten natural numbers is,
 *
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 - 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class Problem6 {

    public static void main(String[] args) {
        int answer = solve();
        System.out.println("P6 Answer: " + answer);
    }
    
    /** Solves problem in O() time and O() space. */
    public static int solve() {
        int[] numbers = new int[100];
        for (int i = 0; i < 100; i++) {
            numbers[i] = i + 1;
        }
        
        long answer = solveViaBruteForce(numbers);
        return (int) answer;
    }
    
    public static long solveViaBruteForce(int[] numbers) {
        long sumOfSquares = sumOfSquares(numbers);
        System.out.println("sumOfSquares: " + sumOfSquares);
        long squareOfSums = squareOfSums(numbers);
        System.out.println("squareOfSums: " + squareOfSums);
        return squareOfSums - sumOfSquares;
    }
    
    public static long sumOfSquares(int[] numbers) {
        long sumOfSquares = 0;
        for (int i : numbers) {
            sumOfSquares += (long) Math.pow(i, 2);
        }
        return sumOfSquares;
    }
    
    public static long squareOfSums(int[] numbers) {
        long sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        long squareOfSums = (long) Math.pow(sum, 2);
        return squareOfSums;
    }

}