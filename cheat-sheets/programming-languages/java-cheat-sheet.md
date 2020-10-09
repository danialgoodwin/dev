# Java Cheat Sheet



## Background
Java was released in 1995 by Sun Microsystems, then Oracle bought Sun in 2010. 

Java SE stands for Java Standard Edition. There is also Java Enterprise Edition (Java EE), which is now known as Jakarta EE.



## Running

### How to compile and run Java code

    javac MyExampleProject.java
    java MyExampleProject

    // Or, together
    javac MyExampleProject.java && java MyExampleProject

### How to run JAR files

    java -jar my-project.jar

Optionally, also specify the Main.class when running a JAR file:

    // cp stands for class-path
    java -cp my-project.jar com.example.Main



## Basic coding

Simple minimal example:

    public class MyApp {
        public static void main(String[] args) {
            String name = "Dan";
            System.out.println("Hello, " + name + "!");
        }
    }

Input/Output (ad-lib) example:

    import java.io.Console;
    
    /**
     * How to run this program: `javac MyApp.java && java MyApp`. The double ampersand runs the following command if the previous one succeeds.
     */
    public class MyApp {
        public static void main(String[] args) {
            Console console = System.console();
            String name = console.readLine("Name: ");
            String adjective = console.readLine("Adjective: ");
            console.printf("%s is very %s\n", name, adjective);
        }
    }

Another way to read console input:
    
    import java.util.Sacnner;
    public class MyApp {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String input = sc.next();
            System.out.println("Hello, " + input);
        }
    }



## UI
JavaFX replaces Swing. Both of these native-Java tools use AWT (Abstract Window Toolkit).



## Java version differences

### Java 15
- Records: (Second preview)
- Sealed classes: Restricts inheritance. Good for tools
- [Text Blocks](https://openjdk.java.net/jeps/378): Use `"""` for multi-line Strings

### Java 14 (GA on 2020-03-17)
- [Enhanced `switch`](https://openjdk.java.net/jeps/361): They can now be `switch` expressions, and more

### Java 13

### Java 12

### Java 11
- Enhanced `String`: `repeat(int)`, `lines()`, `strip()`, `isBlank()` and more...
- Enhanced `Files`: `readString(Path)` (ex: `Files.readString(Path.of("path/to/file"));`), `writeString(Path, String)`

### Java 10
- `var` type inference, limited to 'local variables' (inside methods). Ex: `var names = ArrayList<>();`

### Java 9
- Custom runtime images, aka remove unnecessary Java modules
- Private interface methods

### Java 8
- Non-abstract interface methods
- `Optional`
- Streams: https://mydeveloperplanet.com/2020/09/23/java-streams-by-example

### Java 7
- Diamond operator, aka type inference. Ex: `List<String> names = Arraylist<>();`
- try-with-resources

### Java 5
- Generics
- Enums
- Annotations



## Interview questions

- What is a memory leak in Java? When an object is no longer used by the app, but the garbage collector can't remove it from memory because it is still being referenced. Eventually, this may lead to an `OutOfMemoryError`. Examples of possible memory leaks: static field, interned String, unclosed stream/connection, threads, objects in a hash without implementing hashCode() and equals() because can't find duplicates.

Low priority:
- What is the difference between the JDK, JRE, and JVM? The Java Runtime Environment (JRE) is intended for end-users and will run Java programs. The Java Development Kit (JDK) is intended for software developers and includes developments tools for building and debugging Java programs. The Java Virtual Machine (JVM) 



## Resources
- Best book: 'Effective Java' by Josh Bloch
