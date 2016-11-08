import java.io.*;

/** Doing this is not recommended for performance reasons. */
public class DoubleBraceInitialization {

    /** First brace creates a new AnonymousInnerClass, the second declares an
        instance initializer block that is run when the anonymous inner class is instantiated. */
    private static final Set<String> VALID_CODES = new HashSet<String>() {{
        add("XZ13s");
        add("AB21/X");
        add("YYLEX");
        add("AR2D");
    }};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
    }

}
