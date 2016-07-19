# Java Cheat Sheet - String.printf

The printf function in many programming language are the same.


General format: `System.out.printf("%s %d", "high", 5);` // Outputs "high 5"

    s for string
    d for decimal integer
    f for float

    n newline (as opposed to /n)

Proceeding the above can be a few different options:

    a zero to pad with zeros to the left
    a number for right-aligned spacing
    a negative to left-align

    .2 to have two decimal places after the period
    , to have locale-specific decimal separators

Ex: To get an output like the following:

    java        0079
    c           0121
    ceylon      8025
    anonlang    3.14

    System.out.printf("%-12s%04d", "java", 79);
    System.out.printf("%-12s%04d", "c", 0121);
    System.out.printf("%-12s%04d", "ceylon", 8025);
    System.out.printf("%-12s%4.2f", "anonlang", 3.1415926535);



        /** Print staircase.
        #
       ##
      ###
     ####
    #####
   ######
        */
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append("#");
                System.out.printf("%" + n + "s\n", sb.toString());
            }
        }


## More Info
- [Formatting Numeric Print Output](https://docs.oracle.com/javase/tutorial/java/data/numberformat.html)
