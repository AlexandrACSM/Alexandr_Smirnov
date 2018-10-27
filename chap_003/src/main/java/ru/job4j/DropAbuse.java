package ru.job4j;

import java.io.*;
import java.util.Scanner;

/**
 * @author Aleksandr Smirnov.
 * @version 1
 * @since 11.02.2017.
 */
public class DropAbuse {
    public static void main(String[] args) throws IOException {
        DropAbuse dropAbuse = new DropAbuse();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final String[] abuse = new String[]{"0", ",", "s"};
        String string = "dadaw0fa,ssss$";
        dropAbuse.getDropAbuse(new ByteArrayInputStream(string.getBytes()), byteArrayOutputStream, abuse);

    }


    public void getDropAbuse(InputStream inputStream, OutputStream outputStream, String[] abuse) throws IOException {

        try (InputStream in = inputStream; OutputStream out = outputStream) {
            Scanner sc  = new Scanner(in);
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                for (String str : abuse) {
                    s = s.replaceAll(str, "");
                }
                out.write(s.getBytes());
            }
        }
    }

}
