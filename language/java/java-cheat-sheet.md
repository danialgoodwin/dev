# Java Cheat Sheet




## Console

Simple example for reading console input:

    import java.util.Sacnner;
    public class Test {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println("Hello, " + input);
      }
    }


    import java.io.Console;
    public class Test {
      public static void main(String[] args) {
        Console console = System.console();
        String name = console.readLine("Name: ");
        switch (name) {
          case "dan":
            console.printf("Access granted");
            //System.out.println("Access granted");
            break;
          default:
            console.printf("Access denied");
            //System.out.println("Access denied");
            //System.exit(0);
        }
      }
    }



## More Info
- Java SE stands for "standard edition"
