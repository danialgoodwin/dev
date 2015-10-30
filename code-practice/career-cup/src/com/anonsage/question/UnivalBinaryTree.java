/**
 * Created by dan on 10/30/15.
 */
package com.anonsage.question;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Check if the given binary tree is a unival tree. (all nodes have same value)

 Follow up- Count the number of unival subtrees in a binary tree.

 More info: http://www.careercup.com/question?id=5695780033658880
 */
public class UnivalBinaryTree {

    private static void log(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        Node n3 = new Node(1, null, null);
        Node n4 = new Node(1, null, null);

        Node n1 = new Node(1, null, null);
        Node n2 = new Node(1, n3, n4);

        Node root = new Node(1, n1, n2);
        log("isUnival=" + isUnival(root));
        log("countUnival=" + countUnivalSubtrees(root));
        log("countUnival2=" + countUnivalSubtrees2(root, Integer.MAX_VALUE));

        Node n5 = new Node(5, null, null);
        n3.left = n5;
        log("isUnival=" + isUnival(root));
        log("countUnival=" + countUnivalSubtrees(root));
        log("countUnival2=" + countUnivalSubtrees2(root, Integer.MAX_VALUE));
    }

    public static boolean isUnival(Node root) {
        if (root == null) { return true; }
        return isUnival(root.left, root.value) && isUnival(root.right, root.value);
    }

    private static boolean isUnival(Node node, int parentValue) {
        if (node == null) { return true; }
        if (node.value != parentValue) { return false; }
        return isUnival(node.left, parentValue) && isUnival(node.right, parentValue);
    }

    public static int countUnivalSubtrees(Node root) {
        AtomicInteger count = new AtomicInteger(1);
        countUnivalSubtrees(root, count);
        return count.get();
    }

    private static void countUnivalSubtrees(Node root, AtomicInteger count) {
        if (root == null) { return; }
        if ((root.left != null && root.value != root.left.value) ||
                (root.right != null && root.value != root.right.value)) {
            count.incrementAndGet();
        }
        countUnivalSubtrees(root.left, count);
        countUnivalSubtrees(root.right, count);
    }

    public static int countUnivalSubtrees2(Node root, int parentValue) {
        if (root == null) { return 0; }
        return ((root.value == parentValue) ? 0 : 1) +
                countUnivalSubtrees2(root.left, root.value) +
                countUnivalSubtrees2(root.right, root.value);
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

}
