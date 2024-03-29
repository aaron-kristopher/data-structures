package challenges;

import java.util.NoSuchElementException;

public class ReverseLinkedList {

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

        if (first == last) {
            first = last = null;
            return;
        } else {
            var oldFirst = first;
            first = first.next;
            oldFirst.next = null;
        }

        size--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
        } else {
            var previous = getPreviousNode(last);
            last = previous;
            last.next = null;
        }

        size--;
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

    public int[] toArray() {
        int[] array = new int[size];
        var current = first;

        for (int i = 0; i < size; i++) {
            array[i] = current.value;
            current = current.next;
        }

        return array;
    }

    public void reverse() {
        if (isEmpty())
            return;

        var previous = first;
        var current = first.next;

        while (current != null) {
            var next = current.next;

            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        first = previous;
        last.next = null;
    }
}
