package ru.job4j.chat.command;

import java.util.Scanner;

/**
 * @author Aleksandr Smirnov.
 */
public   class StopCommand extends NotFinishCommand {
    @Override
    public String getName() {
        return "stop";
    }

    @Override
    public String execute(String stack , Scanner sc) {
        return "";
    }
}
