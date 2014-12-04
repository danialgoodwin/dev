
/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10001st prime number?
 */
public class Problem7 {

    private static Prime mPrime = Prime.getInstance(10001);

    public static void main(String[] args) {
        int answer = solve();
        System.out.println("P7 Answer: " + answer);
    }
    
    /** Solves problem in O() time and O() space. */
    public static int solve() {
        int answer = mPrime.getNthPrime(10001);
        return answer;
    }

}