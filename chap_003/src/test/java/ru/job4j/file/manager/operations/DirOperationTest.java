package ru.job4j.file.manager.operations;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * @author Aleksandr Smirnov.
 */
public class DirOperationTest {
    /**
     * Тест основного выполняющего метода.
     * @throws Exception
     */
    @Test
    public void execute() throws Exception {
        Operation operation = new DirOperation();
        String[] strings = {"dir"};
        File homeDir = new File(System.getProperty("user.dir"));
        File currentDir = new File(homeDir.getPath());
        File actual = operation.execute(strings, homeDir, currentDir);
        assertEquals(currentDir, actual);
    }

    /**
     * Тест получеия сообщения результата.
     * @throws Exception
     */
    @Test
    public void getMessage() throws Exception {
        Operation operation = new DirOperation();
        String[] strings = {"dir"};
        File homeDir = new File(System.getProperty("user.dir"));
        File currentDir = new File(homeDir.getPath());
        currentDir = operation.execute(strings, homeDir, currentDir);
        String actual = operation.getMessage();
        String expected = "chap_003.iml\r\npom.xml\r\nsrc\r\ntarget\n\r" + currentDir + ">";
        assertEquals(expected, actual);
    }
}