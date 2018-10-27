package ru.job4j.file.manager;

import ru.job4j.file.manager.operations.*;

import java.io.File;

/**
 * @author Aleksandr Smirnov.
 */
public class Manager {
    /**
     * Путь корневого каталога.
     */
    private final String homeDir;
    /**
     * Текущий путь.
     */
    private String currentDir;
    /**
     * Объект ханящий операции.
     */
    private OperationsFactory operationsFactory;
    /**
     * Операция.
     */
    private Operation operation;
    /**
     * Конструтокр по умолчанию.
     */
    private final String commandNotFound = "не является внутренней или внешней " +
            "командой, исполняемой программой или пакетным файлом.\n";

    public Manager() {
        this.operationsFactory = new OperationsFactory();
        this.homeDir = System.getProperty("user.dir");
        this.currentDir = homeDir;
    }

    /**
     * Метод получения результата.
     *
     * @param homeDir       - домашний каталог.
     * @param currentFile   - текущий каталог.
     * @param operationName - операция.
     * @return - результат операции.
     */
    public String start(File homeDir, File currentFile, String operationName) {
        String name = getSplitOperationName(operationName)[0];
        operation = operationsFactory.getOperation(name);
        if (operation != null) {
            File file = operation.execute(getSplitOperationName(operationName), homeDir, currentFile);
            this.currentDir = file.getPath();
            return operation.getMessage();
        }
        return String.format("%s%s%s%s%s", "'",name,"' ",commandNotFound,currentDir,">");

    }

    /**
     * Класс операций.
     */
    public static class OperationsFactory {
        /**
         * Массив операций.
         */
        private Operation[] operations = {
                new DirOperation(),
                new CdOperation(),
                new CopyOperation(),
                new HelpOperation()
        };

        /**
         * Метод получения операции по ключу.
         *
         * @param operationName - имя операции.
         * @return - операцию.
         */
        public Operation getOperation(String operationName) {
            for (Operation operation : operations) {
                if (operationName.equals(operation.getKey())) {
                    return operation;
                }
            }
            return null;
        }

        /**
         * Метод возвращает кол-во доступных операций.
         *
         * @return - кол-во операций;
         */
        public Operation[] getOperations() {
            return operations;
        }
    }

    /**
     * Метод переводит строку в массив строк.
     *
     * @param operatioName - строка.
     * @return strings - массив строк.
     */
    public String[] getSplitOperationName(String operatioName) {
        String[] strings = operatioName.split(" ");
        return strings;
    }

    public String getHomeDir() {
        return homeDir;
    }

    public String getCurrentDir() {
        return currentDir;
    }


}