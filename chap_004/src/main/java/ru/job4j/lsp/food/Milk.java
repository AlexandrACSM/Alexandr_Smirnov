package ru.job4j.lsp.food;


import java.util.Calendar;

/**
 * @author Aleksandr Smirnov.
 */
public class Milk extends Food {
    /**
     * Название продукта.
     */
    private static final String NAME = "Milk";
    /**
     * Срок годности в днях.
     */
    private static final int EXPIRY_DATE_IN_DAY = 5;
    /**
     * Дата окончания срока годности.
     */
    private static Calendar EXPIRY_DATE;
    /**
     * Стоимость.
     */
    private static double price = 25;
    /**
     * Подходит для переработки. true - подходит, false - не подходит.
     */
    private static final boolean CAN_REPRODUCT = false;
    /**
     * Конструктор по умолчанию.
     *
     * @param createDate - дата изготовления.
     */
    public Milk(Calendar createDate) {
        super(NAME, createDate, EXPIRY_DATE, EXPIRY_DATE_IN_DAY, price, CAN_REPRODUCT);
    }
}
