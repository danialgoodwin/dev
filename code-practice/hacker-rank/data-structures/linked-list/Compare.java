// Source: https://www.hackerrank.com/challenges/compare-two-linked-lists
public class Compare {

    public int compareLists(Node headA, Node headB) {
        if (headA == null && headB == null) { return 1; }
        if (headA == null || headB == null) { return 0; }
        if (headA.data != headB.data) { return 0; }
        return compareLists(headA.next, headB.next);
    }

    public static class Node {
        int data;
        Node next;
    }

}
