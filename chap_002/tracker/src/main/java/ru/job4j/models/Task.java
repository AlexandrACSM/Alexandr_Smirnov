package ru.job4j.models;

/**
 * Class
 *
 * @author Aleksandr Smirnov.
 * @vesion
 * @since 25.01.2017.
 */
public class Task extends Item {
    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String calculate(){
        return getDateCreateItem();
    }
}
