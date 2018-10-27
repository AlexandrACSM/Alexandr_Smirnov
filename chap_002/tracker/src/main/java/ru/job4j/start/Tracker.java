package ru.job4j.start;

import ru.job4j.models.*;

import java.util.*;

/**
 * Класс содержит методы изменяющие объекты.
 *
 * @author Aleksandr Smirnov.
 * @version 1.0.
 * @since 25.01.2017.
 */
public class Tracker {
    /**
     * items - массив хранящий все объекты Item.
     */
    private List<Item> items = new ArrayList<>();
    /**
     * position - позиция элемента в массиве.
     */
    private int position = 0;
    /*
     * rN - случайное число для id объекта.
     */
    private static final Random rN = new Random();

    /**
     * Метод добавления элемента в массив объекта.
     *
     * @param item - входящий объект массива.
     * @return item - добавленный объект.
     */
    public Item addItem(Item item) {
        item.setId(generateId());
        Date date = new Date();
        item.setDateCreateItem(date);
        items.add(item);
        return item;
    }

    /**
     * Метод изменнения полей элемента по id.
     *
     * @param fresh - измененный объект.
     */
    public void edit(Item fresh) {
        for (Item item : items) {
            if (item.getId().equals(fresh.getId())) {
                item = fresh;
                break;
            }
        }
    }

    /**
     * Метод поиска объекта по полю id.
     *
     * @param id - entering id object.
     * @return result - finding object.
     */
    public Item findById(String id) {
        Item result;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                return result;
            }
        }
        return null;
    }

    /**
     * Метод поска объекта по полю name.
     *
     * @param name - entering name.
     * @return result - finding object.
     */
    public Item findByName(String name) {
        Item result;
        for (Item item : items) {
            if (item != null && item.getName().equals(name)) {
                result = item;
                return result;
            }
        }
        return null;
    }

    /**
     * Метод добавляющий комментарий к объекту.
     *
     * @param id      - entering id object.
     * @param comment - entering comment.
     */
    public void createComment(String id, String comment) {
        for (Item it : items) {
            if (it.getId().equals(id)) {
                it.setComment(comment);
            }
        }
    }

    /**
     * Медот генерации случайного числа.
     *
     * @return - случайное число String.
     */
    public String generateId() {
        return String.valueOf(System.currentTimeMillis() + rN.nextInt());
    }

    /**
     * Метод для поиска всех объектов .
     *
     * @return - возвращает массив объектов.
     */
    public List<Item> getAll() {
        return items;
    }

    /**
     * Метод присваивает значение null  найденному объекту.
     *
     * @param item - entering object.
     * @return items - iterated array Item.
     */
    public List<Item> deleteItem(Item item) {
        for (Item a : items) {
            if (a.getId().equals(item.getId())) {
                items.remove(a);
                return items;
            }
        }
        return items;
    }
}

