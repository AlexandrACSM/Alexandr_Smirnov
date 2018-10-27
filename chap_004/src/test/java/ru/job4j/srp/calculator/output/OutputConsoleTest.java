package ru.job4j.srp.calculator.output;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Aleksandr Smirnov.
 */
public class OutputConsoleTest {
    @Test
    public void writeResult() throws Exception {
        Output output = new OutputConsole();
        final String expected = "Result = 3.0";
        output.writeResult(3);
        String actual = output.getMessage();
        Assert.assertTrue(expected.equals(actual));
    }
}