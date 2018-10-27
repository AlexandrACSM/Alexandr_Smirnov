package ru.job4j.lsp;

import ru.job4j.lsp.food.Curd;
import ru.job4j.lsp.food.Food;
import ru.job4j.lsp.food.Milk;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Класс распределения продуктов.
 *
 * @author Aleksandr Smirnov.
 */
public class ControlQuality {
    /**
     * Лист хранилищ.
     */
    private List<Storehouse> storehouses = new ArrayList<>();

    /**
     * Конструктор по умолчанию.
     */
    public ControlQuality() {
    }


    /**
     * Метод бегает по хранилищам, дергает продукты и сохранет их в коллекци.
     *
     * @param storegs - коллекция хранилищ.
     * @return - коллекция продуктов.
     */
    public List<Food> getFoodsList(List<Storehouse> storegs) {
        List<Food> foods = new ArrayList<>();
        for (Storehouse storehouse : storegs) {
            for (Food food : storehouse.getFoods()) {
                foods.add(food);
            }
        }
        return foods;
    }

    /**
     * Метод удаляет все элементы со всех хранилищ.
     */
    public void removeFoodsList() {
        for (Storehouse storehouse : getStorehouses()) {
            storehouse.getFoods().removeAll(storehouse.getFoods());
        }
    }

    /**
     * Метод добавляет продукты на склад по сроку годности с учетом кол-ва мест на складе.
     *
     * @param foods - коллекция с продуктами.
     */
    public void sortFoods(List<Food> foods) {
        for (Food food : foods) {
            for (Storehouse storeg : getStorehouses()) {
                if (checkFoodByExpirationDate(storeg, food) && checkSizeStorehouse(storeg)) {
                    storeg.getFoods().add(food);
                    break;
                }
            }
        }
    }

    /**
     * Метод перераспределяет все продукты по хранилищам.
     */
    public void resort() {
        List<Food> foods = getFoodsList(getStorehouses());
        removeFoodsList();
        sortFoods(foods);
    }

    /**
     * Метод определяет на какой склад направить продукт.
     *
     * @param food - продукт.
     */

    public void addFoodOnStorehouse(Food food) {
        //проверяем продукт на складе, если продукт в наличии и его срок
        // годности не для склада false - удаляем продукт со склада.
        for (Storehouse s : getStorehouses()) {
            if (!s.checkFood(food, new GregorianCalendar()) && s.getFoods().contains(food)) {
                s.getFoods().remove(food);
                break;
            }
        }//добавляем продукт на склад.
        for (Storehouse storeg : getStorehouses()) {
            if (checkFoodByExpirationDate(storeg, food) && checkSizeStorehouse(storeg)) {
                storeg.getFoods().add(food);
                break;
            }
        }
    }

    /**
     * Проверяем хранилище на наличие места.
     *
     * @param storehouse - хранилище.
     * @return true - есть место, false - меств нет.
     */
    public boolean checkSizeStorehouse(Storehouse storehouse) {
        if (storehouse.getFoods().size() != storehouse.getStorehouseSize()) {
            return true;
        }
        return false;
    }

    /**
     * Провряем продукт по сроку годности и определяем на какой склад его положить.
     *
     * @param storehouse - склад.
     * @param food       - продукт.
     * @return - true склад подходит, false - склад не подзодит.
     */
    public boolean checkFoodByExpirationDate(Storehouse storehouse, Food food) {
        if (storehouse.checkFood(food, new GregorianCalendar())) {
            return true;
        }
        return false;
    }

    public List<Storehouse> getStorehouses() {
        return storehouses;
    }
}