/**
 * Created by Danial on 1/24/2015.
 */
package com.danialgoodwin.interviewcake.question;

// Question found at: https://www.interviewcake.com/question/product-of-other-numbers

import java.util.Arrays;

/**
 * "You have an array of integers, and for each index you want to find the product of every integer except the integer
 * at that index. Do not use division in your solution."
 */
public class ProductOfOtherNumbersQuestion extends Question {

    @SuppressWarnings("ConstantConditions")
    @Override
    public void solve() {
        int[] numbers = {1, 7, 3, 4}; // Expect solution to be [84, 12, 28, 21].
//        System.out.println("numbers: " + Arrays.toString(numbers));

        int[] products = getProductsExceptAtIndex(numbers);
        System.out.println("ProductOfOtherNumbersQuestion. input: " + Arrays.toString(numbers) + ", getProductsExceptAtIndex: " + Arrays.toString(products));

        int[] numbers2 = {2, 3}; // Expect solution to be [3, 2].
        int[] products2 = getProductsExceptAtIndex(numbers2);
        System.out.println("ProductOfOtherNumbersQuestion. input: " + Arrays.toString(numbers2) + ", getProductsExceptAtIndex: " + Arrays.toString(products2));

        int[] numbers3 = {2}; // Expect solution to be [1].
        int[] products3 = getProductsExceptAtIndex(numbers3);
        System.out.println("ProductOfOtherNumbersQuestion. input: " + Arrays.toString(numbers3) + ", getProductsExceptAtIndex: " + Arrays.toString(products3));

        int[] numbers4 = null; // Expect no crash.
        int[] products4 = getProductsExceptAtIndex(numbers4);
        System.out.println("ProductOfOtherNumbersQuestion. input: " + Arrays.toString(numbers4) + ", getProductsExceptAtIndex: " + Arrays.toString(products4));
    }

    // This can be made more space efficient by not creating a new array for `productsFromFrontToBack`, instead we
    // would just store an int/long that held the current product up to that index.
    // Space: O(2n), Time: O(2n).
    public int[] getProductsExceptAtIndex(int[] numbers) {
        if (numbers == null) { return null; }
        int length = numbers.length;
        if (length == 0) { return numbers; }
        else if (length == 1) { return new int[]{1}; }

        int[] productsFromFrontToBack = new int[length];
        int[] productsFromBackToFront = new int[length];
        Arrays.fill(productsFromFrontToBack, 1);
        Arrays.fill(productsFromBackToFront, 1);

        // Set up simple products.
        productsFromFrontToBack[0] = numbers[0];
        productsFromBackToFront[length - 1] = numbers[length - 1];
        for (int i = 1; i < length - 1; i++) {
            productsFromFrontToBack[i] = numbers[i] * productsFromFrontToBack[i - 1];
            productsFromBackToFront[length - 1 - i] = numbers[length - i - 1] * productsFromBackToFront[length - i];
        }
//        System.out.println("productsFromFrontToBack: " + Arrays.toString(productsFromFrontToBack));
//        System.out.println("productsFromBackToFront: " + Arrays.toString(productsFromBackToFront));

        // Calculate final products.
        int productFromFront = productsFromFrontToBack[0];
        productsFromFrontToBack[0] = productsFromBackToFront[1];
        for (int i = 1; i < length - 1; i++) {
            int tempProductFromFront = productsFromFrontToBack[i];
            productsFromFrontToBack[i] = productFromFront * productsFromBackToFront[i + 1];
            productFromFront = tempProductFromFront;
        }
        productsFromFrontToBack[length - 1] = productFromFront;

        return productsFromFrontToBack;
    }

}
