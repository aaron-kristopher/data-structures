package algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = { 8, 3, 2, 5, 1, 6, 9, 10 };
        System.out.println(Arrays.toString(sort(array)));
    }

    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = findMinIndex(array, i, i);
            swap(array, i, minIndex);
        }
        return array;
    }

    private static int findMinIndex(int[] array, int i, int minIndex) {
        for (int j = i + 1; j < array.length; j++) {
            if (array[j] < array[minIndex])
                minIndex = j;
        }

        return minIndex;
    }

    private static void swap(int[] array, int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }
}
