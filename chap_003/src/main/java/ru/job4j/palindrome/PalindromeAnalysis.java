package ru.job4j.palindrome;

/**
 * Класс проверки слова.
 * @author Aleksandr Smirnov.
 * @version 1
 * @since 12.02.2017.
 */
public class PalindromeAnalysis {
    /**
     * @param world - входящая строка.
     * @return результата проверки.
     */
    public boolean analysisWorld(String world) {
        char[] chars;
        chars = world.toCharArray();
        for (int i = 0; i < (chars.length / 2) - 1; ) {
            for (int j = chars.length - 1; j >= i; j--) {
                if (chars[i] != chars[j]) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}