package ru.job4j.palindrome.input;

import java.util.Scanner;
/**
 * Класс ввода информации в консоль.
 * @author Aleksandr Smirnov.
 * @version 1
 * @since 12.02.2017.
 */
public class PalindromeConsoleInputController implements PalindromeInputController {
    /**
     * Метод ввода слов. Проверяется корректность ввода.
     * @return str.toLowerCase() - введенное пользователем слова в нижнем регистре.
     */
    @Override
    public String enterPalindrome() {
        Scanner scanner = new Scanner(System.in);
        String str = "";
        boolean p = false;
        while (p != true) {
            str = scanner.nextLine();
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (Character.isLetter(chars[i]) == false) {
                    p = false;
                    System.out.println("Слово содержит недопустимые символы");
                    break;
                } else if (str.toCharArray().length >= 6 || str.toCharArray().length < 5) {
                    p = false;
                    System.out.println("Слово должно состоять из 5 букв");
                    break;
                } else if (i == chars.length - 1) {
                    p = true;
                }
            }
        }
        return str.toLowerCase();
    }
}