package ru.job4j.start;

/**
 * Class
 *
 * @author Aleksandr Smirnov.
 * @vesion
 * @since 01.02.2017.
 */
public interface UserAction {
    int key();
    void execute(Input input, Tracker tracker);
    String info();
}
