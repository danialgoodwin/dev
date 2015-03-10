/**
 * Created by Danial on 3/10/2015.
 */
package com.danialgoodwin.interviewcake.question;

import javafx.util.Pair;

import java.util.Stack;

/**
 * Write a function to see if a binary tree ↴ is "superbalanced" (a new tree property we just made up).
 * Website: https://www.interviewcake.com/question/balanced-binary-tree
 */
public class BalancedBinaryTreeQuestion extends Question {

    @Override
    protected String getQuestionName() {
        return "BalancedBinaryTree";
    }

    @Override
    public void solve() {
        BinaryTree tree = newBinaryTree1();
        boolean isBalanced = isBalanced(tree);
        log("isBalanced=" + isBalanced + ",expect=true");

        tree = newBinaryTree2();
        isBalanced = isBalanced(tree);
        log("isBalanced=" + isBalanced + ",expect=true");

        tree = newBinaryTree3();
        isBalanced = isBalanced(tree);
        log("isBalanced=" + isBalanced + ",expect=false");
    }

    /** Intuition: There are at most two distinct depths, and they are at most one apart.
     * Depth-first search.
     * Space: O(height), time: O(n)
     */
    private static boolean isBalanced(BinaryTree tree) {
        if (tree == null || tree.root == null) { return true; }

        Stack<Pair<BinaryTree.Node, Integer>> nodes = new Stack<>();
        nodes.add(new Pair<>(tree.root, 1));

        int depth = 0;
        int firstDepth = -1;
        int secondDepth = -1;
        while (!nodes.isEmpty()) {
            Pair<BinaryTree.Node, Integer> node = nodes.pop();
            depth = node.getValue();
            if (node.getKey().left == null && node.getKey().right == null) {
                if (firstDepth == -1) {
                    firstDepth = depth;
                } else if (depth != firstDepth) {
                    if (secondDepth == -1) {
                        secondDepth = depth;
                        if (Math.abs(secondDepth - firstDepth) > 1) {
                            return false;
                        }
                    } else if (depth != secondDepth) {
                        return false;
                    }
                }
            } else {
                if (node.getKey().left != null) {
                    nodes.push(new Pair<>(node.getKey().left, depth + 1));
                }
                if (node.getKey().right != null) {
                    nodes.push(new Pair<>(node.getKey().right, depth + 1));
                }
            }
        }

        return true;
    }

    private BinaryTree newBinaryTree() {
        BinaryTree tree = new BinaryTree();
        tree.addNode(new BinaryTree.Node()
                .left(new BinaryTree.Node()
                        .left(new BinaryTree.Node()
                                .left(new BinaryTree.Node()))
                        .right(new BinaryTree.Node()))
                .right(new BinaryTree.Node()
                        .left(new BinaryTree.Node()
                                .left(new BinaryTree.Node()))
                        .right(new BinaryTree.Node())));
        return tree;
    }

    private BinaryTree newBinaryTree1() {
        BinaryTree tree = new BinaryTree();
        tree.addNode(new BinaryTree.Node());
        return tree;
    }

    private BinaryTree newBinaryTree2() {
        BinaryTree tree = new BinaryTree();
        tree.addNode(new BinaryTree.Node()
                .left(new BinaryTree.Node().left(new BinaryTree.Node().left(new BinaryTree.Node()))));
        return tree;
    }

    private BinaryTree newBinaryTree3() {
        BinaryTree tree = new BinaryTree();
        tree.addNode(new BinaryTree.Node()
                .left(new BinaryTree.Node()
                        .left(new BinaryTree.Node()
                                .left(new BinaryTree.Node()))
                        .right(new BinaryTree.Node()))
                .right(new BinaryTree.Node()));
        return tree;
    }



    /** Very simple binary tree. */
    private static class BinaryTree<K, V> {
        Node root;

        boolean addNode(Node node) {
            if (root == null) {
                root = node;
            } else {
                // TODO: Find a node with an empty leaf.
                root.left = node;
            }
            return true;
        }

        static class Node<K, V> {
            K key;
            V value;
            Node left;
            Node right;

            Node left(Node node) { left = node; return this; }
            Node right(Node node) { right = node; return this; }
        }
    }

}
