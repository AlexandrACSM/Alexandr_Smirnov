package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class testing CheckSortArrayOrNoSort.
 *
 * @author Aleksandr Smirnov.
 * @version 1.0.
 * @since 05.02.2017.
 */
public class CheckSortArrayOrNotSortTest {
    /**
     * test testSortArrayTest.
     */
    @Test
    public void testSortArrayTest() {
        final int one = 1;
        final int two = 2;
        final int three = 3;
        final int four = 4;
        final int seven = 7;
        CheckSortArrayOrNotSort check = new CheckSortArrayOrNotSort();
        int[] ar = new int[]{one, two, three, four, seven};
        boolean result = check.testSortArray(ar);
        boolean test = true;
        assertThat(test, is(result));
    }
}
