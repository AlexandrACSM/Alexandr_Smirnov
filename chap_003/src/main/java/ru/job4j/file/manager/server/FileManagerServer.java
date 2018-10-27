package ru.job4j.file.manager.server;

import ru.job4j.Setting;
import ru.job4j.file.manager.Manager;
import ru.job4j.file.manager.operations.DirOperation;
import ru.job4j.file.manager.operations.Operation;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Aleksandr Smirnov.
 */
public class FileManagerServer {
    /**
     * Порт сервера.
     */
    private int port;

    /**
     * Конструктор по умолчанию.
     */
    public FileManagerServer() {
        this.port = port;
    }
    /**
     * Методзапускающий сервер.
     */
    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            Manager manager = new Manager();
            System.out.println("Waiting for a client");
            Socket socket = serverSocket.accept();
            System.out.println("Got a client");
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataInputStream in = new DataInputStream(inputStream);
            DataOutputStream out = new DataOutputStream(outputStream);
            String line = null;
            String msg = String.format("%s\n%s%s","Для получения списка команд введите - help.", manager.getCurrentDir(), '>');
            while (true) {
                if(line!=null){
                    msg = manager.start(new File(manager.getHomeDir()), new File(manager.getCurrentDir()),line);
                }
                byte[] lines = msg.getBytes();
                int lineSize = lines.length;
                out.writeInt(lineSize);
                out.write(lines);
                line = in.readUTF();
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод получения порта.
     * @throws Exception
     */
    public void getPathPort() throws Exception {
        Setting setting = new Setting();
        ClassLoader classLoader = Setting.class.getClassLoader();
        try (InputStream io = classLoader.getResourceAsStream("app.properties")) {
            setting.load(io);
        }
        String portLocal = setting.getValue("localhost.path");
        port = Integer.parseInt(portLocal) ;
    }
}