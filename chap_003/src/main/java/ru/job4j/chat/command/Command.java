package ru.job4j.chat.command;

import java.util.Scanner;

/**
 * @author Aleksandr Smirnov.
 */
public interface Command {
    String getName();

    String execute(String stack, Scanner sc);

    boolean isFinish();
}
