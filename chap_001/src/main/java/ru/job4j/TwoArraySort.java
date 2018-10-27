package ru.job4j;

/**
 * The class concatenating two sorted arrays.
 * Class объединяющий два отсортированных массива.
 * @author Aleksandr Smirnov.
 * @version 1
 * @since 05.02.2017.
 */
public class TwoArraySort {
    /**
     * The method concatenating two sorted array.
     * Метод объединяющий два отсортированных массива.
     * @param array    - first array
     * @param arrayTwo - second array
     * @return arr - iterated array
     */
    public int[] sortTwoArrays(int[] array, int[] arrayTwo) {
        final int size = array.length + arrayTwo.length;
        int[] arr = new int[size];
        int j = 0, k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (j >= array.length) {
                arr[i] = arrayTwo[k];
                k++;
            } else if (k >= arrayTwo.length) {
                arr[i] = array[j];
                j++;
            } else if (array[j] < arrayTwo[k]) {
                arr[i] = array[j];
                j++;
            } else if (array[j] > arrayTwo[k]) {
                arr[i] = arrayTwo[k];
                k++;
            } else if (array[j] == arrayTwo[k]) {
                arr[i] = array[j];
                arr[i + 1] = arrayTwo[k];
                i++;
                j++;
                k++;
            }

        }
        return arr;
    }
}