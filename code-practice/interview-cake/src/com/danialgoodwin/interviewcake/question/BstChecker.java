/**
 * Created by dan on 10/28/15.
 */
package com.danialgoodwin.interviewcake.question;

/**
 * Write a function to check that a binary tree is a valid binary search tree.
 *
 * More info: https://www.interviewcake.com/question/bst-checker
 */
public class BstChecker extends Question {

    public static void main(String[] args) {
        new BstChecker().solve();
    }

    @Override
    protected String getQuestionName() {
        return "BstChecker";
    }

    @Override
    public void solve() {

        Node<Integer, String> n3 = new Node<>(40, "");
        Node<Integer, String> n4 = new Node<>(60, "");

        Node<Integer, String> n2 = new Node<>(50, "", n3, n4);
        Node<Integer, String> n1 = new Node<>(1, "");

        Node<Integer, String> root = new Node<>(45, "root", n1, n2);

        boolean isBst = isBst(root);
        log("isBst=" + isBst);

        isBst = isBst(n2);
        log("isBst=" + isBst);
    }

    public static boolean isBst(Node<Integer, String> root) {
        return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBst(Node<Integer, String> root, Integer min, Integer max) {
        if (root == null) { return true; }
        if (min > root.key || root.key >= max) { return false; }
        return isBst(root.left, min, root.key) && isBst(root.right, root.key, max);
    }

    private class Node<K, V> {
        K key;
        V value;
        Node<K, V> left;
        Node<K, V> right;
        public Node(K key, V value) {
            this(key, value, null, null);
        }
        public Node(K key, V value, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

}
