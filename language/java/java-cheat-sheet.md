# Java Cheat Sheet
(Released in 1995)



## How to compile and run Java code

    javac SampleProject.java
    java SampleProject

    // Or, together
    javac SampleProject.java && java SampleProject



## How to run JAR files

    java -jar my-project.jar

### How to specify the Main.class when running a JAR file

    // cp stands for class-path
    java -cp my-project.jar com.example.Main



## Strings and variables

    public class Test {
      public static void main(String[] args) {
        String name = "Dan";
        System.out.println("Hello, " + name);
      }
    }



### Simple Example

Short adlib program:

    import java.io.Console;
    public class Test {
      public static void main(String[] args) {
        Console console = System.console();
        String name = console.readLine("Name: ");
        String adjective = console.readLine("Adjective: ");
        console.printf("%s is very %s\n", name, adjective);
      }
    }

To run this in a console, enter the following: (The double ampersand allows multiple commands if the previous one succeeds.)

    clear && javac Test.java && java Test



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
