/** Tests Prime.java. */
public class TestPrime {

    public static void main(String[] args) {
        Prime prime = Prime.getInstance(1);
        System.out.println("primes table size: " + prime.size());
        System.out.println("primes table: " + prime.debugToString());
        for (int i = -1; i < 15; i++) {
            System.out.println("isPrime(" + i + "): " + prime.isPrime(i));
        }
        System.out.println("isPrime(64): " + prime.isPrime(64));
        System.out.println("isPrime(97): " + prime.isPrime(97));
        
        System.out.println("primes table size: " + prime.size());
        System.out.println("primes table: " + prime.debugToString());
        
        for (int i = -1; i < 15; i++) {
            System.out.println("getNext(" + i + "): " + prime.getNext(i));
        }
        System.out.println("getNext(42): " + prime.getNext(42));
        System.out.println("getNext(131): " + prime.getNext(131));
        
        System.out.println("primes table size: " + prime.size());
        System.out.println("primes table: " + prime.debugToString());
        
    }

}