package ru.job4j.start;

import java.util.Scanner;

/**
 * Class
 *
 * @author Aleksandr Smirnov.
 * @vesion
 * @since 30.01.2017.
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.next();
    }

    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
             throw new MenuOutExceptions("Out of menu range");
        }
    }
}
