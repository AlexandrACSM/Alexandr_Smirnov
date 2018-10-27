package ru.job4j;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author Aleksandr Smirnov.
 * @version 1
 * @since 11.02.2017.
 */
public class IsNumberTest {
    /**
     * Тест проверяет является ли число четным.
     * @throws IOException
     */
    @Test
    public void isNumberTest() throws IOException {
        IsNumber isNumber = new IsNumber();
        boolean result;
        result = isNumber.getIsNumber(new ByteArrayInputStream("2".getBytes()));
        Assert.assertTrue(result);
    }

    @Test
    public void isNumberOddNumberTest() throws IOException{
        IsNumber isNumber = new IsNumber();
        boolean result;
        result = isNumber.getIsNumber(new ByteArrayInputStream("1".getBytes()));
        Assert.assertFalse(result);
    }
}
