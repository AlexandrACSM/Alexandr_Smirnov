package ru.job4j;

import org.junit.Test;
import ru.job4j.counter.Counter;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест суммы интервала.
 */
public class CounterTest {
    /**
     * Тест метода вычисляющего сумму интервала.
     */
    @Test
    public void countTest() {
        final int one = 1;
        final int two = 2;
        final int three = 3;
        Counter counter = new Counter();
        int result = (int) counter.add(one, three);
        assertThat(two, is(result));
    }
}