package dataStructures;

import java.util.NoSuchElementException;

public class LinkedList {

    private Node first;
    private Node last;
    private int size = 0;

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public void addFirst(int item) {
        Node node = new Node(item);
        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }

        size++;
    }

    public void addLast(int item) {
        Node node = new Node(item);
        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }

        size++;
    }

    private boolean isEmpty() {
        return (first == null);
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        size--;

        if (first == last) {
            first = last = null;
            return;
        }

        var oldFirst = first;
        first = first.next;
        oldFirst.next = null;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        size--;

        if (first == last) {
            first = last = null;
            return;
        }

        var previous = getPreviousNode(last);
        last = previous;
        last.next = null;
    }

    private Node getPreviousNode(Node node) {
        var current = first;

        while (current.next != null) {
            if (current.next == node)
                return current;
            current = current.next;
        }

        return null;

    }

    public boolean contains(int item) {
        return (indexOf(item) != -1);
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

    public int size() {
        return size;
    }
}
