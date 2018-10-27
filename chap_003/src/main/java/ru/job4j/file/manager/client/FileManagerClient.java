package ru.job4j.file.manager.client;

import ru.job4j.Setting;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Aleksandr Smirnov.
 */
public class FileManagerClient {
    /**
     * Порт сервера.
     */
    private int port;
    /**
     * Адрес сервера.
     */
    private String address;

    /**
     * Конструктор по умолчанию.
     */
    public FileManagerClient() {
        this.port = port;
        this.address = address;
    }

    /**
     * Метод запускает клиент.
     *
     * @throws UnknownHostException
     */

    public void start() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName(address);
        try (Socket socket = new Socket(inetAddress, port)) {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataInputStream in = new DataInputStream(inputStream);
            DataOutputStream out = new DataOutputStream(outputStream);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while (true) {
                int sizeArray = in.readInt();
                byte[] bytes = new byte[sizeArray];
                in.read(bytes, 0, sizeArray);
                line = new String(bytes);
                System.out.print(line);
                line = keyboard.readLine();
                out.writeUTF(line);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод получения порта и адреса.
     *
     * @throws Exception
     */
    public void getPathByPortAndAddress() throws Exception {
        Setting setting = new Setting();
        ClassLoader classLoader = Setting.class.getClassLoader();
        try (InputStream io = classLoader.getResourceAsStream("app.properties")) {
            setting.load(io);
        }
        String pathPort = setting.getValue("localhost.path");
        port = Integer.parseInt(pathPort);
        String pathAddress = setting.getValue("address.path");
        address = pathAddress;
    }
}
