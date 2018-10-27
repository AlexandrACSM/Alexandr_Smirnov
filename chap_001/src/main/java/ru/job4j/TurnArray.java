package ru.job4j;

/**
 * The class for turn over the square array on 90 degree.
 * Класс для переворачивания квадратного массива на 90 градусов.
 */
public class TurnArray {
/**
 * The method turns over the square array on 90 degree.
 * Метод переворачивющий квадратный массив на 90 градусов.
 * @param array - the incoming array (входящий массив).
 * @return the returns array (reverseArray - возвращаем массив).
 */
    public int[][] getTurnArray(int[][] array) {
        int[][] reverseArray = new int[array.length][array.length];
        for (int i = 0; i < reverseArray.length; i++) {
            for (int j = 0; j < reverseArray.length; j++) {
                reverseArray[j][reverseArray.length - 1 - i] = array[i][j];
            }
        }
		return reverseArray;
    }
}