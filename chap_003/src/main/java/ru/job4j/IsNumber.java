package ru.job4j;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author Aleksandr Smirnov.
 * @version 1
 * @since 11.02.2017.
 */
public class IsNumber {
    /**
     *
     * @param in - Входящий поток.
     * @return if integer value - true else odd number - false
     * @throws IOException
     */
    public boolean getIsNumber(InputStream in) throws IOException {
        int temp;
        boolean checkNumber = false;
        try (Scanner sc = new Scanner(in)) {
            if (sc.hasNext()) {
                temp = sc.nextInt();
                checkNumber = (temp % 2 == 0);
            }
        } catch (Exception e) {
            return false;
        }
        return checkNumber;
    }
}