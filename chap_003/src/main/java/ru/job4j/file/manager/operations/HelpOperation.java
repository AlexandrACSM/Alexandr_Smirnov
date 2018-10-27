package ru.job4j.file.manager.operations;

import ru.job4j.file.manager.Manager;

import java.io.File;

/**
 * @author Aleksandr Smirnov.
 */
public class HelpOperation implements Operation {
    /**
     * Ключ операции.
     */
    private static final String KEY = "help";
    /**
     * Информация по операции.
     */
    private final static String INFO = "help - отобразить справочную информацию.\n";
    /**
     * Результатоперации.
     */
    private String message;

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public File execute(String[] operation, File homeDir, File currentDir) {
        message = String.format("%s%s", currentDir.getPath(), ">");
        return currentDir;
    }

    @Override
    public String getMessage() {
        Manager.OperationsFactory operationsFactory = new Manager.OperationsFactory();
        Operation[] operation = operationsFactory.getOperations();
        StringBuilder sb = new StringBuilder();
        for (Operation op : operation) {
            sb.append(op.getInfo());
        }
        sb.append(message);
        message = String.valueOf(sb);
        return message;
    }

    @Override
    public String getInfo() {
        return INFO;
    }
}
