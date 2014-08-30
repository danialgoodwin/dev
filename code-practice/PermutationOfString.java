
/** Print all possible permutations of an input. */
public class PermutationOfString {

    public static void main(String[] args) {
        printPermutation("123".toCharArray()); // Works.
        System.out.println("\n");
        printPermutation("112".toCharArray()); // Need to handle same character case.
        System.out.println("\n");
        printPermutation("111".toCharArray());
        System.out.println("\n");
        printPermutation("1".toCharArray());
        System.out.println("\n");
        printPermutation("".toCharArray());
    }
    
    public static void printPermutation(char[] input) {
        printPermutation(input, 0);
    }
    
    public static void printPermutation(String input) {
        printPermutation(input.toCharArray(), 0);
    }
    
    private static void printPermutation(char[] input, int currentFocus) {
        // Input validation. Could possibly `throw IllegalArgumentException` or
        // define other contracts for this method.
        if (input == null || input.length == 0 || currentFocus < 0 || currentFocus > input.length - 1) { return; }
        
        // Print when focused on the last index.
        // Was `==`, but this now covers the case for empty string and a large currentFocus input.
        // (Then, changed back because it is now covered in the input validation.)
        if (currentFocus == input.length - 1) {
            System.out.println(new String(input));
            return;
        }
        
        // First run through, keep all of the input in order.
        printPermutation(input, currentFocus + 1);
        
        // Swap each currentFocus index with next index.
        for (int i = currentFocus + 1; i < input.length; i++) {
            // Only swap if values are different. This handles the case for
            // index values being the same.
            if (input[currentFocus] == input[i]) { continue; }
        
            char temp = input[currentFocus];
            input[currentFocus] = input[i];
            input[i] = temp;
            
            // Method A. Need to clone so that the order of the original isn't messed up.
            //printPermutation(input.clone, currentFocus + 1);
            
            // Method B. Swap back indexes after recurse.
            printPermutation(input, currentFocus + 1);
            input[i] = input[currentFocus];
            input[currentFocus] = temp;
        }
    }
    
}