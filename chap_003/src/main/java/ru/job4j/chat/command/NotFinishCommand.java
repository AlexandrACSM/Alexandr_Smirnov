package ru.job4j.chat.command;

import ru.job4j.chat.command.Command;

/**
 * @author Aleksandr Smirnov.
 */
public abstract class NotFinishCommand implements Command {
    @Override
    public boolean isFinish() {
        return false;
    }
}
