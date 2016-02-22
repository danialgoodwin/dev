# Java Cheat Sheet - Reflection



## Classes
The starting point for using reflection operations is through `java.lang.Class`.

If an instance exists, then use `Object.getClass()`. Example: `"foo".getClass()`, `mMyObject.getClass()`, `(new byte[1024]).getClass()`.

If no instance exists, but a type is available, then you can get `Class` by appending ".class". Example: `MyObject.class`, `int[][][].class`, and `boolean.class`.

To have more dynamic access to `Class`, you can use the fully-qualified name. Example: `Class.forName("com.example.myapp.MyObject")`.

    // Examples
    // Source: http://docs.oracle.com/javase/tutorial/reflect/class/classNew.html
    Class cDoubleArray = Class.forName("[D"); // Same as `double[].class`.
    Class cStringArray = Class.forName("[[Ljava.lang.String;"); // Same as `String[][].class`.

For wrappers of primitives and `void`, you can use the field `TYPE` to get the class. Example: `Double.TYPE` is the same as `double.class`, `Void.TYPE` is same as `void.class`.

A few more ways to get `Class`, after you already have one: `Class.getSuperclass()`, `Class.getClasses()`, `Class.getDeclaredClasses()`, `Class.getDeclaringClass()`, `Class.getEnclosingClass()`. The difference between `getClasses()` and `getDeclaredClasses()` is that the prior returns only the public classes, interfaces, and enums that are members of the class, including inherited members, whereas the later returns all the classes, interfaces, and enums that are explicitly declared in the class, which will include private members. [More info](http://docs.oracle.com/javase/tutorial/reflect/class/classNew.html).

    // Examples
    // Source: http://docs.oracle.com/javase/tutorial/reflect/class/classNew.html
    Class c = javax.swing.JButton.class.getSuperclass();
    Class<?>[] c = Character.class.getClasses();
    Class<?>[] c = Character.class.getDeclaredClasses();



## Members
More info: http://docs.oracle.com/javase/tutorial/reflect/member/index.html



## Arrays
More info: http://docs.oracle.com/javase/tutorial/reflect/special/index.html



## Enumerated Types
More info: http://docs.oracle.com/javase/tutorial/reflect/special/index.html



## More Info
- http://docs.oracle.com/javase/tutorial/reflect/
- http://docs.oracle.com/javase/8/docs/api/java/lang/reflect/package-summary.html
