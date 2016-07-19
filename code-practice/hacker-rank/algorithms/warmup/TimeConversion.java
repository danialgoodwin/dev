import java.io.*;
import java.util.*;

// More info: https://www.hackerrank.com/challenges/time-conversion
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.next();
        boolean isAm = line.charAt(8) == 'A';

        int hour = Integer.parseInt(line.substring(0, 2));
        if (isAm) {
            hour = (hour == 12) ? 0 : hour;
        } else {
            hour = (hour == 12) ? 12 : (hour + 12);
        }
        System.out.println(String.format("%02d", hour) + line.substring(2, 8));
    }
}
