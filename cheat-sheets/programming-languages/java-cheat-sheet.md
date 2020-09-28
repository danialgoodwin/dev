# Java Cheat Sheet



## Background
Java was released in 1995 by Sun Microsystems, then Oracle bought Sun in 2010. 


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



## UI
JavaFX replaces Swing. Both of these native-Java tools use AWT (Abstract Window Toolkit).



## Interview questions


Low priority:
- What is the difference between the JDK, JRE, and JVM? The Java Runtime Environment (JRE) is intended for end-users and will run Java programs. The Java Development Kit (JDK) is intended for software developers and includes developments tools for building and debugging Java programs. The Java Virtual Machine (JVM) 



## Resources
