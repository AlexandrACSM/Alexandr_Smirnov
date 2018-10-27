package ru.job4j.bot.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Aleksandr Smirnov.
 */
public class Client {


    public void  startClient() throws Exception {
       final int port = 7000;
       final String address = "127.0.0.1";
        InetAddress inetAddress = InetAddress.getByName(address);
        try (Socket socket = new Socket(inetAddress, port)) {

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            DataInputStream in = new DataInputStream(inputStream);
            DataOutputStream out = new DataOutputStream(outputStream);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = null;

            while (true) {
                line = keyboard.readLine();
                out.writeUTF(line);
                out.flush();
                line = in.readUTF();
                System.out.println(line);
            }

        } catch (EOFException eof) {
            System.out.println("Server close");
        }
    }
}