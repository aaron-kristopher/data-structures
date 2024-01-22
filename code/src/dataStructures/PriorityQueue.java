package dataStructures;

import java.util.Arrays;

public class PriorityQueue {
    private int[] array;
    private int count = 0;
    private int front = 0;

    public PriorityQueue(int capacity) {
        array = new int[capacity];
    }

    public void enqueue(int item) {
        if (isFull())
            throw new IllegalStateException();

        int i = shiftItemsToInsert(item);
        array[i] = item;
        count++;
    }

    private int shiftItemsToInsert(int item) {
        int i;

        for (i = count - 1; i >= 0; i--) {
            if (array[i] > item)
                array[i + 1] = array[i];
            else
                break;
        }

        return i + 1;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        count--;
        return array[front++];
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return array[front];
    }

    public boolean isFull() {
        return count == array.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
