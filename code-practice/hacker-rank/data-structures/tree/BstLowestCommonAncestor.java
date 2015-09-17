// Source: https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor
public class BstLowestCommonAncestor {

    // Lowest common ancestor
    public static Node lca(Node root, int v1, int v2) {
        Node element = root;
        while (true) {
            if (element.data > v1 && element.data > v2) {
                element = element.left;
            } else if (element.data < v1 && element.data < v2) {
                element = element.right;
            } else {
                return element;
            }
        }
    }

    public static class Node {
        int data;
        Node left;
        Node right;
    }

}
