package ru.job4j.file.manager.operations;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;

/**
 * @author Aleksandr Smirnov.
 */
public interface Operation {
    /**
     * Метод возвращает ключ.
     *
     * @return
     */
    String getKey();
    /**
     * Метод реализует операцию.
     */
    File execute(String[] operation, File homeDir, File currentDir);

    /**
     * Метод вывод сообщение привыполнении операции.
     * @return
     */
    String getMessage();

    /**
     * Метод для получения информации по операции.
     * @return
     */
    String getInfo();

}
