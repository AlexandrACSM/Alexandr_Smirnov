package ru.job4j.start;

/**
 * Класс отлавливающий ошибки.
 * @author Aleksandr Smirnov.
 * @version 1.
 * @since 02.02.2017.
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Метод отлавливающий ошибки.
     * @param question
     * @param range
     * @return
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutExceptions moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}
