package ru.job4j;

import java.util.Arrays;

/**
 * Class adding one element to the array.
 * @author Aleksandr Smirnov.
 * @version 1.0.
 * @since 05.02.2017.
 */
public class AddElementInArray {
    /**
     * Method adding one element to the array.
     * @param array      - entering array.
     * @param newElement - adding element.
     * @return arrayCopy - array with adding element.
     */
    public int[] addElementInArray(int[] array, int newElement) {
        final int size = array.length;
        final int newSize = 11;
        int[] arrayCopy = Arrays.copyOf(array, newSize);
        arrayCopy[size] = newElement;
        return arrayCopy;
    }
}