
/** Given two arbitrary large strings with only zeros and ones, write a function to add them. */
public class AddBinaryStrings {

    public static void main(String[] args) {
        String a = "00000000";
        String b = "00000000";
        System.out.println(a + " + " + b + " = " + addBinary2(a, b));
        a = "00000001";
        b = "00000000";
        System.out.println(a + " + " + b + " = " + addBinary2(a, b));
        a = "11111111";
        b = "11111111";
        System.out.println(a + " + " + b + " = " + addBinary2(a, b));
        a = "11111111";
        b = "00000000";
        System.out.println(a + " + " + b + " = " + addBinary2(a, b));
        a = "1111";
        b = "00000000";
        System.out.println(a + " + " + b + " = " + addBinary2(a, b));
        a = "00001111";
        b = "00111100";
        System.out.println(a + " + " + b + " = " + addBinary2(a, b));
    }
    
    // Assuming LSB at index 0.
    public static String addBinary(String a, String b) {
        if (a == null || b == null) { return ""; }
        
        int lengthA = a.length();
        int lengthB = b.length();
        int lengthFinal = (lengthA > lengthB) ? lengthA : lengthB;
        
        StringBuilder sb = new StringBuilder(lengthFinal + 1);
        
        int iterA = 0;
        int iterB = 0;
        int carry = 0;
        
        while (iterA < lengthA && iterB < lengthB) {
            char charA = a.charAt(iterA);
            char charB = b.charAt(iterB);
            int sum = ((charA == '0') ? 0 : 1) + ((charB == '0') ? 0 : 1) + carry;
        
            switch (sum) {
                case 0:
                    sb.append('0');
                    carry = 0;
                    break;
                case 1:
                    sb.append('1');
                    carry = 0;
                    break;
                case 2:
                    sb.append('0');
                    carry = 1;
                    break;
                case 3:
                    sb.append('1');
                    carry = 1;
                    break;
                default:
                    //throw IllegalArgumentException("sum can only be 0, 1, 2, or 3");
                    break;
            }
   
            iterA++;
            iterB++;
        }
        
        // TODO: Still need to handle carry case here.
        // Merge rest if available.
        if (iterA < lengthA) {
            sb.append(a.substring(iterA));
        } else if (iterB < lengthB) {
            sb.append(b.substring(iterB));
        } else if (carry == 1) {
            sb.append('1');
        }
        
        return sb.toString();
    }

    // Assuming LSB at index 0.
    public static String addBinary2(String a, String b) {
        if (a == null || b == null) { return ""; }

        int lengthA = a.length();
        int lengthB = b.length();
        
        String small = (lengthA <= lengthB) ? a : b;
        
        StringBuilder sb = new StringBuilder((lengthA > lengthB) ? a : b);
        
        int carry = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (carry == 1) {
                if (sb.charAt(i) == '0') {
                    sb.setCharAt(i, '1');
                    carry = 0;
                } else {
                    sb.setCharAt(i, '0');
                    carry = 1;
                }
            }
            
            if (i < small.length()) {
                if (small.charAt(i) == '1') {
                    if (sb.charAt(i) == '0') {
                        sb.setCharAt(i, '1');
                    } else {
                        sb.setCharAt(i, '0');
                        carry = 1;
                    }
                }
            } else {
                break;
            }
        }
        
        if (carry == 1) {
            sb.append('1');
        }
        
        return sb.toString();
    }
    
    // This doesn't return the leading zeros. But, that could be added by appending zeros until
    // the final result matched the length of at least the largest input.
    public static String addBinary3(String a, String b) {
        if (a == null || b == null) { return ""; }

        int intA = Integer.parseInt(a, 2);
        int intB = Integer.parseInt(b, 2);
        
        int sum = intA = intB;
        
        return Integer.toBinaryString(sum);
    }
}