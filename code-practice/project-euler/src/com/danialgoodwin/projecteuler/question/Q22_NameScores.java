/**
 * Created by Danial on 4/17/2015.
 */
package com.danialgoodwin.projecteuler.question;

import com.danialgoodwin.util.FileUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

 For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

 What is the total of all the name scores in the file?
 *
 * Website: https://projecteuler.net/problem=22
 */
public class Q22_NameScores extends Question {

    @Override
    protected String getQuestionName() {
        return "Q22_NameScores";
    }

    @Override
    public void solve() {
        List<String> names = getListOfNames();
        long answer = calculateNameScoresSum(names);
        log("answer=" + answer);
    }

    /**
     * Space: O(n/2) for sort, time: (n). This can be optimized by doing initial file read in one pass rather than three.
     *
     */
    private static long calculateNameScoresSum(List<String> names) {
        Collections.sort(names);
//        Arrays.sort(names, 0, names.size(), ...);
//        System.out.println("names.get(937)=" + names.get(937));
//        System.out.println("names.get(938)=" + names.get(938));
//        System.out.println("names.get(939)=" + names.get(939));

        long totalSum = 0;
        int length = names.size();
        for (int i = 0; i < length; i++) {
            int nameSum = 0;
            for (char ch : names.get(i).toUpperCase().toCharArray()) {
                nameSum += (int) ch - 'A' + 1;
            }
//            System.out.println("names.get(" + i + ")=" + names.get(i) + ", nameSum=" + nameSum);
            totalSum += (nameSum * (i + 1));
        }

        return totalSum;
    }

    // Note: This could potentially be optimized to just read through the list once rather than
    // three times. Perhaps with a Scanner and "," as delimiter, though, could be slow with lots
    // of back and forth from file?
    /** Return a list of names. If there is an error, then returns an empty list. */
    public static List<String> getListOfNames() {
        List<String> listOfListOfNames;
        try {
            listOfListOfNames = FileUtils.readAllLines("src/com/danialgoodwin/projecteuler/sourcefile/q22-name-scores.txt", StandardCharsets.UTF_8);
        } catch (IOException e) {
            listOfListOfNames = Collections.emptyList();
            e.printStackTrace();
        }
        List<String> names = new ArrayList<>();

        for (String ListOfNames : listOfListOfNames) {
            for (String name : ListOfNames.split(",")) {
                names.add(name.substring(1, name.length() - 1));
            }
        }

        return names;
    }

}
