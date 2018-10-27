package ru.job4j.factorial;

	/**
     * The class of getting of the factorial numbers.
	 * Класс вычисления факториала числа.
	 * @author smirnov
	 * @since 21.01.2017
	 */
public class Factorial {
	/**
     * The method of computing of the factorial numbers.
	 * Метод вычисляющий факториал числа.
	 * @param fact - the value of factorial. значение факториала.
	 * @return -  return of factorial. факториала.
	 */
    public long getFactorial(long fact) {
        long counter = 1;
        long sum = 1;
        if (fact == 1) {
            return 1;
        }
        while (counter <= fact) {
            sum = sum * counter;
            counter++;
        }
        return sum;
    }
}