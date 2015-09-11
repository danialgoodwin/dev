// Source: https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list
public class InsertNodeAtHead {

      public Node insert(Node head, int data) {
          Node nodeToInsert = new Node();
          nodeToInsert.data = data;
          nodeToInsert.next = head;
          return nodeToInsert;
      }

      public static class Node {
          int data;
          Node next;
      }

}
