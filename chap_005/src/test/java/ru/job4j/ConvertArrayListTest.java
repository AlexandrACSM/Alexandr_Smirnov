package ru.job4j;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.convert.ConvertArrayList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Aleksandr Smirnov.
 */
public class ConvertArrayListTest {
    /**
     * Тест перевода из массива в коллекцию.
     */
    @Test
    public void toList() {
        int[][] array = {{4, 2}, {3, 2}, {3, 2}};
        ConvertArrayList convertArrayList = new ConvertArrayList();
        List<Integer> list = convertArrayList.toList(array);
        List<Integer> listExpected = new ArrayList<>();
        listExpected.add(4);
        listExpected.add(2);
        listExpected.add(3);
        listExpected.add(2);
        listExpected.add(3);
        listExpected.add(2);
        assertThat(listExpected, is(list));
        assertThat(listExpected.size(), is(list.size()));
    }

    /**
     * Тест перевода из коллекции в массива.
     */
    @Test
    public void toArray() {
        final int[][] expectedArray = {{4, 2, 3}, {2, 3, 2}, {0, 0, 0}};
        ConvertArrayList convertArrayList = new ConvertArrayList();
        List<Integer> list = new ArrayList<>();
        final int rows = 3;
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(3);
        list.add(2);
        int[][] actualArray = convertArrayList.toArray(list, rows);
        Assert.assertArrayEquals(expectedArray, actualArray);
    }

    /**
     * Тест получения колличества строк и столбцов.
     */
    @Test
    public void getRows() {
        final int expectedRows = 3;
        ConvertArrayList convertArrayList = new ConvertArrayList();
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(3);
        list.add(2);
        int actualRows = convertArrayList.getRows(list);
        Assert.assertTrue(expectedRows == actualRows);
    }

    /**
     * Тест переноса данных из коллекции List<int[]> в List<Integer>.
     */
    @Test
    public void convert() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5});
        List<Integer> expectedList = new LinkedList<>();
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(3);
        expectedList.add(4);
        expectedList.add(5);
        ConvertArrayList convertArrayList = new ConvertArrayList();
        List<Integer> actualList = convertArrayList.convert(list);
        assertThat(expectedList, is(actualList));
    }
}