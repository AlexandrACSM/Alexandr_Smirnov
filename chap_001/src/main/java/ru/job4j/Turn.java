package ru.job4j;

	/**
	 * @author smirnov
	 * @since 21.01.2017
	 */
public class Turn {
	/**
     * The method of turning over array.
	 * Метод переворачивающий массив.
	 * @param array - the incoming array (входящий массив).
	 * @return the return processed array (возвращаем обработанный массив).
	 */
    public int[] getBackArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp;
            temp = array[i];
            array[i] = array[(array.length - 1) - i];
            array[(array.length - 1) - i] = temp;
        }
        return array;
    }
}