/** Helper methods about numbers. */
public class NumberUtils {
    private NumberUtils() {}

    /** Returns true if input is a prime number, otherwise false. */
    public static final boolean isPrime(int number) {
        if (number < 2) { return false; }
        if (number == 2) { return true; }
        if (number % 2 == 0) { return false; }
        
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) { return false; }
        }
        
        return true;
    }

    /** Returns a prime number that is greater than input. */
    public static final int getNextPrime(int number) {
        int i = number + 1;
        while (true) {
            if (isPrime(i) { return i; }
            i++;
        }
        // while (1) { if (isPrime(++i) { return i; }} // Condensed.
    }

    /** Returns a prime number that is greater than or equal to input. */
    public static final int getNextPrime(int number) {
        for (int i = number; true; i++) {
            if (isPrime(i) { return i; }
        }
    }

}
