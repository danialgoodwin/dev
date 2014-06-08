
import java.lang.StringBuilder;
import java.util.Stack;

/** Write an extended stack class that has a function getLargest() for returning the largest element in the stack. */
public class LargestStackTest2 {

    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        stack.push(-1);
        stack.push(3);
        stack.push(5);
        stack.push(20);
        stack.push(0);
        stack.push(0);
        stack.push(-1);
        log(stack.toString());
        
        Node largest = stack.getLargest();
        log("largest: " + largest);
        
        stack.pop();
        log(stack.toString());
        largest = stack.getLargest();
        log("largest: " + largest);
        
        stack.pop();
        log(stack.toString());
        largest = stack.getLargest();
        log("largest: " + largest);
        
        stack.pop();
        log(stack.toString());
        largest = stack.getLargest();
        log("largest: " + largest);
        
        stack.pop();
        log(stack.toString());
        largest = stack.getLargest();
        log("largest: " + largest);
        
        stack.pop();
        log(stack.toString());
        largest = stack.getLargest();
        log("largest: " + largest);
        
        stack.pop();
        log(stack.toString());
        largest = stack.getLargest();
        log("largest: " + largest);
        
        stack.pop();
        log(stack.toString());
        largest = stack.getLargest();
        log("largest: " + largest);
        
        stack.pop();
        log(stack.toString());
        largest = stack.getLargest();
        log("largest: " + largest);
        
    }

    private static void log(String message) {
        System.out.println(message);
    }
}


class CustomStack {
    Stack<Node> largest;
    Stack<Node> stack;
    
    CustomStack() {
        largest = new Stack<Node>();
        stack = new Stack<Node>();
    }
    
    public void push(int id) {
        Node newNode = new Node(id);
        stack.push(newNode);
        if (largest.isEmpty()) {
            largest.push(newNode);
        } else if (newNode.id > largest.peek().id) {
            largest.push(newNode);
        }
    }
    
    public Node pop() {
        if (stack.isEmpty()) { return null; }
        
        Node pop = stack.pop();
        if (pop.id == largest.peek().id) {
            largest.pop();
        }
        return pop;
    }
    
    /** Returns the largst node if available, otherwise null. */
    public Node getLargest() {
        if (largest.isEmpty()) { return null; }
        return largest.peek();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!stack.isEmpty()) {
            for (int i = 0; i < stack.size(); i++) {
                sb.append(stack.get(i).id).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}

class Node {
    int id;
    Node(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Node: " + id;
    }
}