// Source: https://www.hackerrank.com/challenges/binary-search-tree-insertion
public class BstInsertion {

    public static Node insert(Node root, int value) {
        Node insert = new Node();
        insert.data = value;
        if (root == null) { return insert; }

        Node index = root;
        while (true) {
            if (value < index.data) {
                if (index.left == null) {
                    index.left = insert;
                    break;
                }
                index = index.left;
            } else {
                if (index.right == null) {
                    index.right = insert;
                    break;
                }
                index = index.right;
            }
        }
        return root;
    }

    public static class Node {
        int data;
        Node left;
        Node right;
    }

}
