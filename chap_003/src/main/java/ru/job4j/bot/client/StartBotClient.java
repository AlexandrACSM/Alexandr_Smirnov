package ru.job4j.bot.client;

/**
 * @author Aleksandr Smirnov.
 */
public class StartBotClient {
    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.startClient();
    }
}
