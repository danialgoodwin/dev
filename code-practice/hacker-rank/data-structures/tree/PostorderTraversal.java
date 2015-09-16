// Source: https://www.hackerrank.com/challenges/tree-inorder-traversal
public class InorderTraversal {

  public static void inorder(Node root) {
    if (root == null) { return; }
    inorder(root.left);
    visit(root);
    inorder(root.right);
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
