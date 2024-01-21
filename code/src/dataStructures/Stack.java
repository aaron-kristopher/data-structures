package dataStructures;

import java.util.Arrays;

public class Stack {

    private int[] array;
    private int count = 0;

    Stack(int initialSize) {
        array = new int[initialSize];
    }

    public void push(int item) {
        if (isFull())
            resize();

        array[count++] = item;
    }

    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();

        return array[--count];
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException(); 

        return array[count];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return (array.length == count);
    }

    private void resize() {
        int[] newArray = new int[array.length * 2];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(array, 0, count));
    }
}
