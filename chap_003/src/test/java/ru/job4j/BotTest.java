package ru.job4j;

import org.junit.Test;
import ru.job4j.bot.Action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Aleksandr Smirnov.
 */
public class BotTest {

    @Test
    public void getAnswer() {
        Action action = new Action();
        final String separator = System.getProperty("line.separator");
        File file = new File("TestFile.txt");
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            raf.writeBytes("Hello");
            raf.writeBytes(separator);
            raf.writeBytes("Hi");
            raf.writeBytes(separator);
            raf.writeBytes("How are you?");
            raf.writeBytes(separator);
            String str = action.getAnswer(file, "Hi");
            System.out.println(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

