package ru.job4j;

import static org.junit.Assert.assertThat;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
/**
 * Тест класса определяющего является ли строка sub подстрокой original.
 *
 * @author smirnov.
 * @since 22.01.2017
 */
public class CheckLineTest {
    /**
     * Тест метода преобразующего String в char[].
     */
    @Test
    public void stringInArrayCharTest() {
        final String string = "abcdr";
        final char chA = 'a';
        final char chB = 'b';
        final char chC = 'c';
        final char chD = 'd';
        final char chR = 'r';
        CheckLine checkLine = new CheckLine();
        char[] charsArray = checkLine.stringInChar(string);
        char[] result = {chA, chB, chC, chD, chR};
        assertThat(charsArray, is(result));
    }

    /**
     * Тест метода проверяющего является ли строк sub подстрокой origin.
     */
    @Test
    public void checkSubstringTest() {
        final String origin = "A drop in the bucket.";
        final String sub = "the";
        CheckLine checkLine = new CheckLine();
        char[] originArray = checkLine.stringInChar(sub);
        char[] subArray = checkLine.stringInChar(sub);
        boolean result = checkLine.checkSubString(originArray, subArray);
        assertThat(true, is(result));
    }
}
