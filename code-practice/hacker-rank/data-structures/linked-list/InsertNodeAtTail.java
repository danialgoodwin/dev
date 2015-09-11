// Source: https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list
public class InsertNodeAtTail {

      public Node insert(Node head, int data) {
          Node nodeToInsert = new Node();
          nodeToInsert.data = data;
          if (head == null) { return nodeToInsert; }
          Node listElement = head;
          while (listElement.next != null) {
              listElement = listElement.next;
          }
          listElement.next = nodeToInsert;
          return head;
      }

      public static class Node {
          int data;
          Node next;
      }
      
}
