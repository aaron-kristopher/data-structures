package algorithms.sorting;

public class QuickSort {

   public void sort(int[] array) {
       sort(array, 0, array.length - 1);
   }
   private void sort(int[] array, int start, int end) {
       if (start >= end)
           return;

       int boundary = partition(array, start, end);

       sort(array, start, boundary - 1);
       sort(array, boundary + 1, end);
    }

    private int partition(int[] array, int start, int end) {
       int pivot = array[end];
       int boundary = start - 1;
       for (int i = start; i <= end; i++)
           if (array[i] <= pivot)
               swap(array, i, ++boundary);

       return boundary;
    }

    private void swap(int[] array, int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }
}
