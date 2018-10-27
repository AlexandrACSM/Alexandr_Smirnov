package ru.job4j.isp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleksandr Smirnov.
 */
public class MenuItem  {

    private String key;

    private String name;

    private boolean parent;

    private final List<MenuItem> menuItems = new ArrayList<>();


    public MenuItem(final String key,final String name) {
        this.key = key;
        this.name = name;
        this.parent = parent;
    }

    public MenuItem(final String key,final String name, boolean parent) {
        this.key = key;
        this.name = name;
        this.parent = parent;
    }

    public MenuItem() {
    }

    public static void main(String[] args) {
        MenuItem menuItem = new MenuItem("1", "Task");
        MenuItem item = new MenuItem("1.1", "Task", true);
        MenuItem item2 = new MenuItem("1.2", "Task", true);
        MenuItem menuItem2 = new MenuItem("2", "Task");
        MenuItem item3 = new MenuItem("2.1", "Task", true);
        MenuItem item5 = new MenuItem("2.1.1", "Task", true);
        MenuItem item6 = new MenuItem("2.2", "Task", true);
        MenuItem menu = new MenuItem();
        menu.menuItems.add(menuItem);
        menu.menuItems.add(item);
        menu.menuItems.add(item2);
        menu.menuItems.add(menuItem2);
        menu.menuItems.add(item3);
        menu.menuItems.add(item5);
        menu.menuItems.add(item6);
        for (MenuItem menuItem1 : menu.menuItems) {
            System.out.print(menuItem1.toString());
        }
    }

    /**
     * Метод определяет ко-во пропусков
     * @param s - строка.
     * @return - кол-во пропусков.
     */
    public int getCountSpace(String s) {
        int count = 0;
        for (char chars1 : s.toCharArray()) {
            if ((int) chars1 > 47 && (int) chars1 < 58) {
                count++;
            }
        }
        return count;
    }


    @Override
    public String toString() {
        if (!parent) {
            return String.format("%s%s%s%s", key, " ", name, "\n");
        }
        String c = "-";
        int count = getCountSpace(key);
        for (int i = 2; i <= count - 1; i++) {
            if (count > 1) {
                String b = "-";
                c = c + b;
            }
        }
        return String.format("%s%s%s%s%s", c, key, " ", name, "\n");
    }
}