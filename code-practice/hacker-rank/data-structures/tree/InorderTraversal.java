// Source: https://www.hackerrank.com/challenges/tree-postorder-traversal
public class PostorderTraversal {

  public static void postorder(Node root) {
    if (root == null) { return; }
    postorder(root.left);
    postorder(root.right);
    visit(root);
  }

  private static void visit(Node node) {
    System.out.print(node.data + " ");
  }

  public static class Node {
    int data;
    Node left;
    Node right;
  }

}
