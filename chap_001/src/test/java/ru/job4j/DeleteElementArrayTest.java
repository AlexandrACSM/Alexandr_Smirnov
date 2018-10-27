package ru.job4j;

import org.junit.Assert;
import org.junit.Test;


/**
 * Тест класса удаляющего дублирующиеся элементы массива.
 * @author smirnov
 * @since 22.01.2017
 */
public class DeleteElementArrayTest {

    /**
     * Тест метода присвающего дублирующим элементы массива null.
     * Тест проверяет массив с нечетным количеством элеметнов.
     */
    @Test
    public void allocNullToDuplicatingElementsDontEvenArrayTest() {
        final String four = "4";
        final String three = "3";
        final String nullValues = null;
        DeleteElementArray deleteElementArray = new DeleteElementArray();
        String[] arrayTest = {four, four, three};
        String[] arrayResultTest = {nullValues, four, three};
        String[] result = deleteElementArray.allocNullToDuplicatingElements(arrayTest);
        Assert.assertArrayEquals(arrayResultTest, result);
    }

    /**
     * Тест метода переносящего null элементы в конец массива.
     * Тест проверяет массив с нечетным количеством элеметнов.
     */
    @Test
    public void sortNullTheElementsDontEvenArrayTest() {
        final String four = "4";
        final String three = "3";
        final String nullValues = null;
        DeleteElementArray deleteElementArray = new DeleteElementArray();
        String[] arrayTest = {nullValues, four, three};
        String[] arrayResultTest = {three, four, nullValues};
        String[] result = deleteElementArray.sortNullTheElementsArray(arrayTest);
        Assert.assertArrayEquals(arrayResultTest, result);
    }

    /**
     * Тест метода удаляющего null элементы массива.
     * Тест проверяет массив с нечетным количеством элеметнов.
     */
    @Test
    public void deletionNullInArrayDontEvenArray() {
        final String four = "4";
        final String three = "3";
        final String nullValues = null;
        DeleteElementArray deleteElementArray = new DeleteElementArray();
        String[] arrayTest = {three, four, nullValues};
        String[] arrayResultTest = {three, four};
        String[] result = deleteElementArray.deletionNullInArray(arrayTest);
        Assert.assertArrayEquals(arrayResultTest, result);
    }

    /**
     * Тест метода присвающего дублирующим элементы массива null.
     * Тест проверяет массив с четным количеством элеметнов.
     */
    @Test
    public void allocNullToDuplicatingElementsEvenArrayTest() {
        final String three = "3";
        final String four = "4";
        final String five = "5";
        final String nullValues = null;
        DeleteElementArray deleteElementArray = new DeleteElementArray();
        String[] arrayTest = {four, four, three, five};
        String[] arrayResultTest = {nullValues, four, three, five};
        String[] result = deleteElementArray.allocNullToDuplicatingElements(arrayTest);
        Assert.assertArrayEquals(arrayResultTest, result);
    }

    /**
     * Тест метода переносящего null элементы в конец массива.
     * Тест проверяет массив с не четным количеством элеметнов.
     */
    @Test
    public void sortNullTheElementsDontArrayTest() {
        final String three = "3";
        final String four = "4";
        final String five = "5";
        final String nullValues = null;
        DeleteElementArray deleteElementArray = new DeleteElementArray();
        String[] arrayTest = {nullValues, four, three, five};
        String[] arrayResultTest = {five, four, three, nullValues};
        String[] result = deleteElementArray.sortNullTheElementsArray(arrayTest);
        Assert.assertArrayEquals(arrayResultTest, result);
    }

    /**
     * Тест метода удаляющего null элементы массива.
     * Тест проверяет массив с не четным количеством элеметнов.
     */
    @Test
    public void deletionNullInArrayEvenArray() {
        final String three = "3";
        final String four = "4";
        final String five = "5";
        final String nullValues = null;
        DeleteElementArray deleteElementArray = new DeleteElementArray();
        String[] arrayTest = {five, three, four, nullValues};
        String[] arrayResultTest = {five, three, four};
        String[] result = deleteElementArray.deletionNullInArray(arrayTest);
        Assert.assertArrayEquals(arrayResultTest, result);
    }
}