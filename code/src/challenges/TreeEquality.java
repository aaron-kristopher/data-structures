package challenges;

public class TreeEquality {
    public static void main(String[] args) {
        TreeEquality treeOne = new TreeEquality();
        treeOne.insert(7);
        treeOne.insert(4);
        treeOne.insert(9);
        treeOne.insert(8);
        treeOne.insert(1);
        treeOne.insert(6);
        treeOne.insert(10);

        TreeEquality treeTwo = new TreeEquality();
        treeTwo.insert(7);
        treeTwo.insert(9);
        treeTwo.insert(8);
        treeTwo.insert(1);
        treeTwo.insert(6);
        treeTwo.insert(4);
        treeTwo.insert(10);

        System.out.println(isEqual(treeOne, treeTwo));
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

    public void traversePreOrder() {
        traversePreOrder(this.root);
    }

    private void traversePreOrder(Node node) {
        if (node == null)
            return;

        System.out.println(node);
        traversePreOrder(node.leftChild);
        traversePreOrder(node.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(this.root);
    }

    private void traverseInOrder(Node node) {
        if (node == null)
            return;

        traverseInOrder(node.leftChild);
        System.out.println(node);
        traverseInOrder(node.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(this.root);
    }

    private void traversePostOrder(Node node) {
        if (node == null)
            return;

        traversePostOrder(node.leftChild);
        traversePostOrder(node.rightChild);
        System.out.println(node);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;

        if (isLeaf(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int binaryTreeMin() {
        if (root == null)
            throw new IllegalStateException();

        Node current = root;

        while (current.leftChild != null)
            current = current.leftChild;

        return current.value;
    }

    public int min() {
        return min(root);
    }

    private int min(Node root) {
        if (root == null)
            return -1;

        if (isLeaf(root))
            return root.value;

        int left = min(root.leftChild);
        int right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    private boolean isLeaf(Node node) {
        return (root.leftChild == null && root.rightChild == null);
    }

    public static boolean isEqual(TreeEquality treeOne, TreeEquality treeTwo) {
        return isEqual(treeOne.root, treeTwo.root);
    }

    public static boolean isEqual(Node rootOne, Node rootTwo) {
        if (rootOne == null && rootTwo == null)
            return true;
        else if ((rootOne == null && rootTwo != null) || (rootOne != null && rootTwo == null))
            return false;
        else
            return (rootOne.value == rootTwo.value) && isEqual(rootOne.leftChild, rootTwo.leftChild)
                    && isEqual(rootOne.rightChild, rootTwo.rightChild);
    }

}
