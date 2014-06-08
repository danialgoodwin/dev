
/** Write an extended stack class that has a function getLargest() for returning the largest element in the stack.

Improvements:
- Less time, more space: Create a sorted stack of nodes in the stack, and get largest from there instead of doing `getLargestNode()`.
- In Stack.toString(), change from appending Strings to appending StringBuilders.
- Naming could be done better.

 */
public class LargestStackTest {

    public static void main(String[] args) {
        Stack stack = new Stack();
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


class Stack {
    private Node topNode;
    private Node largestNode;
    
    public void push(int id) {
        if (topNode == null) {
            topNode = new Node(id);
            largestNode = topNode;
        } else {
            Node newNode = new Node(id);
            newNode.setPreviousNode(topNode);
            topNode = newNode;
            if (topNode.getId() >= largestNode.getId()) {
                largestNode = topNode;
            }
        }
    }
    
    /** Returns the largest node in the stack. If there are no nodes, then returns null. */
    public Node getLargest() {
        return largestNode;
    }
    
    public Node pop() {
        Node topToPop = topNode;
        if (topToPop != null) {
            topNode = topToPop.getPreviousNode();
            if (topNode == null) {
                largestNode = null;
            } else {
                largestNode = getLargestNode();
            }
        }
        return topToPop;
    }
    
    /** Returns largest node in stack. This is a O(n) operation. */
    private Node getLargestNode() {
        Node pointer = topNode;
        Node largest = pointer;
        while (pointer != null) {
            if (pointer.getId() > largest.getId()) {
                largest = pointer;
            }
            pointer = pointer.getPreviousNode();
        }
        return largest;
    }
    
    @Override
    public String toString() {
        Node pointer = topNode;
        String s = "";
        while (pointer != null) {
            s += pointer.getId() + ",";
            pointer = pointer.getPreviousNode();
        }
        return s.substring(0, s.length());
    }
}


class Node {
    private Node previousNode;
    private int id;
    
    public Node(int id) {
        this.id = id;
    }
    
    public void setPreviousNode(Node n) {
        previousNode = n;
    }
    
    public Node getPreviousNode() {
        return previousNode;
    }
    
    public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return "Node: " + id + "";
    }
}