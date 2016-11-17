public class BinaryTree {
  private int height;
  private int index;
  private Node headChild;
  private class Node {
    private Node leftChild;
    private Node rightChild;
    private int data;
    private int level;
    private int totalHeight;

    public Node(int height, int level) {
      this.height = height;
      this.level = level;
      this.leftChild = null;
      this.rightChild = null;
    }
  }

  public BinaryTree(int height) {
    this.height = height;
    this.headChild = new Node(1);
  }
}
