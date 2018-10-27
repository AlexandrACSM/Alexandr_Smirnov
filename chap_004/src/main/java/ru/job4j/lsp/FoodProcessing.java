package ru.job4j.lsp;


import ru.job4j.lsp.food.Food;

import java.util.Calendar;

/**
 * @author Aleksandr Smirnov.
 */
public class FoodProcessing extends Storehouse {
    /**
     * Название хранилища.
     */
//    private static final String STOREHOUSE_NAME = "Food processing One";
    /**
     * Тип хранилища.
     */
    private static final String TYPE_STOREHOUSE = String.valueOf(TypeStorehouse.FOOD_PROCESSING);

    /**
     * Вместимость склада.
     */
//    private static final int STOREHOUSE_SIZE = 10;

    /**
     * Конструктор по умолчанию.
     */
    public FoodProcessing(String storehouseName, int storehouseSize) {
        super(storehouseName, TYPE_STOREHOUSE, storehouseSize);
    }

    /**
     * Метод проверяет продукт по сроку годности.
     *
     * @param food     - продукт.
     * @param calendar - текущая дата.
     * @return - true - если срок годности удовлетворяет требования хранилища,
     * false - если срок годности не удовлетворяет тревания хранилища.
     */
    @Override
    public boolean checkFood(Food food, Calendar calendar) {
        if (food.getPercentByTime() >= getTR() && food.isCanReproduct() == true) {
            return true;
        }
        return false;
    }
}
