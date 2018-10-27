package ru.job4j.file.manager.operations;

import java.io.File;

/**
 * @author Aleksandr Smirnov.
 */
public class CdOperation implements Operation {
    /**
     * Ключ операции.
     */
    private final static String KEY = "cd";
    /**
     * Информация по операции.
     */
    private final static String INFO = "cd каталог - смена каталога.\n";
    /**
     * Сообщение об ошибки при попытки пользователем подняться выше
     * родительского каталога.
     */
    private final static String MESSAGE_DO_NOT_CLIMB_ABOUT_THE_ROOT = "Запрещается подниматься выше" +
            " корневого каталога.\n";
    /**
     * Сообщение об ошибки при вводе некорректного пути.
     */
    private final static String MESSAGE_PATH_NOT_FOUND = "Системе не удается найти указанный путь.\n";
    private String message;

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public File execute(String[] operation, File homeDir, File currentDir) {
        String folder = operation[1];
        File newDir;
        if (operation[1].equals("..")) {
            newDir = new File(currentDir.getParent());
            if (currentDir.getPath().length() > homeDir.getPath().length()) {
                message = String.format("%s%s", newDir, ">");
            } else {
                message = String.format("%s%s%s", MESSAGE_DO_NOT_CLIMB_ABOUT_THE_ROOT, currentDir.getPath(), '>');
            }
        } else if (folder != null) {
            newDir = new File(String.format("%s\\%s", currentDir.getPath(), folder));
            if (newDir.isDirectory()) {
                currentDir = newDir;
                message = String.format("%s%s", currentDir.getPath(), ">");
                return currentDir;
            } else {
                message = String.format("%s%s%s", MESSAGE_PATH_NOT_FOUND, currentDir.getPath(), '>');
            }
        }
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
