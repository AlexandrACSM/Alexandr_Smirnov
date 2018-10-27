package ru.job4j.file.manager.operations;

import java.io.File;

/**
 * @author Aleksandr Smirnov.
 */
public class DirOperation implements Operation {
    private final static String KEY = "dir";
    private final static String INFO = "dir - отображение списка файлов и каталогов.\n";
    private String message;

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public File execute(String operation[], File homeDir, File currentDir) {

        StringBuilder builder = new StringBuilder();
        File[] files = currentDir.listFiles();
        for (int index = 0; index < files.length; index++)
            if (index < files.length - 1) {
                builder.append(files[index].getName()).append("\r\n");
            } else {
                builder.append(files[index].getName());
            }
        String msg = builder.toString();
        byte[] array = msg.getBytes();
        message = new String(array)+"\n\r"+currentDir+">";
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
