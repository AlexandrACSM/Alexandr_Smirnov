package ru.job4j;
import java.util.Arrays;

	/**
     * The class deletes of the duplicates from the array.
	* Класс удаляющий дубликаты из массива.
	* @author smirnov
	* @since 22.01.2017
	*/
public class DeleteElementArray {
	/**
     * The method set the "null" to duplicate elements.
	* Метод присваивает дублирующимся элементам - null.
	* @param strings -the incoming array string(входящий массив строк).
	* @return strings - the return processed array (возвращение обработанного массива).
	*/
    public String[] allocNullToDuplicatingElements(String[] strings) {
        for (int i = strings.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (strings[i] == strings[j]) {
                    strings[j] = null;
                }
            }
        }
        return strings;
    }
	/**
     * The method wrap around in the end array.
	* Метод переносит null элементы в конец массива.
	* @param strings - The incoming array (входящий массив).
	* @return strings - the return of processed array (возврат обработанного массива).
	*/
    public String[] sortNullTheElementsArray(String[] strings) {
        int count = 0;
        for (int i = strings.length - 1; i >= count;) {
            if (strings[count] == null) {
                String tem;
                tem = strings[i];
                strings[i] = strings[count];
                strings[count] = tem;
                i--;
            }
            count++;
        }
        return strings;
    }
	/**
     * The method deletes "null" value from the array.
	* Метод удаляет null значение из массива.
	* @param strings - The incoming array(входящий массив).
	* @return arrayCopy - The outcoming processed array  (возврат обработанного массива).
	*/
    public String[] deletionNullInArray(String[] strings) {
        int countNull = 0;
        for (String ar : strings) {
            if (ar == null) {
                countNull++;
            }
        }
        String[] arrayCopy = Arrays.copyOf(strings, (strings.length) - countNull);
        return arrayCopy;
    }
}