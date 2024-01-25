package algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

  public static int[] sort(int[] array) {

    boolean isSorted;
    for (int i = 1; i < array.length; i++) {

      isSorted = false;
      for (int j = 0; j < array.length - i; j++) {
        if (array[j] > array[j + 1]) {
          swap(array, j, j + 1);
          isSorted = false;
        }
      }
      if (isSorted)
        return array;
    }

    return array;
  }

  private static void swap(int[] array, int indexOne, int indexTwo) {
    int temp = array[indexOne];
    array[indexOne] = array[indexTwo];
    array[indexTwo] = temp;
  }
}
