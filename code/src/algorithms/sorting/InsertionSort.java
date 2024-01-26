package algorithms.sorting;

public class InsertionSort {

    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int item = array[i];
            int indexToInsert = shiftItemsToInsert(array, item, i);
            array[indexToInsert] = item;
        }
        return array;
    }

    private static int shiftItemsToInsert(int[] array, int item, int startIndex) {
        int j = startIndex - 1;

        while (j >= 0 && array[j] > item) {
            array[j + 1] = array[j];
            j--;
        }
        return j + 1;
    }
}
