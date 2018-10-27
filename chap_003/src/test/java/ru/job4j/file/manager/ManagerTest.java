package ru.job4j.file.manager;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * @author Aleksandr Smirnov.
 */
public class ManagerTest {
    /**
     * Тест метода получения результата.
     *
     * @throws Exception
     */
    @Test
    public void start() throws Exception {
        String operationName = "cd src";
        Manager manager = new Manager();
        File homeDir = new File(System.getProperty("user.dir"));
        File currentDir = new File(homeDir.getPath());
        manager.start(homeDir, currentDir, operationName);
        String actual = manager.getCurrentDir();
        String expectedPath = homeDir.getPath() + "\\src";
        String expectedResult = homeDir.getPath() + "\\src>";
        Assert.assertEquals(expectedPath, actual);
        operationName = "cd ..";
        manager.start(homeDir, currentDir, operationName);
        actual = manager.getCurrentDir();
        expectedPath = homeDir.getPath();
        Assert.assertEquals(expectedPath, actual);
    }

    /**
     * Тест метода получения массива строк из строки.
     *
     * @throws Exception
     */
    @Test
    public void getSplitOperationName() throws Exception {
        final String test = "cd ..";
        Manager manager = new Manager();
        String[] expected = {"cd", ".."};
        String[] actual = manager.getSplitOperationName(test);
        Assert.assertArrayEquals(expected, actual);
    }
}