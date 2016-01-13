import java.util.*;

// Created by dan 2015-09-14
public class LowestCommonAncestor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solve();
    }

    public static void solve() {
        System.out.println();
    }

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

    private static void visit(Node element) {
        System.out.print(element.data + " ");
    }

    public static class Node {
        int data;
        Node left;
        Node right;
    }

}
