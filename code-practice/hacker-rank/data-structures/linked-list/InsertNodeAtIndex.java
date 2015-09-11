// Source: https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list
public class InsertNodeAtIndex {


      public Node insert(Node head, int data, int position) {
          Node nodeToInsert = new Node();
          nodeToInsert.data = data;

          if (position == 0) {
              nodeToInsert.next = head;
              return nodeToInsert;
          }

          Node elementBefore = head;
          for (int i = 1; i < position; i++) {
              elementBefore = elementBefore.next;
          }

          nodeToInsert.next = elementBefore.next;
          elementBefore.next = nodeToInsert;

          return head;
      }

      public static class Node {
          int data;
          Node next;
      }

}
