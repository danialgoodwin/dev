import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dan on 10/9/15.
 */
public class FactorUtils0 {
    private static void log(String message) {
        System.out.println(message);
    }

    private static final boolean IS_OPTIMIZE_FOR_PRIME_FACTORS = true;

    public static List<String> factor(String value) {
        List<String> factors = new ArrayList<>();
        int[] a = new int[value.length() + 1];
        int[] b = new int[value.length() + 1];
        int[] carry = new int[value.length() + 2];
        Arrays.fill(a, -1);
        Arrays.fill(b, -1);
        Arrays.fill(carry, 0);
        if (IS_OPTIMIZE_FOR_PRIME_FACTORS) { a[0] = 1; b[0] = 0; } // Won't be divisible by 10.
        factor(value, a, b, carry, factors);
        return factors;
    }

    private static void factor(final String value, int[] factorA, int[] factorB, int[] carry, List<String> factors) {
        final int valLength = value.length();
        int currentValueColumn = 1;
        while (true) {
//            log("factorA=" + toString(factorA) + "\t\tfactorB=" + toString(factorB));
            if (currentValueColumn == 0) {
                log("ERROR: No factors found");
                log("factorA=" + toString(factorA));
                log("factorB=" + toString(factorB));
                log("carry=" + toString(carry));
            }
            int columnValueToMatch = Character.getNumericValue(value.charAt(valLength - currentValueColumn));
            boolean isPossibleColumnFound = false;
            for (int a = Math.max(0, factorA[currentValueColumn - 1]); a <= 9; a++) {
                for (int b = factorB[currentValueColumn - 1] + 1; b <= 9; b++) {
                    factorA[currentValueColumn - 1] = a;
                    factorB[currentValueColumn - 1] = b;
                    int c = calculateColumn(factorA, factorB, carry, currentValueColumn);
                    carry[currentValueColumn] = c / 10;
                    if (currentValueColumn == valLength) {
                        int d = calculateColumn(factorA, factorB, carry, currentValueColumn + 1);
                        if (d > 0 || c > columnValueToMatch || isTooManyDigits(valLength, factorA, factorB, currentValueColumn)) {
                            a = 9;
                            b = 9;
                        } else if (c == columnValueToMatch && d == 0) {
                            factors.add(toString(factorA));
                            factors.add(toString(factorB));
                            log("factors=" + factors);
                            if (factors.size() > 2) {
                                return;
                            }
                        }
                    } else if (c % 10 == columnValueToMatch) {
                        isPossibleColumnFound = true;
                        break;
                    }
                }
                if (isPossibleColumnFound) {
                    break;
                } else {
                    factorB[currentValueColumn - 1] = -1;
                    carry[currentValueColumn] = 0;
                }
            }
            if (isPossibleColumnFound) {
                if (isTooManyDigits(valLength, factorA, factorB, currentValueColumn)) {
                    factorA[currentValueColumn - 1] = 9;
                } else {
                    currentValueColumn++;
                }
            } else {
                factorA[currentValueColumn - 1] = -1;
                factorB[currentValueColumn - 1] = -1;
                carry[currentValueColumn] = 0;
                currentValueColumn--;
            }
        }
    }

    /* package */ static boolean isTooManyDigits(final int valLength, int[] a, int[] b, int currentValueColumn) {
        int aLength = currentValueColumn - 1;
        while (a[aLength] == 0) { aLength--; }
        aLength++;
        int bLength = currentValueColumn - 1;
        while (b[bLength] == 0) { bLength--; }
        bLength++;
        return aLength + bLength - valLength > 1;
    }

    private static int calculateColumn(int[] a, int[] b, int[] carry, int currentValueColumn) {
        int sum = 0;
        int left = currentValueColumn - 1;
        while (a[left] == -1) { left--; }
        int right = Math.max(0, currentValueColumn - left - 1);
        for (int i = 0; i <= left - right; i++) {
            sum += (a[left - i] * b[right + i]);
        }
        return sum + carry[currentValueColumn - 1];
    }

    private static String toString(int[] a) {
        StringBuilder sb = new StringBuilder(a.length);
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] != -1) {
                sb.append(a[i] % 10);
            }
        }
        return sb.toString();
    }

}
