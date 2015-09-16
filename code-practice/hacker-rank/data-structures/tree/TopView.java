// Source: https://www.hackerrank.com/challenges/tree-top-view
public class TopView {

    public void topView(Node root) {
        if (root == null) return;
        Deque<Node> leftTop = new LinkedList<>();
        Deque<Node> rightTop = new LinkedList<>();

        // Gather left side.
        Node index = root.left;
        while (index != null) {
            leftTop.addFirst(index);
            index = index.left;
        }

        // Gather right side.
        index = root.right;
        while (index != null) {
            rightTop.addLast(index);
            index = index.right;
        }

        // Print left, root, right
        while (!leftTop.isEmpty()) {
            System.out.print(leftTop.removeFirst().data + " ");
        }
        System.out.print(root.data + " ");
        while (!rightTop.isEmpty()) {
            System.out.print(rightTop.removeFirst().data + " ");
        }
    }

    public static class Node {
        int data;
        Node left;
        Node right;
    }

}
