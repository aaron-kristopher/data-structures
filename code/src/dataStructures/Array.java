package dataStructures;

import java.util.Arrays;

public class Array {
    //TODO insert
    //TODO removeAt
    //TODO indexOf (return -1 if not in array)
    //TODO print

    static private int[] array = new int[5];
    static private int end = 0;

    public void insert(int item) {
        if (array.length == end)
            resize();

        array[end++] = item;
    }

    public void resize() {
        // Double original array length
        int[] newArray = new int[array.length * 2];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
    }

    public void removeAt(int index) {
        if (index > array.length)
            throw new IndexOutOfBoundsException();

        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
            
        }
    }

    public void indexOf(int item) {

    }

    public void print() {

    }
}