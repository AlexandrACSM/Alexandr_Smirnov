package ru.job4j.services;

import java.util.HashMap;
import java.util.List;

/**
 * @author Aleksandr Smirnov.
 */
public class UserConvert {

    /**
     * Метод переносит данные из List<User> в HashMap<Integer, User>.
     * В качестве ключа используется поле userId.
     *
     * @param list
     * @return
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> hashMapList = new HashMap<>();
        for (User a : list) {
            hashMapList.put(a.getId(), a);
        }
        return hashMapList;
    }
}
