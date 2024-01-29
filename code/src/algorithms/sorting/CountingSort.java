package algorithms.sorting;

public class CountingSort {
    public void sort(int[] array) {
        sort(array, getMax(array));
    }

    private void sort(int[] array, int max) {
        int[] counts = new int[max + 1];
        for (int item : array) {
            counts[item]++;
        }

        int k = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                array[k++] = i;
            }
        }
    }

    private int getMax(int[] array) {
        int max = 0;
        for (int i : array) {
            max = (max < i) ? i : max;
        }
        return max;
    }
}
