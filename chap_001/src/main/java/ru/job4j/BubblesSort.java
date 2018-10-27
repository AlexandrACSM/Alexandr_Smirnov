package ru.job4j;

/**
 *Class of the bubbles sort (Класс сортировки пузырьком).
 * @author smirnov
 * @since 21.01.2017
 */
public class BubblesSort {
    /**
     * The method of the sort array with help of algorithm bubbles sort.
     * Метод сортировки масива с помощью алгоритма пузырьковой сортировки.
     * @param array - The incoming array (входящий массив).
     * @return array -The outcoming array  (вывод отсортированного массива).
     */
    public int[] getBubbleSortArray(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int temp = array[j];
                if (temp > array[j + 1]) {
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}