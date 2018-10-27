package ru.job4j;

import org.junit.Test;
import ru.job4j.factorial.Factorial;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Тестирование класса нахождения факториала числа.
*/
public class FactorialTest {
    /**
    * Тест нахождения факториала числа.
    */
    @Test
    public void factorialTest() {
        final long four = 4;
        final long twentyFour = 24;
        Factorial factorial = new Factorial();
        long result = factorial.getFactorial(four);
        assertThat(twentyFour, is(result));
    }
}