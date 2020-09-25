# Software Design Pattern Cheat Sheet

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

Disclaimer: The examples and definitions on this page are greatly simplified. There are typically multiple ways to implement each pattern, even though there is only one shown here for simplicity. These examples should be used to spark ideas to have a better implementation for your specific purpose. I chose bad names for the examples so that you would be more motivated to not just copy them.

Check out the further resources section to learn more about each pattern.



## Creational Patterns
These creational design patterns deal with the creation of objects.

### Abstract Factory
Abstraction for creating different types of objects.

    class AbstractFactory {
      AbstractFactory create(int type) {
        switch (type) {
          case 1: return new OldFactory();
          case 2: return new NewFactory();
          case 3: return new BearFactory();
        }
      }
    }

### Builder
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

### Factory Method
Abstraction for object creation. Encapsulate the 'new' operator.

    class MyClass {
      MyClass newInstance() { return new MyClass(); }
    }

### Object Pool
Re-use objects.

    class ReusablePool<E extends Reusable> {
      int maxSize = 5;
      int curSize = 0;
      Deque<E> deque = new LinkedList<>();
      public E acquireReusable() {
        if (deque.isEmpty()) {
          if (curSize >= 5) { return null; }
          else { deque.push(createReusable()); curSize++; }
        }
        return deque.pop();
      }
      public void releaseReusable(E r) {
        deque.push(r);
      }
    }

### Prototype
Create new objects from a copy with common state.

    class UnfinishedObject {
      UnfinishedObject clone() {
        return new UnfinishedObject(this);
      }
    }


### Singleton
One instance of a class.

    enum MyClass {
      INSTANCE;
      void doSomething() {}
    }
    MyClass.INSTANCE.doSomething();



## Structural Patterns
These structure design patterns deal with how classes and objects are related.

### Adapter
Convert an object to another valid type for another object.

    class MyAdapterClass {
      String getName(ContactInfo info) { return info.name; }
    }

### Bridge
Create an interface for an interface.

    interface ThreadScheduler {}

    class PreemptiveThreadScheduler implements ThreadScheduler {}
    class TimeSlicedThreadScheduler implements ThreadScheduler {}

    class UnixPTS extends PreemptiveThreadScheduler {}
    class JvmPTS extends PreemptiveThreadScheduler {}
    class WindowsPTS extends PreemptiveThreadScheduler {}
    class UnixTSTS extends TimeSlicedThreadScheduler {}
    class JvmTSTS extends TimeSlicedThreadScheduler {}
    class WindowsTSTS extends TimeSlicedThreadScheduler {}

### Composite
Put objects in other objects.

    class Node<K, V> {
      K key;
      V value;
      Node left;
      Node right;
    }

### Decorator
Wrap an object and add actions for it.

    class DoSomething {
      Thing thing;
      void doSomething() {
        thing++;
      }
    }
    class DoSomethingAwesome {
      DoSomething something;
      void doSomethingAwesome() {
        something.thing+++++;
      }
    }


### Facade
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

### Flyweight
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

### Private Class Data
Encapsulate data for safety/security/validity.

    class MyClass {
      private String data;
      public String getData() { return data; }
    }

### Proxy
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



## Behavioral Patterns
These behavioral design patterns deal with communication between objects.

### Chain of Responsibility
Allow multiple optional objects to handle an action.

    class Client {
      void doSomething() {  }
    }
    class Pipeline {
      Action action;
      void doAction(Client c) {
        action1(c);
        action2(c);
        action3(c);
      }
    }
    class Action1 {
      Action next;
      void doAction(Client c) {
        ;; Maybe do something
        next.doAction(c);
      }
    }

### Command
Turn an action into an object.

    interface MyCommandInterface {
      void execute();
    }
    class AddOneCommand implements MyCommandInterface {
      Counter counter;
      void execute() { counter.count++; }
    }

### Interpreter
Convert something [text/sound/input] to more easily usable hierarchy of code.

### Iterator
Provide a way to access each element in a group without exposing underlying representation.

    interface Iterator<E> {
      boolean hasNext();
      E next();
      void remove();
    }

### Mediator
Define how different objects interact.

Ex: Control tower saying how different airplanes interact at airport.

    class MyMediatorClass {
      Message message;
      void setMessage(Message m) { message = m; }
      Message getMessage() { return message; }
    }
    class Producer {
      MyMediatorClass mediator;
      void run() {
        Message message = new Message(4);
        mediator.setMessage(message);
      }
    }
    class Consumer {
      MyMediatorClass mediator;
      void run() {
        Message message = mediator.getMessage();
      }
    }

### Memento
Save object state as an object.

Ex: Save previous state to allow for 'undo' or 'rollback' operations.

    class MyMemento {
      State state;
      MyMemento(State s) { state = s; }
    }
    class Originator {
      State state;
      MyMemento saveToMemento() {
        return new MyMemento(state);
      }
      void restoreFromMemento(MyMemento m) {
        state = m.state;
      }
    }
    class Caretaker {
      Stack<MyMemento> mementos = new Stack<>();
    }
    class Main {
      void main() {
        Caretaker c = new Caretaker();
        Originator o = new Originator();
        ;; Do something with o state
        c.mementos.push(o.saveToMemento());
        ;; Do something with o state
        c.mementos.push(o.saveToMemento());
        ;; Do something with o state
        o.restoreFromMemento(c.mementos.pop());
      }
    }

### Null Object
Allow API caller to not have to do null checks.

    List getList(int size) {
      if (size < 0) { size = 0; }
      return new List(size); // Instead of return null;
    }
    for item in getList(0) {
      // Do something
    }

### Observer
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

### State
Allow object to alter behavior when its state is changed.

Ex: Vending machine has different behavior in different states [based on money and inventory].

    abstract class State {
      State state;
      private State state1;
      private State state2;
      private State state3;

      void changeState() {
        int random = Random(1, 3);
        switch (random) {
          case 1: state = state1;
          case 2: state = state2;
          case 3: state = state3;
        }
      }
      void doSomething() {
        print "Need to initialize first";
      }
    }
    class State1 extends State {
      void doSomething() { print 'Hi'; }
    }
    class State2 extends State {
      void doSomething() { print 'Hello'; }
    }
    class State3 extends State {
      void doSomething() { print 'Bonjour'; }
    }

### Strategy
Create an abstraction for algorithm implementation.

Ex: Open-close principle: Open for extension, closed for modification.

Ex: Transportation strategy: Take car, taxi, walk, bike, metro, helicopter.

    interface MyRandomStrategy {
      int random();
    }
    class SimpleRandom extends MyRandomStrategy {
      int random() { return Random(1, 10); }
    }
    class ComplexRandom extends MyRandomStrategy {
      int random() { return 4; }
    }

### Template Method
Allow subclass to define certain parts of an algorithm.

    abstract class FrameworkClass {
      void doSomething() { step1(); step2(); step3(); }
      void step1() {}
      abstract void step2() {}
      void step3() {}
    }
    class ApplicationClass1 extends FrameworkClass {
      void step2() {}
    }
    class ApplicationClass2 extends FrameworkClass {
      void step2() {}
    }

### Visitor
Add behavior to a class on the outside.

    class MyClass {
      Graph graph;
      void examine(Visitor visitor) {
        for node in graph {
          visitor.visit(node);
        }
      }
    }
    class Visitor1 implements Visitor {
      void visit(Node node) {
        println node.toString();
      }
    }



## Further Resources
- Awesome: [Design Patterns](https://sourcemaking.com/design_patterns)

- TODO: http://javapapers.com/category/design-patterns/
- TODO: https://github.com/iluwatar/java-design-patterns
