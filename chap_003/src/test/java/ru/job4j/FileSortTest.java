package ru.job4j;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import static org.junit.Assert.*;

/**
 * Класс тестирует методы сортировки файла.
 *
 * @author Aleksandr Smirnov.
 */
public class FileSortTest {
    private final String separator = System.getProperty("line.separator");

    /**
     * Тесто метода очистки файла.
     */
    @Test
    public void clearDistance() {
        FileSort fileSort = new FileSort();
        File file = new File("TestFile.txt");
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            raf.writeBytes("TeSt");
            raf.writeBytes(separator);
            raf.writeBytes("Test");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(file.length() != 0);
        fileSort.clearDistance(file);
        Assert.assertTrue(file.length() == 0);
        file.deleteOnExit();
    }

    /**
     * Тест метода сортировки массива.
     */
    @Test
    public void sortArray() {
        FileSort fileSort = new FileSort();
        final int arraySize = 3;
        String[] expected = new String[]{"1", "22", "333"};
        String[] actual = null;
        File file = new File("TestFile.txt");
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            raf.writeBytes("22");
            raf.writeBytes(separator);
            raf.writeBytes("1");
            raf.writeBytes(separator);
            raf.writeBytes("333");
            raf.writeBytes(separator);
            actual = fileSort.sortArray(arraySize, file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expected, actual);
        file.deleteOnExit();
    }

    /**
     * Тест сортировки двух отсортированных массивов и запись результата в текстовый файл.
     */
    @Test
    public void getSortDistance() {
        FileSort fileSort = new FileSort();
        final int arraySize = 6;
        String[] strOne = new String[]{"333", "55555", "666666"};
        String[] strTwo = new String[]{"1", "22", "55555"};
        String[] actual = new String[6];
        String[] expected = new String[]{"1", "22", "333", "55555", "55555", "666666"};
        File file = new File("TestFile.txt");
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            fileSort.getSortDistance(strOne, strTwo, file);
            raf.seek(0);
            for (int i = 0; i < actual.length; i++) {
                actual[i] = raf.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(file.exists());
        assertArrayEquals(expected, actual);
        file.deleteOnExit();
    }
}