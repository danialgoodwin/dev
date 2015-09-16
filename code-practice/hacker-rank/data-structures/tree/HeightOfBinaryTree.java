// Source: https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree
public class HeightOfBinaryTree {

    // Return height using recursion.
    public static int height(Node root) {
        if (root == null) { return 0; }
        return Math.max( 1 + height(root.left), 1 + height(root.right) );
    }

    public static class Node {
        int data;
        Node left;
        Node right;
    }

}
