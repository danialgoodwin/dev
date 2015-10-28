# Code Design Pattern Cheat Sheet #

TLDR:
- Code Design Patterns 101 Summary: Add an interface between things that may change. Create an abstraction to re-use or change functionality.
- Code Design Patterns 102 Summary: Read this page.

A design pattern is a repeatable solution for common problems in software design.

Providing names for these common pattern allows developers to talk about different potential solutions easier.

The main design patterns can be put into three main categories:

- Creational
- Structural
- Behavioral

Not all programming languages will need to use all of the design patterns in an app. Design patterns should be used as references and NOT just copied.

Disclaimer: The examples and definitions on this page are greatly simplified. There are typically multiple ways to implement each pattern, even though there is only one shown here for simplicity. These examples should be used to spark ideas to have a better implementation for your specific purpose. Check out the further resources section to learn more about each pattern.



## Creational Patterns ##
These creational design patterns deal with the creation of objects.

### Abstract Factory ###

### Builder ###
Abstraction for object creation.

    // This includes the 'Fluent' design by having the Builder class return
    // an instance of itself after each call so that calls can be directly
    // appended to each other.
    class MyClass {
      private int id;
      private String value;
      private MyClass(int id, String value) {
        this.id = id;
        this.value = value;
      }
      public class Builder {
        private int id;
        private String value;
        public Builder id(int id) { this.id = id; return this; }
        public Builder value(String value) { this.value = value; return this; }
        public MyClass build() { return new MyClass(id, value); }
      }
    }
    MyClass c = new MyClass.Builder().id(100).value("qwerty").build();

### Factory Method ###
Abstraction for object creation.

    class MyClass {
      MyClass newInstance() { return new MyClass(); }
    }

### Object Pool ###

### Prototype ###

### Singleton ###
One instance of a class.

    enum MyClass {
      INSTANCE;
      void doSomething() {}
    }
    MyClass.INSTANCE.doSomething();



## Structural Patterns ##
These structure design patterns deal with how classes and objects are related.

### Adapter ###
Convert an object to another valid type for another object.

    class MyAdapterClass {
      String getName(ContactInfo info) { return info.name; }
    }

### Bridge ###

### Composite ###

### Decorator ###

### Facade ###
Provide a higher abstraction for objects.

    class MyFacadeClass {
      String getInfo() {
        return anotherClass1.getName() +
            anotherClass2.getAddress() +
            anotherClass3.getContacts();
      }
    }
    class AnotherClass1 {
      String getName() { return "Name"; }
    }
    class AnotherClass2 {
      String getAddress() { return "Address"; }
    }
    class AnotherClass3 {
      String getContacts() { return "Contacts"; }
    }

### Flyweight ###
Share and re-use parts of objects.

    class MyFlyweightManager {
      HeavyThing getHeavyThing(int num) {
        if (!unchangingPart.exists()) { unchangingPart.create(); }
        return new HeavyThing(unchangingPart, num);
      }
    }
    class HeavyThing {
      UnchangingPart u;
      int c; // ChangingPart
      HeavyThing(UnchangingPart u, int c) {
        this.u = u;
        this.c = c;
      }
    }

### Private Class Data ###
Encapsulate data for safety/security/validity.

    class MyClass {
      private String data;
      public String getData() { return data; }
    }

### Proxy ###
Abstraction to change functionality.

    class UserProxyAtm {
      int getMoney(int amount) {
        if (hasSufficientFunds(amount)) {
          return atm.getMoney(amount);
        }
        return 0;
      }
    }
    class Atm {
      int getMoney(int amount) { return amount; }
    }



## Behavioral Patterns ##
These behavioral design patterns deal with communication between objects.

### Chain of Responsibility ###

### Command ###
Turn an action into an object.

    interface MyCommandInterface {
      void execute();
    }
    class AddOneCommand implements MyCommandInterface {
      Counter counter;
      void execute() { counter.count++; }
    }

### Interpreter ###
Convert something [text/sound/input] to more easily usable hierarchy of code.

### Iterator ###


### Mediator ###

### Memento ###

### Null Object ###
Allow API caller to not have to do null checks.

    List getList(int size) {
      if (size < 0) { size = 0; }
      return new List(size); // Instead of return null;
    }
    for item in getList(0) {
      // Do something
    }

### Observer ###
Allow other objects to know when an event has happened.

    class MyClass {
      private OnStateChangeListener listener;
      private int state;

      public void setListener(OnStateChangeListener l) {
        listener = l;
      }
      public void changeState(int newState) {
        state = newState;
        if (listener != null) { listener.onStateChange(state); }
      }
      public interface OnStateChangeListener {
        void onStateChange(int state);
      }
    }

### State ###

### Strategy ###

### Template Method ###

### Visitor ###
Add behavioral to a class on the outside.

    class MyClass {
      Graph graph;
      void examine() {
        for node in graph {
          visit(node);
        }
      }
      void visit(Node node) {
        println node.toString();
      }
    }



## Further Resources ##
- Awesome: [Design Patterns](https://sourcemaking.com/design_patterns)

- TODO: http://javapapers.com/category/design-patterns/
- TODO: https://github.com/iluwatar/java-design-patterns
