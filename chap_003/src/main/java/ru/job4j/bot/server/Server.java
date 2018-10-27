package ru.job4j.bot.server;

import ru.job4j.Setting;
import ru.job4j.bot.Action;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Aleksandr Smirnov.
 */
public class Server {
    private static final String EXIT_KEY = "exit";
    private File phrases;

    public Server() {
        this.phrases = phrases;
    }

    public void pathFile() throws Exception {
        Setting setting = new Setting();
        ClassLoader classLoader = Setting.class.getClassLoader();
        try (InputStream io = classLoader.getResourceAsStream("app.properties")) {
            setting.load(io);
        }
        String filePhrases = setting.getValue("bot.path");
        phrases = new File(filePhrases);
    }

    public void startServer() throws Exception {
        Server server = new Server();
        final int port = 7000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Waiting for a client");
            Socket socket = serverSocket.accept();
            System.out.println("Got a client ");
            System.out.println();

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            DataInputStream in = new DataInputStream(inputStream);
            DataOutputStream out = new DataOutputStream(outputStream);
            server.pathFile();
            String line = "";
            Action action = new Action();
            while (true) {
                line = in.readUTF();
                if (EXIT_KEY != null && line.equals(EXIT_KEY)) {
                    socket.close();
                    System.out.printf("Last command - " + line);
                    System.out.println("Could not close socket");
                    return;
                }
                line = action.getAnswer(server.phrases, line);
                System.out.printf("Client - " + line);
                out.writeUTF(line);
                out.flush();
                System.out.println("Waiting  for the next line ");
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}