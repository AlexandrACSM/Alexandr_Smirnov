package ru.job4j.lsp.food;

import java.util.Calendar;

/**
 * @author Aleksandr Smirnov.
 */
public class Curd extends Food {
    /**
     * Название продукта.
     */
    private static final String NAME = "Crud";
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
     * Возможность переработки.
     */
    private static final boolean CAN_REPRODUCT = true;

    /**
     * Конструктор по умолчанию.
     * @param createDate - дата изготовления.
     */
    public Curd(Calendar createDate) {
        super(NAME, createDate, EXPIRY_DATE, EXPIRY_DATE_IN_DAY, price, CAN_REPRODUCT);
    }
}
