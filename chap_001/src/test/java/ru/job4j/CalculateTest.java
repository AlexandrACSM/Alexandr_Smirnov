package ru.job4j;


import org.junit.Test;
import ru.job4j.calculate.Calculate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты калькулятора.
 */
public class CalculateTest {
    /**
     * Тест метода сложения.
     */
    @Test
    public void getSumTest() {
        final double three = 3.0;
        final double four = 4.0;
        final double seven = 7.0;
        Calculate calculate = new Calculate();
        calculate.getSum(three, four);
        assertThat(seven, is(calculate.getResult()));
    }

    /**
     * Тест метода вычитания.
     */
    @Test
    public void getSubTest() {
        final double three = 3.0;
        final double four = 4.0;
        final double minusOne = -1.0;
        Calculate calculate = new Calculate();
        calculate.getSub(three, four);
        assertThat(minusOne, is(calculate.getResult()));
    }

    /**
     * Тест метода деления.
     */
    @Test
    public void getDivTest() {
        final double four = 4.0;
        final double eight = 8.0;
        final double two = 2.0;
        Calculate calculate = new Calculate();
        calculate.getDiv(eight, four);
        assertThat(two, is(calculate.getResult()));
    }

    /**
     * Тест метода умножения.
     */
    @Test
    public void getMulTest() {
        final double three = 3.0;
        final double four = 4.0;
        final double twelve = 12.0;
        Calculate calculate = new Calculate();
        calculate.getMul(three, four);
        assertThat(twelve, is(calculate.getResult()));
    }
}