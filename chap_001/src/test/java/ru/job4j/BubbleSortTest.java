package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест пузырьковой сортировки.
 * @author smirnov
 * @since 22.01.2017
 */
public class BubbleSortTest {
	/**
	* Тест метода пузырьковой сортировки.
	*/
   @Test
    public void getBubblesSortTest() {
		final int one = 1;
		final int three = 3;
		final int five = 5;
		final int seven = 7;
		BubblesSort bubblesSort = new BubblesSort();
        int[] testArray = {one, three, five, seven, seven};
        int[] test = {one, five, seven, seven, three};
        int[] resultArray = bubblesSort.getBubbleSortArray(test);
        assertThat(testArray, is(resultArray));
    }
}