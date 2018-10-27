package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class testing AddElementInArray.
 * @author Aleksandr Smirnov.
 * @version 1.0.
 * @since 05.02.2017.
 */
public class AddElementInArrayTest {
    /**
     * test addElementInArray.
     */
    @Test
    public void addElementInArrayTest() {
        final int one = 1;
        final int two = 2;
        final int three = 3;
        final int four = 4;
        final int seven = 7;
        final int six = 6;
        final int nine = 9;
        final int five = 5;
        AddElementInArray addElementArray = new AddElementInArray();
        int[] array = new int[]{one, two, three, four, five, six, seven, nine, one, two};
        int element = seven;
        int[] result = addElementArray.addElementInArray(array, element);
        int[] arrayTest = new int[]{one, two, three, four, five, six, seven, nine, one, two, seven};
        assertThat(arrayTest, is(result));
    }
}
