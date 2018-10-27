package ru.job4j;

import org.junit.Test;
import ru.job4j.chat.ConsoleChat;
import org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Aleksandr Smirnov.
 */
public class ConsoleChatTest {
    private final String separator = System.getProperty("line.separator");

    /**
     * Тест добавления строк в текстовый файл.
     */
    @Test
    public void manipulationWithFile() {
        File file = new File("Test.txt");
        ConsoleChat consoleChat = new ConsoleChat();
        String str = "1";
        String str2 = "22";
        consoleChat.manipulationWithFile(str, str2, file);
        String[] strings = new String[]{"User - 1", "PC - 22"};
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            Assert.assertTrue(file.exists());
            String line;
            int i = 0;
            while ((line = raf.readLine()) != null) {
                Assert.assertTrue(strings[i].equals(line));
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        file.deleteOnExit();
    }

    /**
     * Тест метода очистки текстового файла.
     */
    @Test
    public void clearFile() {
        ConsoleChat consoleChat = new ConsoleChat();
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
        consoleChat.clearFile(file);
        Assert.assertTrue(file.length() == 0);
        file.deleteOnExit();
    }

    /**
     * Тест получения случайной строки из текстового файла.
     */
    @Test
    public void getPhrase() {
        int numberLine;
        ConsoleChat consoleChat = new ConsoleChat();
        String[] strings = new String[]{"1", "22", "333","4444","562","42"};
        File file = new File("TestFile.txt");
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            String line;
            int i = 0;
            while (i < strings.length) {
                raf.writeBytes(strings[i]);
                raf.writeBytes(separator);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        file.deleteOnExit();
        System.out.println(String.format("Test getPhrase:"));
        for (int i = 0; i < strings.length; i++) {
            numberLine = consoleChat.generationRandomIntValues(consoleChat.numbersOfLines(file));
            String result = consoleChat.getPhrase(file, numberLine);
            System.out.println(String.format("Actual %s, Expected %s", strings[numberLine],result));
            Assert.assertTrue(strings[numberLine].equals(result));
        }
    }
}
