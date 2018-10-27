package ru.job4j;

/**
 *The class checks whether the array or not (проверяющий отсортирован массив или нет).
 * @author Aleksandr Smirnov.
 * @version 1.0.
 * @since 05.02.2017.
 */
public class CheckSortArrayOrNotSort {
    /**
     * Method testing array.
     *
     * @param array - entering array.
     * @return sort - iterated value.
     */
    public boolean testSortArray(int[] array) {
        boolean sort = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                sort = false;
                break;
            }
        }
        return sort;
    }
}