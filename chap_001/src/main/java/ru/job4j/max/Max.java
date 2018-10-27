package ru.job4j.max;

/**
 * The class for define of the max numbers.
 * Класс для определения наибольшего числа.
 * @author smirnov
 * @since 21.01.2017
 */
public class Max {
    /**
     * Метод нахождения наибольшего числа из двух.
     *The method of the maximum identification of two numbers
     * @param first  - the first number первый аргумент.
     * @param second - the second number второй аргумент.
     * @return - return of the maximum numbers возвращает максимальное число.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Метод нахождения наибольшего числа из трех.
     *The method of the maximum identification of two numbers.
     * @param first  - the first argument.
     * @param second - the second argument.
     * @param third  - the third argument.
     * @return - returns the maximum number (возращает максимальное число).
     */
    public int max(int first, int second, int third) {
        return max(first, max(second, third));
    }
}