/**
 * Created by Danial on 5/3/2015.
 */
package com.danialgoodwin.interviewcake.question;

import java.util.ArrayList;
import java.util.List;

/** Write a recursive function for generating all permutations of an input string. Return them as an array.
 Don't worry about duplicates—assume every character is unique.

 Don't worry about time or space complexity—if we wanted efficiency we'd write an iterative version.

 Your function can have loops—it just needs to also be recursive.
 *
 * Website: https://www.interviewcake.com/question/recursive-string-permutations
 */
public class RecursiveStringPermutations extends Question {

    public static void main(String[] args) {
        String input = "abcd";
        System.out.println("input=" + input);
        System.out.println("answer=" + findPermutationsRecursively(input));
    }

    @Override
    protected String getQuestionName() {
        return "RecursiveStringPermutations";
    }

    @Override
    public void solve() {
        main(null);
    }

    // Possible optimizations:
    // - Initialize ArrayList with capacity for input.length() factorial.
    private static List<String> findPermutationsRecursively(String input) {
        List<String> permutations = new ArrayList<>();
        findPermutationsRecursivelyHelper("", input, permutations);
        return permutations;
    }

    // This uses a bottom-up approach. There are at least two other ways of doing this recursively.
    // Note: This removes duplicate characters in input.
    private static void findPermutationsRecursivelyHelper(String startsWith,
            String additionalCharacters, List<String> permutations) {
        int length = additionalCharacters.length();
        if (length <= 1) {
            permutations.add(startsWith + additionalCharacters);
            return;
        }
        for (int i = 0; i < length; i++) {
            String charToReplace = additionalCharacters.substring(i, i + 1);
            findPermutationsRecursivelyHelper(startsWith + charToReplace, additionalCharacters.replace(charToReplace, ""), permutations);
        }
    }

}
