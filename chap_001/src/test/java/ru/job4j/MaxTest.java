package ru.job4j;

import org.junit.Test;
import ru.job4j.max.Max;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Тест определения наибольшего числа.
 */
public class MaxTest {
	/**
	* Тест медота определяющего наибольшее значение из вдух чисел.
	*/
    @Test
    public void getMaxTest() {
	    final int two = 2;
        final int three = 3;
        Max max = new Max();
        int result = max.max(two, three);
        assertThat(three, is(result));
    }
	/**
	* Тест медота определяющего наибольшее значение из трех чисел.
	*/
    @Test
    public void getMaxThreeValuesTest() {
		final int two = 2;
		final int three = 3;
		final int six = 6;
        Max max = new Max();
        int result = max.max(two, three, six);
        assertThat(six, is(result));
    }
}