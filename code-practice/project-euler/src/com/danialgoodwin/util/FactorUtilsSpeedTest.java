package com.danialgoodwin.util;

/** Simple testing for the different ways of factoring in Factor.java. */
public class FactorUtilsSpeedTest {

    private static final int NUMBER_OF_LOOPS = 5;

    private static Stopwatch timer1 = new Stopwatch();
    private static Stopwatch timer2 = new Stopwatch();
    private static Stopwatch timer3 = new Stopwatch();
    private static Stopwatch timer4 = new Stopwatch();
    private static Stopwatch timerViaLinearSearchUsingAddition1 = new Stopwatch();
    private static Stopwatch timerViaLinearSearchUsingAddition2 = new Stopwatch();


    private static int mWinViaLinearSearchUsingAddition = 0;
    private static int mWinViaLinearSearchUsingMultiplication = 0;
    private static int mWinViaPrimeFactorsSearch = 0;

    public static void main(String[] args) {
        FactorUtils.calculateTwoFactorsViaLinearSearchUsingMultiplication(101); // Removes time outlier by loading class.

        for (int i = 0; i < 3000; i++) {
            testCalculateTwoFactors(i + 900000);
        }
        System.out.println("mWinViaLinearSearchUsingAddition: " + mWinViaLinearSearchUsingAddition + ", mWinViaLinearSearchUsingMultiplication: " + mWinViaLinearSearchUsingMultiplication + ", mWinViaPrimeFactorsSearch: " + mWinViaPrimeFactorsSearch);
    }

    private static void testCalculateTwoFactors(int number) {
        timer1.start();
        //System.out.println("calculateTwoFactorsViaLinearSearchUsingMultiplication(" + number + "): " + Factor.calculateTwoFactorsViaLinearSearchUsingMultiplication(number));
        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            FactorUtils.calculateTwoFactorsViaLinearSearchUsingMultiplication(number);
        }
        timer1.stop();

        timer2.start();
        //System.out.println("calculateTwoFactorsViaPrimeFactorsSearch(" + number + "): " + Factor.calculateTwoFactorsViaPrimeFactorsSearch(number));
        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            FactorUtils.calculateTwoFactorsViaPrimeFactorsSearch(number);
        }
        timer2.stop();

        timerViaLinearSearchUsingAddition1.start();
        //System.out.println("calculateTwoFactorsViaLinearSearchUsingAddition(" + number + "): " + Factor.calculateTwoFactorsViaLinearSearchUsingAddition(number));
        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            FactorUtils.calculateTwoFactorsViaLinearSearchUsingAddition(number);
        }
        timerViaLinearSearchUsingAddition1.stop();

        timer3.start();
        //System.out.println("calculateTwoFactorsViaLinearSearchUsingMultiplication(" + number + "): " + Factor.calculateTwoFactorsViaLinearSearchUsingMultiplication(number));
        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            FactorUtils.calculateTwoFactorsViaLinearSearchUsingMultiplication(number);
        }
        timer3.stop();

        timer4.start();
        //System.out.println("calculateTwoFactorsViaPrimeFactorsSearch(" + number + "): " + Factor.calculateTwoFactorsViaPrimeFactorsSearch(number));
        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            FactorUtils.calculateTwoFactorsViaPrimeFactorsSearch(number);
        }
        timer4.stop();

        timerViaLinearSearchUsingAddition2.start();
        //System.out.println("calculateTwoFactorsViaLinearSearchUsingAddition(" + number + "): " + Factor.calculateTwoFactorsViaLinearSearchUsingAddition(number));
        for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
            FactorUtils.calculateTwoFactorsViaLinearSearchUsingAddition(number);
        }
        timerViaLinearSearchUsingAddition2.stop();


        //System.out.println("timer1: " + timer1.getTime() + ", timer3: " + timer3.getTime());
        //System.out.println("timer2: " + timer2.getTime() + ", timer4: " + timer4.getTime());
        //System.out.println("timerViaLinearSearchUsingAddition1: " + timerViaLinearSearchUsingAddition1.getTime() + ", timerViaLinearSearchUsingAddition2: " + timerViaLinearSearchUsingAddition2.getTime());

        long averageTimeViaLinearSearchUsingAddition = getAverage(timerViaLinearSearchUsingAddition1.getTime(), timerViaLinearSearchUsingAddition2.getTime());
        long averageTimeViaLinearSearchUsingMultiplication = getAverage(timer1.getTime(), timer3.getTime());
        long averageTimeViaPrimeFactorSearch = getAverage(timer2.getTime(), timer4.getTime());
        if (averageTimeViaLinearSearchUsingMultiplication < averageTimeViaPrimeFactorSearch) {
            if (averageTimeViaLinearSearchUsingAddition < averageTimeViaLinearSearchUsingMultiplication) {
                mWinViaLinearSearchUsingAddition++;
            } else if (averageTimeViaLinearSearchUsingAddition > averageTimeViaLinearSearchUsingMultiplication) {
                mWinViaLinearSearchUsingMultiplication++;
            }
        } else if (averageTimeViaLinearSearchUsingMultiplication > averageTimeViaPrimeFactorSearch) {
            if (averageTimeViaLinearSearchUsingAddition < averageTimeViaPrimeFactorSearch) {
                mWinViaLinearSearchUsingAddition++;
            } else if (averageTimeViaLinearSearchUsingAddition > averageTimeViaPrimeFactorSearch) {
                mWinViaPrimeFactorsSearch++;
            }
        }
    }

    private static long getAverage(long... values) {
        long sum = 0;
        for (long i : values) {
            sum += i;
        }
        return sum / values.length;
    }

}