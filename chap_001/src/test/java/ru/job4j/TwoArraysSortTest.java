package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class test TwoArraySort.
 *
 * @author Aleksandr Smirnov.
 * @version 1.0
 * @since 05.02.2017.
 */
public class TwoArraysSortTest {
    /**
     * test sortTwoArrays.
     */
    @Test
    public void sortTwoArraysTest() {
        final int one = 1;
        final int two = 2;
        final int three = 3;
        final int four = 4;
        final int seven = 7;
        TwoArraySort twoArraySort = new TwoArraySort();
        int[] array = new int[]{one, three, four};
        int[] arrayTwo = new int[]{one, two, seven};
        int[] result = twoArraySort.sortTwoArrays(array, arrayTwo);
        int[] arrayTest = new int[]{one, one, two, three, four, seven};
        assertThat(arrayTest, is(result));
    }
}
