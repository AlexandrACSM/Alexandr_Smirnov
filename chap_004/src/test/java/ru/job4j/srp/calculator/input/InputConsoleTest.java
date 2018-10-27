package ru.job4j.srp.calculator.input;

import com.sun.webkit.SimpleSharedBufferInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import static org.junit.Assert.*;

/**
 * @author Aleksandr Smirnov.
 */
public class InputConsoleTest {
    @Test
    public void writeArgument() throws Exception {
        System.setIn(new ByteArrayInputStream("1.23".getBytes()));
        Input input = new InputConsole();
        final double expected = 1.23;
        double actual =  input.writeArgument();
        System.out.print(actual);
        Assert.assertEquals(expected, actual, 0.00);
    }


    @Test
    public void writeOperation() throws Exception {
        System.setIn(new ByteArrayInputStream("+".getBytes()));
        Input input = new InputConsole();
        final String expected = "+";
        String actual =  input.writeOperation().getKey();
        System.out.print(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void writeCloseOrContinue() throws Exception {
        System.setIn(new ByteArrayInputStream("y".getBytes()));
        Input input = new InputConsole();
        boolean actual =  input.writeCloseOrContinue();
        Assert.assertTrue(actual);
    }
}