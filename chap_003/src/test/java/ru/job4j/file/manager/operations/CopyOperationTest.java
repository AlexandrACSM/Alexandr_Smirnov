package ru.job4j.file.manager.operations;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * @author Aleksandr Smirnov.
 */
public class CopyOperationTest {
    /**
     * Тест копирования файла.
     *
     * @throws Exception
     */
    @Test
    public void execute() throws Exception {
        Operation operation = new CopyOperation();
        File homeDir = new File(System.getProperty("user.dir"));
        File currentDir = new File(homeDir.getPath());
        String[] operations = {"copy", "pom.xml", (homeDir.getPath() + "\\src")};
        operation.execute(operations, homeDir, currentDir);
        File expected = new File(homeDir.getPath() + "\\src\\pom.xml");
        Assert.assertTrue(expected.isFile());
        expected.delete();
    }

    @Test
    public void copyNotExistingFile() throws Exception {
        Operation operation = new CopyOperation();
        File homeDir = new File(System.getProperty("user.dir"));
        File currentDir = new File(homeDir.getPath());
        String[] operations = {"copy", "existingFile", (homeDir.getPath() + "\\src")};
        operation.execute(operations, homeDir, currentDir);
        String actual = operation.getMessage();
        String expected = "Не удается найти указанный файл.\n" + currentDir + ">";
        Assert.assertEquals(expected, actual);
    }

    /**
     * Тест получения сообщения результата.
     * @throws Exception
     */
    @Test
    public void getMessage() throws Exception {
        Operation operation = new CopyOperation();
        File homeDir = new File(System.getProperty("user.dir"));
        File currentDir = new File(homeDir.getPath());
        String[] operations = {"copy", "pom.xml", (homeDir.getPath() + "\\src")};
        currentDir = operation.execute(operations, homeDir, currentDir);
        String actual = operation.getMessage();
        String expected = currentDir + ">";
        File file = new File(homeDir.getPath() + "\\src\\pom.xml");
        file.delete();
        Assert.assertEquals(expected, actual);

    }
}