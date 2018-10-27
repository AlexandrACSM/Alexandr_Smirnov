package ru.job4j.bot.server;

/**
 * @author Aleksandr Smirnov.
 */
public class StartServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.startServer();
    }
}
