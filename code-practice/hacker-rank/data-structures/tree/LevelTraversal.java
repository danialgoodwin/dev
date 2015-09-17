// Source: https://www.hackerrank.com/challenges/tree-level-order-traversal
public class LevelTraversal {

    public static void levelTraversal(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node element = queue.remove();
            visit(element);
            if (element.left != null) queue.add(element.left);
            if (element.right != null) queue.add(element.right);
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
