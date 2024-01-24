package dataStructures;

public class Tree {
  public static void main(String[] args) {
    Tree tree = new Tree();
    tree.insert(7);
    tree.insert(6);
    tree.insert(8);
    tree.insert(4);
    System.out.println(tree.find(4));
    System.out.println(tree.find(10));
  }

  private class Node {
    public int value;
    public Node leftChild;
    public Node rightChild;

    Node(int value) {
      this.value = value;
    }
  }

  private Node root;

  public void insert(int value) {
    Node node = new Node(value);
    Node current = root;

    if (current == null) {
      root = node;
      return;
    }

    Node parentNode = getNode(value, root);
    if (parentNode.value > value)
      parentNode.leftChild = node;
    else
      parentNode.rightChild = node;
  }

  public boolean find(int value) {
    Node current = root;

    while (true) {
      if (current.value == value)
        return true;

      if (current.value < value) {
        if (current.rightChild == null)
          break;
        current = current.rightChild;
      } else {
        if (current.leftChild == null)
          break;
        current = current.leftChild;
      }
    }

    return false;
  }

  private Node getNode(int value, Node current) {
    while (true) {
      if (current.value < value) {
        if (current.rightChild == null)
          break;
        current = current.rightChild;
      } else {
        if (current.leftChild == null)
          break;
        current = current.leftChild;
      }
    }
    return current;
  }

}
