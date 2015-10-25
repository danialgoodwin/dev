/**
 * Created by dan on 10/25/15.
 */
package com.anonsage.question;

import java.util.Scanner;

/**
 * Theatre Square in the capital city of Berland has a rectangular shape with the size n × m meters. On the occasion of the city's anniversary, a decision was taken to pave the Square with square granite flagstones. Each flagstone is of the size a × a.

 What is the least number of flagstones needed to pave the Square? It's allowed to cover the surface larger than the Theatre Square, but the Square has to be covered. It's not allowed to break the flagstones. The sides of flagstones should be parallel to the sides of the Square.

 Input
 The input contains three positive integer numbers in the first line: n,  m and a (1 ≤  n, m, a ≤ 109).

 Output
 Write the needed number of flagstones.

 * More info: http://codeforces.com/problemset/problem/1/A
 */
public class TheatreSquare {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int answer = solve(n, m, a);
        System.out.println("answer=" + answer);
    }

    private static int solve(int n, int m, int a) {
        int numFlagstoneSideN = n / a;
        if (n % a != 0) { numFlagstoneSideN++; }
        int numFlagstoneSideM = m / a;
        if (m % a != 0) { numFlagstoneSideM++; }
        return numFlagstoneSideN * numFlagstoneSideM;
    }

}
