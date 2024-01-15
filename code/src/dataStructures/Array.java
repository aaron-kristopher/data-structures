package dataStructures;

import java.util.Arrays;

public class Array {
    // TODO insert
    // TODO removeAt
    // TODO indexOf (return -1 if not in array)
    // TODO print

    private int[] array;
    private int count = 0;

    Array(int length) {
        array = new int[length];
    }

    public void insert(int item) {
        if (array.length == count)
            resize();

        array[count++] = item;
    }

    public void resize() {
        // Double original array length
        int[] newArray = new int[array.length * 2];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }

        count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item)
                return i;
        }

        return -1;
    }

    public void print() {
        System.out.println(Arrays.toString(Arrays.copyOfRange(array, 0, count)));
    }
}