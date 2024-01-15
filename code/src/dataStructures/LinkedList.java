package dataStructures;

public class LinkedList {

    private Node first;
    private Node last;

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public void addFirst(int item) {
        Node node = new Node(item);
        if (first == null)
            first = last = node;
        else {
            node.next = first;
            first = node;
        }

    }

    public void addLast(int item) {
        Node node = new Node(item);
        if (last == null)
            first = last = node;
        else {

            last.next = node;
            last = node;
        }

    }

    public int deleteFirst() {
        var oldFirst = first;
        first = first.next;
        oldFirst.next = null;

        return oldFirst.value;
    }

    public int deleteLast() {
        var oldLast = last;
        last = getPreviousNode(last);
        last.next = null;

        return oldLast.value;
    }

    private Node getPreviousNode(Node node) {
        var current = first;

        while (current.next != node) {
            current = current.next;
        }

        return current;

    }

    public boolean contains(int item) {
        var current = first;
        while (current != null) {
            if (current.value == item)
                return true;

            current = current.next;
        }

        return false;
    }

    public int indexOf(int item) {
        int index = 0;
        var current = first;

        while (current != null) {
            if (current.value == item)
                return index;

            index++;
            current = current.next;
        }
        return -1;
    }

    public void print() {
        var current = first;
        while (current != null) {
            System.out.print(current.value + ((current.next != null) ? " -> " : " "));
            current = current.next;
        }
    }
}
