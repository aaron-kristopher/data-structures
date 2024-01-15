package dataStructures;

public class LinkedList {

    // TODO addFirst
    // TODO addLast
    // TODO deleteFirst
    // TODO deleteLast
    // TODO contains
    // TODO indexOf

    private Node first;
    private Node last;
    private int count = 0;

    private class Node {
        int value;
        Node next;

        Node(int item) {
            value = item;
        }
    }

    public void addFirst(int item) {
        Node node = new Node(item);
        if (first == null)
            first = node;
        else {
            var oldFirst = first;
            node.next = oldFirst;
            first = node;
        }

        count++;
    }

    public void print() {
        var node = first;
        for (int i = 0; i < count; i++) {
            System.out.println(node.value);
            node = node.next;
        }
    }
}
