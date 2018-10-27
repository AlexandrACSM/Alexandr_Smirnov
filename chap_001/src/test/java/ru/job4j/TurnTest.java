package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

	/**
	* Тест переворота массива.
	*/
 public class TurnTest {
	/**
	* Тест метода переворота массива.
	*/
    @Test
    public void getBackArrayTest() {
        final int one = 1;
        final int two = 2;
        final int three = 3;
        Turn turn = new Turn();
        int[] mass = {three, two, one};
        int[] array = {one, two, three};
        int[] result = turn.getBackArray(array);
        assertThat(mass, is(result));
    }
}