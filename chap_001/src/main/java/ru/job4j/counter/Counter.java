package ru.job4j.counter;

	/**
     * Class for calculating the sum of even numbers in a given interval.
	 * Класс вычисления суммы четных чисел в заданном интервале.
	 * @author smirnov
	 * @since 21.01.2017
	 */
public class Counter {
	/**
     * The method calculating the sum of even numbers.
	 * Метод вычисляющий сумму четных чисел.
	 * @param start - Initial value of interval начальное значение интервала.
	 * @param finish - the final value of interval. конечное значени интервала.
	 * @return sum - The sum of numbers in a given interval возвращение суммы чисел в заданном интервале.
	 */
    public long add(long start, long finish) {
        long counter = start;
		long sum = 0;
        while (counter <= finish) {
            if (counter % 2 == 0) {
                sum = sum + counter;
                counter++;
            } else {
                counter++;
            }
        }
        return sum;
    }
}