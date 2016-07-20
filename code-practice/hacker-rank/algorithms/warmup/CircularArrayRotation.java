import java.io.*;
import java.util.*;

// More info: https://www.hackerrank.com/challenges/circular-array-rotation
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[(i + k) % n] = a[i];
        }
        for (int i = 0; i < q; i++) {
            int pos = in.nextInt();
            System.out.println(b[pos]);
            //System.out.println(a[(pos - k + n) % n]);
        }
    }
}
