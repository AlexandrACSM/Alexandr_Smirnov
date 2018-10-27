package ru.job4j.services;

import java.util.*;

/**
 * @author Aleksandr Smirnov.
 */
public class SortUser {
    /**
     * Метод сортировки по возрасту.
     *
     * @param list - коллекция.
     * @return - Set коллекция.
     */

    public Set<User> sortByAge(List<User> list) {
        Set<User> set = new TreeSet<>();
        for (User a : list) {
            set.add(a);
        }
        return set;
    }

    /**
     * Метод сортировки по длине имени.
     *
     * @param list - коллекция.
     * @return collection -  ArrayList коллекция.
     */
    public List<User> sortByNameLength(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return list;
    }

    /**
     * Метод сортировки по хэш-коду.
     *
     * @param list - коллекция.
     * @return collection - ArrayList коллекция.
     */
    public List<User> sortHash(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.hashCode(),o2.hashCode());
            }
        });
        return list;
    }
}
