package ru.job4j.file.manager.operations;

import ru.job4j.file.manager.Manager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author Aleksandr Smirnov.
 */
public class CopyOperation implements Operation {
    private final static String KEY = "copy";
    private final static String INFO = "copy имя_файла путь(каталог в который неообходимо скопировать файл) - копирование файлов.\n";
    private final static String MESSAGE_FILE_NOT_FOUND = "Не удается найти указанный файл.\n";
    private String message;

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public File execute(String[] operation, File homeDir, File currentDir) {
        File newFile = currentDir;
        homeDir = new File(currentDir.getPath() + "\\" + operation[1]);
        if (!homeDir.isFile() && !homeDir.isDirectory()) {
            message = String.format("%s%s%s", MESSAGE_FILE_NOT_FOUND, currentDir, ">");
            return currentDir;
        }
        newFile = new File(operation[2] + "\\" + operation[1]);
        try {
            Files.copy(homeDir.toPath(), newFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        message =String.format("%s%s",currentDir.getPath(),">");
        return currentDir;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getInfo() {
        return INFO;
    }
}