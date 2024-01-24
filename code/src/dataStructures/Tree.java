package dataStructures;

public class Tree {
  public static void main(String[] args) {
    Tree tree = new Tree();
    tree.insert(7);
    tree.insert(6);
    tree.insert(4);
    tree.insert(8);
    tree.insert(1);
    tree.insert(9);
    tree.insert(10);

    /*
     * TREE VISUALIZATION
     * ___________7
     *
     * _____4___________9
     *
     * __1_____6_____8_____10
     *
     *
     */
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

    @Override
    public String toString() {
      return "Node=" + value;
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

    while (true) {
      if (current.value < value) {
        if (current.rightChild == null) {
          current.rightChild = node;
          break;
        }
        current = current.rightChild;
      } else {
        if (current.leftChild == null) {
          current.leftChild = node;
          break;
        }
        current = current.leftChild;
      }
    }
  }

  public boolean find(int value) {
    Node current = root;

    while (current != null) {
      if (current.value < value)
        current = current.rightChild;
      else if (current.value > value)
        current = current.leftChild;
      else
        return true;
    }
    return false;
  }
}
