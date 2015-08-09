/**
 * Created by Danial on 2014-10-04.
 */
package com.danialgoodwin.util;

/** TODO: Make this a real rest with JUnit. */
public class PrimeUtilsTest {

    public static void main(String[] args) {
        PrimeUtils prime = PrimeUtils.getInstance(1);
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

        //System.out.println("prime.getNthPrime(-1): " + prime.getNthPrime(-1));
        System.out.println("prime.getNthPrime(0): " + prime.getNthPrime(0));
        System.out.println("prime.getNthPrime(1): " + prime.getNthPrime(1));
        System.out.println("prime.getNthPrime(2): " + prime.getNthPrime(2));
        System.out.println("prime.getNthPrime(11): " + prime.getNthPrime(11));
        System.out.println("prime.getNthPrime(101): " + prime.getNthPrime(101));
        System.out.println("prime.getNthPrime(1001): " + prime.getNthPrime(1001));
        System.out.println("prime.getNthPrime(10000): " + prime.getNthPrime(10000));
        System.out.println("prime.getNthPrime(10001): " + prime.getNthPrime(10001));
        System.out.println("prime.getNthPrime(10002): " + prime.getNthPrime(10002));
    }

}
