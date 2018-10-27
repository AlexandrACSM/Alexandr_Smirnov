package ru.job4j.start;

/**
 * @author Aleksandr Smirnov.
 * @version 1.
 * @since 30.01.2017.
 */
public interface Input {
    String ask(String question);
    int ask(String question, int[] range);
}
