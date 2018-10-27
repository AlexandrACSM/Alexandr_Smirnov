package ru.job4j.bot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Aleksandr Smirnov.
 */
public class Action {

    /**
     * Метод ищет совпадение с введенной строкой клиента и выдает следующую строку.
     * @param file - текстовый файл с фразами.
     * @param str - строка которую ввел пользователь.
     * @return line - возвращает строку.
     */
    public String getAnswer(File file, String str) {
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            String line;
            while ((line = raf.readLine())!=null){
                if (line.equals(str)){
                  return line = raf.readLine();
                }else {
                  return  "What?";
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }return null;
    }
}