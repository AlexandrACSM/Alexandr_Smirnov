package ru.job4j.models;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Class
 *
 * @author Aleksandr Smirnov.
 * @vesion
 * @since 25.01.2017.
 */
public class Item {
    public String name;
    public String description;
    private String id;
    private String comment;
    public String dateCreate;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Item() {
    }

    public Item(String name, String description, String dateCreate) {
        this.name = name;
        this.description = description;
        this.dateCreate = dateCreate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getId() {
        return this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateCreateItem() {
        return this.dateCreate;
    }

    public void setDateCreateItem(Date dateCreat) {
        Date d = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        dateFormat.format(d);
        this.dateCreate = String.valueOf(dateCreat);
    }

    @Override
    public String toString() {
        if (getComment() == null) {
            return "[Item name: "
                    + this.getName()
                    + "], [Item descriptions: "
                    + this.getDescription()
                    + "], [Created Date: "
                    + this.getDateCreateItem()
                    + "], [id: " + this.getId() + "]";
        }
        return "[Item name: "
                + this.getName()
                + "], [Item descriptions: "
                + this.getDescription()
                + "], [Created Date: "
                + this.getDateCreateItem()
                + "], [Count comments: "
                + this.getComment()
                + "], [id: " + this.getId() + "]";
    }
}