package ru.job4j.palindrome.output;
import ru.job4j.palindrome.PalindromeAnalysis;
/**
 * Класс для вывода текстовых сообщений в консоль.
 * @author Aleksandr Smirnov.
 * @version 1
 * @since 12.02.2017.
 */
public class PalindromeConsoleOutputController implements PalindromeOutPutController {
    /**
     * Вывод в консоль сообщения для пользователя.
     */
    @Override
    public void writeMission() {
        System.out.println("Введите слово");
    }

    /**
     * Вывод в консоль результата проверки слова.
     * @param palindrome
     */
    @Override
    public void writePalindrome(boolean palindrome) {
        PalindromeAnalysis pr = new PalindromeAnalysis();
        if (palindrome == true) {
            System.out.println("Данное слово является палинромом");
        } else {
            System.out.println("Данное слово не является палиндромом");
        }
    }
}