package ru.job4j;

	/**
     * The class identifying whether the STRING "sub" is a substring "origin" or not.
	* Класс определяющий является ли строка sub подстрокой origin.
	* @author smirnov
	* @since 22.01.2017
	*/
public class CheckLine {
	/**
     * The method converting the string in char[]
     * Метод преобразующий String в char[].
	 * @param strings - The incoming string (входящая строка).
	 * @return The char[] array(char[] массива).
	 */
	    public char[] stringInChar(String strings) {
        return strings.toCharArray();
    }
    /**
     * The method checks  whether the "sub" a substring "original" or not
	 * Метод проверяет является ли sub подстрокой original.
	 * @param ch - The "origin" array (массив origin).
	 * @param p - The "sub" array (массив sub).
	 * @return boolean - output the results of the string comparisons (boolean - вывод результата сравнения строк).
	 */
     public boolean checkSubString(char[] ch, char[] p) {
        int count = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == p[count]) {
                count++;
                if (ch[i] == p[p.length - 1] && count == p.length) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }
}