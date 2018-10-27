package ru.job4j.lsp;

import ru.job4j.lsp.food.Food;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author Aleksandr Smirnov.
 */
public abstract class Storehouse {
    /**
     * название склада.
     */
    private final String storehouseName;
    /**
     * Тип склада склада.
     */
    private final String storehouseType;
    /**
     * Значение истекшего на 25% срока хранения.
     */
    private static final int MIN_EXPIRED_SHELF_LIFE = 25;
    /**
     * Значение истекшего на 75% срока хранения.
     */
    private static final int MAX_EXPIRED_SHELF_LIFE = 75;
    /**
     * Значение истекшего на 100% срока хранения.
     */
    private static final int TR = 100;
    /**
     * Коллекция хранилища.
     */
    private List<Food> foods = new ArrayList<>();

    private final int storehouseSize;

    /**
     * Метод проверяет продукт по сроку годности.
     * @param food - продукт.
     * @param calendar - текущая дата.
     * @return - true - если срок годности удовлетворяет требования хранилища,
     *           false - если срок годности не удовлетворяет тревания хранилища.
     */
    public abstract boolean checkFood(Food food, Calendar calendar);

    public static int getMinExpiredShelfLife() {
        return MIN_EXPIRED_SHELF_LIFE;
    }

    public static int getMaxExpiredShelfLife() {
        return MAX_EXPIRED_SHELF_LIFE;
    }

    public static int getTR() {
        return TR;
    }

    public Storehouse(String storehouseName, String name, int storehouseSize) {
        this.storehouseName = storehouseName;
        this.storehouseType = name;
        this.storehouseSize = storehouseSize;
    }


    public List<Food> getFoods() {
        return foods;
    }

    public int getStorehouseSize() {
        return storehouseSize;
    }

    @Override
    public String toString() {
        return "Storehouse{" +
                ", storehouseType='" + storehouseType + '\'' +
                "storehouseName='" + storehouseName + '\'' +
                ", foods=" + foods +
                '}';
    }
}
