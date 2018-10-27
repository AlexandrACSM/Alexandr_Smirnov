package ru.job4j;

import org.junit.Assert;
import org.junit.Test;
/**
 * Тест переворачивания квадратного массива на 90 градусов.
 */
public class TurnArrayTest {
	/**
    * Тест метода переворачивания квадратного массива на 90 градусов.
    */
    	@Test
    public void getTurnArray() {
		final int one = 1;
		final int two = 2;
		final int three = 3;
		final int four = 4;
        TurnArray turnArray = new TurnArray();
        int[][] array = {{one, two}, {three, four}};
        int[][] arrayResult = {{three, one}, {four, two}};
        int[][] arrayTest = turnArray.getTurnArray(array);
        Assert.assertArrayEquals(arrayTest, arrayResult);
    }
}