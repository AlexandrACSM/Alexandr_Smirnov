package ru.job4j.chat.command;

import java.util.Scanner;

/**
 * @author Aleksandr Smirnov.
 */
public  class ExitCommand implements Command {
    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String execute(String stack, Scanner sc) {
        return "bye";
    }

    @Override
    public boolean isFinish() {
        return true;
    }
}