package ru.job4j.palindrome.output;

/**
 * Интрефейс реализующий вывод сообщений в консоль.
 * @author Aleksandr Smirnov.
 * @version 1
 * @since 12.02.2017.
 */
public interface PalindromeOutPutController {
    public void writeMission();
    public void writePalindrome(boolean palindrome);
}
