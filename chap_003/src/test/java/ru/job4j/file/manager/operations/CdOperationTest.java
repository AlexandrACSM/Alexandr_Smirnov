package ru.job4j.file.manager.operations;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * @author Aleksandr Smirnov.
 */
public class CdOperationTest {
    /**
     * Тест основного выполняющего метода.
     * @throws Exception
     */
    @Test
    public void execute() throws Exception {
        Operation operation = new CdOperation();
        String[] operations = {"cd", "src"};
        File homeDir = new File(System.getProperty("user.dir"));
        File currentDir = new File(homeDir.getPath());
        File actual = operation.execute(operations, homeDir, currentDir);
        File expected = new File(homeDir.getPath() + "\\src");
        Assert.assertEquals(expected, actual);
    }

    /**
     * Тест попытки подняться выше родителького каталога.
     *
     * @throws Exception
     */
    @Test
    public void testToRiseAboveTheCatalog() throws Exception {
        Operation operation = new CdOperation();
        String[] operations = {"cd", ".."};
        File homeDir = new File(System.getProperty("user.dir"));
        File currentDir = new File(homeDir.getPath());
        File actual = operation.execute(operations, homeDir, currentDir);
        File expected = new File(homeDir.getPath());
        Assert.assertEquals(expected, actual);
    }

    /**
     * Тест перехода на несуществующий каталог.
     *
     * @throws Exception
     */
    @Test
    public void transitionTestOnAnExistingDirectory() throws Exception {
        Operation operation = new CdOperation();
        String[] operations = {"cd", "existingDirectory"};
        File homeDir = new File(System.getProperty("user.dir"));
        File currentDir = new File(homeDir.getPath());
        File actual = operation.execute(operations, homeDir, currentDir);
        File expected = new File(homeDir.getPath());
        Assert.assertEquals(expected, actual);
    }

    /**
     * Тест метода получения сообщения  результа.
     */
    @Test
    public void getMessage() throws Exception {
        Operation operation = new CdOperation();
        String[] operations = {"cd", "src"};
        File homeDir = new File(System.getProperty("user.dir"));
        File currentDir = new File(homeDir.getPath());
        File actual = operation.execute(operations, homeDir, currentDir);
        String expected = actual.getPath() + ">";
        String message = operation.getMessage();
        Assert.assertEquals(expected, message);
    }

    /**
     * Тест  получения сообщения при попытке перейти на несуществующую директорию.
     */
    @Test
    public void getMessageExistingDirectory() throws Exception {
        Operation operation = new CdOperation();
        String[] operations = {"cd", "existingDirectory"};
        File homeDir = new File(System.getProperty("user.dir"));
        File currentDir = new File(homeDir.getPath());
        File actual = operation.execute(operations, homeDir, currentDir);
        String expected = "Системе не удается найти указанный путь.\n" + actual + ">";
        String message = operation.getMessage();
        Assert.assertEquals(expected, message);
    }

    /**
     * Тест получения сообщения при попытки подняться выше родительского каталогаю
     */

    @Test
    public void getMessageToRiseAboveTheCatalog() throws Exception {
        Operation operation = new CdOperation();
        String[] operations = {"cd", ".."};
        File homeDir = new File(System.getProperty("user.dir"));
        File currentDir = new File(homeDir.getPath());
        File actual = operation.execute(operations, homeDir, currentDir);
        String expected = "Запрещается подниматься выше" +
                " корневого каталога.\n" + actual + ">";
        String message = operation.getMessage();
        Assert.assertEquals(expected, message);
    }
}