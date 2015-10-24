/**
 * Created by dan on 10/24/15.
 */
package com.anonsage.question;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Write a function which does zig-zag traverse of binary tree and prints out nodes.
 *
 * Ex:
 *    1
 *  2   3
 * 4 5 6 7
 *
 * Output: 1, 2, 3, 7, 6, 5, 4
 *
 * More info: http://www.careercup.com/question?id=6236748675809280
 */
public class ZigZagTraverse {

    private static void log(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        Node root = new Node("1");

        Node node2 = new Node("2");
        Node node3 = new Node("3");
        root.left = node2;
        root.right = node3;

        Node node4 = new Node("4");
        Node node5 = new Node("5");
        Node node6 = new Node("6");
        Node node7 = new Node("7");
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        String s = traverse(root);
        log("s=" + s);
    }

    // Idea: Using Queue and Stack as doing BFS.
    public static String traverse(Node root) {
        if (root == null) { throw new NullPointerException("root must not be null"); }

        StringBuilder sb = new StringBuilder();

        Deque<Node> levelNodes = new LinkedList<>();
        Deque<Node> nextNodes = new LinkedList<>();
        Deque<Node> tempSwap;
        levelNodes.add(root);
        boolean isZag = true;
        while (!levelNodes.isEmpty()) {
            if (isZag) {
                while (!levelNodes.isEmpty()) {
                    Node n = levelNodes.removeLast();
                    sb.append(n.value);
                    if (n.right != null) { nextNodes.addFirst(n.right); }
                    if (n.left != null) { nextNodes.addFirst(n.left); }
                }
            } else {
                while (!levelNodes.isEmpty()) {
                    Node n = levelNodes.removeFirst ();
                    sb.append(n.value);
                    if (n.left != null) { nextNodes.add(n.left); }
                    if (n.right != null) { nextNodes.add(n.right); }
                }
            }

            isZag = !isZag;
            tempSwap = levelNodes;
            levelNodes = nextNodes;
            nextNodes = tempSwap;
        }

        return sb.toString();
    }

    private static class Node {
        public Node left;
        public Node right;
        public String value;
        public Node(String value) {
            this.value = value;
        }
    }

}
