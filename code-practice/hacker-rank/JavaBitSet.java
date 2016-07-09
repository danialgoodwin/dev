import java.io.*;
import java.util.*;

// More info: https://www.hackerrank.com/challenges/java-bitset
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        for (int i = 0; i < m; i++) {
            String command = sc.next();
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();
            BitSet s1 = p1 == 1 ? b1 : b2;
            BitSet s2 = p2 == 1 ? b1 : b2;
            switch(command) {
                case "AND":
                    s1.and(s2);
                    break;
                case "XOR":
                    s1.xor(s2);
                    break;
                case "OR":
                    s1.or(s2);
                    break;
                case "FLIP":
                    s1.flip(p2);
                    break;
                case "SET":
                    s1.set(p2);
                    break;
            }
            System.out.println(b1.cardinality() + " " + b2.cardinality());
            //System.out.println(b1 + " " + b2);
        }
    }
}
