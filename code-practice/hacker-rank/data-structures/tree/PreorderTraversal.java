// Source: https://www.hackerrank.com/challenges/tree-preorder-traversal
public class PreorderTraversal {

  public static void preorder(Node root) {
    if (root == null) { return; }
    visit(root);
    preorder(root.left);
    preorder(root.right);
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
