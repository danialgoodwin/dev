// Source: https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list
public class DeleteNodeAtIndex {

      public Node delete(Node head, int position) {
          if (position == 0) { return head.next; }

          Node listElement = head;
          for (int i = 1; i < position; i++) {
              listElement = listElement.next;
          }

          Node nodeBeforeDelete = listElement;
          nodeBeforeDelete.next = nodeBeforeDelete.next.next;

          return head;
      }

      public static class Node {
          int data;
          Node next;
      }

}
