// Source: https://www.hackerrank.com/challenges/reverse-a-linked-list
public class Reverse {

    public Node reverse(Node head) {
        return reverse(head, null);
    }

    public Node reverse(Node listToReverseHead, Node reversedSuffixHead) {
        if (listToReverseHead == null) { return reversedSuffixHead; }
        Node newListToReverse = listToReverseHead.next;
        Node newReversedSuffixHead = listToReverseHead;
        newReversedSuffixHead.next = reversedSuffixHead;
        return reverse(newListToReverse, newReversedSuffixHead);
    }

    // Not tested.
    public Node reverseIter(Node head) {
        //if (head == null) { return head; }
        Node prev = null;
        Node curr = head;
        while (curr != null) {
          Node next = curr.next;
          curr.next = prev;
          prev = curr;
          curr = next;
        }
        return prev;
    }

    public Node reverse3(Node head) {
      if (head == null || head.next == null) { return head; }
      Node next = head.next;
      head.next = null;
      Node remaining = reverse3(next);
      next.next = head;
      return remaining;
    }

    // Note: This idea doesn't work yet because insertHead() changes
    // a necessary pointer. Just need to add pointer for 'next',
    // But, then there would be implicit dependencies. So, not a good
    // solution for long-term maintenance.
    // public Node reverse4(Node head) {
    //   Node reversedList = null;
    //   while (head != null) {
    //     reversedList = insertHead(reversedList, head);
    //     head = head.next;
    //   }
    //   return reversedList;
    // }
    // public Node insertHead(Node list, @NotNull Node newHead) {
    //   newHead.next = list;
    //   return newHead;
    // }

    public static class Node {
        int data;
        Node next;
    }

}
