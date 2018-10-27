package ru.job4j.isp;

import java.util.List;

/**
 * @author Aleksandr Smirnov.
 */
public abstract class Action {

    private String key;

   abstract void execute(String key, List<MenuItem> menuItems);

    public String getKey() {
        return key;
    }
}
