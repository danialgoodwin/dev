/**
 * Created by Danial on 2/9/2015.
 */
package com.danialgoodwin.projecteuler.question;

/**
 * The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.

 73167176531330624919225119674426574742355349194934
 96983520312774506326239578318016984801869478851843
 85861560789112949495459501737958331952853208805511
 12540698747158523863050715693290963295227443043557
 66896648950445244523161731856403098711121722383113
 62229893423380308135336276614282806444486645238749
 30358907296290491560440772390713810515859307960866
 70172427121883998797908792274921901699720888093776
 65727333001053367881220235421809751254540594752243
 52584907711670556013604839586446706324415722155397
 53697817977846174064955149290862569321978468622482
 83972241375657056057490261407972968652414535100474
 82166370484403199890008895243450658541227588666881
 16427171479924442928230863465674813919123162824586
 17866458359124566529476545682848912883142607690042
 24219022671055626321111109370544217506941658960408
 07198403850962455444362981230987879927244284909188
 84580156166097919133875499200524063689912560717606
 05886116467109405077541002256983155200055935729725
 71636269561882670428252483600823257530420752963450

 Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?

 */
public class Q8_LargestProductInSeries extends Question {

    @Override
    protected String getQuestionName() {
        return "Q8_LargestProductInSeries";
    }

    @Override
    public void solve() {
        String givenNumber =
                "73167176531330624919225119674426574742355349194934" +
                "96983520312774506326239578318016984801869478851843" +
                "85861560789112949495459501737958331952853208805511" +
                "12540698747158523863050715693290963295227443043557" +
                "66896648950445244523161731856403098711121722383113" +
                "62229893423380308135336276614282806444486645238749" +
                "30358907296290491560440772390713810515859307960866" +
                "70172427121883998797908792274921901699720888093776" +
                "65727333001053367881220235421809751254540594752243" +
                "52584907711670556013604839586446706324415722155397" +
                "53697817977846174064955149290862569321978468622482" +
                "83972241375657056057490261407972968652414535100474" +
                "82166370484403199890008895243450658541227588666881" +
                "16427171479924442928230863465674813919123162824586" +
                "17866458359124566529476545682848912883142607690042" +
                "24219022671055626321111109370544217506941658960408" +
                "07198403850962455444362981230987879927244284909188" +
                "84580156166097919133875499200524063689912560717606" +
                "05886116467109405077541002256983155200055935729725" +
                "71636269561882670428252483600823257530420752963450";
        int numAdjacent = 13;

        long answer = getGreatestAdjacentProduct(givenNumber, numAdjacent);
        log("Answer: " + answer);
    }

    /**
     * Ideas for improvement:
     * - Check for zeros and skip some indexes
     * Space: O(1), time: (n)
     * @param givenNumber list of digits, invalid if anything is not a digit
     * @param numAdjacent number of digits in string to find product of
     * @return product
     */
    private long getGreatestAdjacentProduct(String givenNumber, int numAdjacent) {
        // Invalid inputs.
        if (givenNumber == null || givenNumber.isEmpty() || givenNumber.length() < numAdjacent ||
                numAdjacent <= 0) { return 0; }

        // Assign max to the first possible adjacent numbers.
        long maxProduct =  getProduct(givenNumber.substring(0, numAdjacent));
        int length = givenNumber.length();
        long currentProduct = maxProduct;
        for (int i = numAdjacent; i < length; i++) {
            // Multiply by next number, divide by last number so that numAdjacent is maintained.
            short lastNum = Short.parseShort("" + givenNumber.charAt(i - numAdjacent));
            if (lastNum != 0) {
                currentProduct /= lastNum;
                currentProduct *= Short.parseShort("" + givenNumber.charAt(i));
            } else {
                // Now that there isn't a zero, recalculate adjacent numbers.
                currentProduct = getProduct(givenNumber.substring(i - numAdjacent + 1, i + 1));
            }
            if (currentProduct > maxProduct) {
                maxProduct = currentProduct;
            }
        }

        return maxProduct;
    }

    /** Returns the product of all the numbers in char list. Returns 0 if empty or contains non-digit. */
    public static long getProduct(CharSequence input) {
        if (input == null || input.length() == 0) { return 0; }

        long product = 1;
        int length = input.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(input.charAt(i))) { return 0; }

            short digit = Short.parseShort("" + input.charAt(i));
            if (digit == 0) { return 0; }

            product *= digit;
        }

        return product;
    }

}
