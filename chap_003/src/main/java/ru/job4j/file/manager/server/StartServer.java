package ru.job4j.file.manager.server;

/**
 * @author Aleksandr Smirnov.
 */
public class StartServer {
    /**
     * Основной метод сервера.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        FileManagerServer fileManagerServer = new FileManagerServer();
        fileManagerServer.getPathPort();
        fileManagerServer.start();
    }
}
