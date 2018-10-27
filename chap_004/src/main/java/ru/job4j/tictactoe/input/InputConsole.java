package ru.job4j.tictactoe.input;

import java.util.Scanner;

/**
 * @author Aleksandr Smirnov.
 */
public class InputConsole implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String write() {
        return scanner.next();
    }
}
