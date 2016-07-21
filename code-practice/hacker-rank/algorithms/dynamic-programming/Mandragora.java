import java.io.*;
import java.util.*;

// More info: https://www.hackerrank.com/challenges/mandragora
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int testNum = 0; testNum < t; testNum++) {
            int n = in.nextInt();
            int[] hps = new int[n];
            for (int i = 0; i < n; i++) {
                hps[i] = in.nextInt();
            }
            Arrays.sort(hps);
            long[] hpSums = new long[n];
            hpSums[n - 1] = hps[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                hpSums[i] = hpSums[i + 1] + hps[i];
            }
            long maxXp = 0;
            for (int i = 0; i < n; i++) {
                // Eat one extra monster each loop. Eating all monsters means 0xp
                long s = 1 + i;
                long xp = s * hpSums[i];
                if (maxXp < xp) { maxXp = xp; }
            }
            System.out.println(maxXp);
        }
    }
}
