// Source: https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists
public class Merge {


      // Merge two lists into a new one.
      public Node merge(Node headA, Node headB) {
          if (headA == null) return headB;
          if (headB == null) return headA;

          Node newListHead;
          if (headA.data < headB.data) {
              newListHead = headA;
              headA = headA.next;
          } else {
              newListHead = headB;
              headB = headB.next;
          }
          Node newListElement = newListHead;
          while (headA != null && headB != null) {
              if (headA.data < headB.data) {
                  newListElement.next = headA;
                  headA = headA.next;
              } else {
                  newListElement.next = headB;
                  headB = headB.next;
              }
              newListElement = newListElement.next;
          }
          newListElement.next = headA != null ? headA : headB;
          return newListHead;
      }

      public Node merge2(Node headA, Node headB) {
          if (headA == null) return headB;
          if (headB == null) return headA;
          Node a = new Node();
          if (headA.data < headB.data) {
              a.data = headA.data;
              headA = headA.next;
          } else {
              a.data = headB.data;
              headB = headB.next;
          }
          a.next = merge2(headA, headB);
          return a;
      }

      public Node merge3(Node headA, Node headB) {
          if (headA == null) return headB;
          if (headB == null) return headA;
          if (headA.data < headB.data) {
              headA.next = merge3(headA.next, headB);
              return headA;
          } else {
              headB.next = merge3(headB.next, headA);
              return headB;
          }
      }

      public Node merge4(Node a, Node b) {
          Node dummy = new Node();
          Node dummyHead = dummy;
          while (true) {
              if (a == null) { dummy.next = b; break; }
              if (b == null) { dummy.next = a; break; }
              if (a.data < b.data) {
                  dummy.next = a;
                  a = a.next;
              } else {
                  dummy.next = b;
                  b = b.next;
              }
              dummy = dummy.next;
          }
          return dummyHead.next;
      }

      public static class Node {
          int data;
          Node next;
      }

}
