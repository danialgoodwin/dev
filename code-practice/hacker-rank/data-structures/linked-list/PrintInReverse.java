// Source: https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse
public class PrintInReverse {

    public void reversePrint(Node head) {
        if (head == null) { return; }
        reversePrint(head.next);
        System.out.println(String.valueOf(head.data));
    }

    public static class Node {
        int data;
        Node next;
    }

}
