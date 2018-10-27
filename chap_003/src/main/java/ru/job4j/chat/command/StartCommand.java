package ru.job4j.chat.command;

import java.util.Scanner;

/**
 * @author Aleksandr Smirnov.
 */
public class StartCommand extends NotFinishCommand {
    @Override
    public String getName() {
        return "startClient";
    }

    @Override
    public String execute(String stack, Scanner sc) {
        return stack;
    }
}
