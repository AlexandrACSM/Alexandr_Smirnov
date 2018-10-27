package ru.job4j.convert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Aleksandr Smirnov.
 */
public class ConvertArrayList {
    /**
     * Метод получения лист из массива.
     *
     * @param array
     * @return
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new LinkedList<>();
        for (int[] i : array) {
            for (int b : i) {
                list.add(b);
            }
        }
        return list;
    }

    /**
     * Метод получение массива из List.
     *
     * @param list - коллекция.
     * @param rows - кол-во размер массива.
     * @return - массив.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int[][] array = new int[rows][rows];
        int temp = 0;
        for (int[] i : array) {
            for (int j = 0; j < rows; j++) {
                if (temp < list.size()) {
                    i[j] = list.get(temp);
                    temp++;
                } else {
                    return array;
                }
            }
        }
        return array;
    }

    /**
     * Метод вычисляет rows.
     *
     * @param list - входящий список.
     * @return rows - кол-во колонок.
     */
    public int getRows(List<Integer> list) {
        int rows = list.size();
        do {
            if (Math.sqrt(rows) % 1 == 0) {
                return (int) Math.sqrt(rows);
            }
            rows++;
        } while (rows % 1 == 0);
        return 0;
    }
    /**
     * Метод переносит данные из List<int[]> в List<Integer>.
     *
     * @param list
     * @return
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new LinkedList<>();
        for (int[] array : list) {
            for (Integer element : array) {
                result.add(element);
            }
        }
        return result;
    }
}