package ru.job4j.file.manager.client;

/**
 * @author Aleksandr Smirnov.
 */
public class StartClient {
    /**
     * Основной метод сервера.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        FileManagerClient fileManagerClient = new FileManagerClient();
        fileManagerClient.getPathByPortAndAddress();
        fileManagerClient.start();
    }
}
