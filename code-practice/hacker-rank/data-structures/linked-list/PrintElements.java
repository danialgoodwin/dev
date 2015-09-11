// Source: https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list
public class PrintElements {
  void print(Node head) {
    if (head == null) { return; }
    System.out.println(String.valueOf(head.data));
    print(head.next);
  }

  public static class Node {
    int data;
    Node next;
  }
}
