package ru.job4j.srp.lsp;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.lsp.*;
import ru.job4j.lsp.food.Curd;
import ru.job4j.lsp.food.Food;
import ru.job4j.lsp.food.Milk;

import java.util.*;

/**
 * @author Aleksandr Smirnov.
 */
public class ControlQualityTest {
    private final ControlQuality controlQuality = new ControlQuality();
    private Food food = new Milk(new GregorianCalendar());
    private Food food1 = new Milk(new GregorianCalendar(2017, Calendar.APRIL, 3));
    private Food food2 = new Curd(new GregorianCalendar(2017, Calendar.APRIL, 3));
    private Food food3 = new Milk(new GregorianCalendar(2017, Calendar.APRIL, 1));
    private Food food4 = new Milk(new GregorianCalendar(2017, Calendar.APRIL, 2));
    private Storehouse store = new Warehouse("WarehouseTest", 2);
    private Storehouse store1 = new Trash("TrashTest", 2);
    private Storehouse store2 = new Trash("TrashTwoTest", 2);
    private Storehouse store3 = new Shop("ShopTest", 2);
    private Storehouse store4 = new FoodProcessing("FoodProcessingTest", 2);

    @Test
    public void resort() {
        createStorehouseAndAddFood();
        Assert.assertEquals(controlQuality.getStorehouses().get(0).getFoods().size(), 1);
        controlQuality.getStorehouses().get(1).getFoods().get(0).setCreateDate(
                new GregorianCalendar());
        controlQuality.getStorehouses().get(1).getFoods().get(0).getExpiryDate();
        Food food = controlQuality.getStorehouses().get(1).getFoods().get(0);
        controlQuality.resort();
        Assert.assertEquals(controlQuality.getStorehouses().get(0).getFoods().size(), 2);
        Assert.assertEquals(controlQuality.getStorehouses().get(0).getFoods().get(1), food);
    }

    /**
     * Метод бегает по хранилищам, дергает продукты и сохранет их в коллекци.
     */
    @Test
    public void getFoodsList() {
        createStorehouseAndAddFood();
        List<Food> foods = controlQuality.getFoodsList(controlQuality.getStorehouses());
        final int expectedSize = 4;
        Assert.assertEquals(foods.size(), expectedSize);
    }

    /**
     * Метод удаляет все элементы со всех хранилищ.
     */
    @Test
    public void removeFoodsList() {
        createStorehouseAndAddFood();
        controlQuality.removeFoodsList();
        for (Storehouse storehouse : controlQuality.getStorehouses()) {
            Assert.assertTrue(storehouse.getFoods().isEmpty());
        }
    }

    /**
     * Метод добавляет продукты на склад по сроку годности с учетом кол-ва мест на складе.
     */
    @Test
    public void sortFoods() {
        addStorehouses();
        controlQuality.sortFoods(createFoodList());
        Assert.assertEquals(controlQuality.getStorehouses().get(0).getFoods().get(0), food);
        Assert.assertTrue(controlQuality.getStorehouses().get(1).getFoods().contains(food1));
        Assert.assertTrue(controlQuality.getStorehouses().get(1).getFoods().contains(food3));
        Assert.assertTrue(controlQuality.getStorehouses().get(2).getFoods().contains(food4));
        Assert.assertTrue(controlQuality.getStorehouses().get(4).getFoods().contains(food2));
    }

    /**
     * Метод определяет на какой склад направить продукт.
     */
    @Test
    public void addFoodOnStorehouse() {
        addExpiryDate();
        addStorehouses();
        controlQuality.addFoodOnStorehouse(food);
        controlQuality.addFoodOnStorehouse(food1);
        controlQuality.addFoodOnStorehouse(food2);
        controlQuality.addFoodOnStorehouse(food3);
        controlQuality.addFoodOnStorehouse(food4);
        Assert.assertTrue(controlQuality.getStorehouses().get(0).getFoods().contains(food));
        Assert.assertTrue(controlQuality.getStorehouses().get(1).getFoods().contains(food1));
        Assert.assertTrue(controlQuality.getStorehouses().get(1).getFoods().contains(food3));
        Assert.assertTrue(controlQuality.getStorehouses().get(4).getFoods().contains(food2));
    }

    /**
     * Проверяем хранилище на наличие места.
     */
    @Test
    public void checkSizeStorehouse() {
        Food food = new Milk(new GregorianCalendar());
        food.getExpiryDate();
        Storehouse store = new Warehouse("WarehouseTest", 2);
        controlQuality.getStorehouses().add(store);
        controlQuality.addFoodOnStorehouse(food);
        Assert.assertTrue(controlQuality.checkSizeStorehouse(controlQuality.getStorehouses().get(0)));
        Food food1 = new Milk(new GregorianCalendar());
        food1.getExpiryDate();
        controlQuality.addFoodOnStorehouse(food1);
        Assert.assertFalse(controlQuality.checkSizeStorehouse(controlQuality.getStorehouses().get(0)));
    }

    /**
     * Провряем продукт по сроку годности и определяем на какой склад его положить.
     */
    @Test
    public void checkFoodByExpirationDate() {
        Food food = new Milk(new GregorianCalendar(2017, Calendar.APRIL, 31));
        food.getExpiryDate();
        Storehouse store = new Warehouse("WarehouseTest", 2);
        controlQuality.getStorehouses().add(store);
        controlQuality.addFoodOnStorehouse(food);
        Assert.assertTrue(controlQuality.checkFoodByExpirationDate(controlQuality.getStorehouses().get(0), food));
        controlQuality.getStorehouses().remove(store);
        store = new Trash("TrashTest", 2);
        controlQuality.getStorehouses().add(store);
        controlQuality.addFoodOnStorehouse(food);
        Assert.assertFalse(controlQuality.checkFoodByExpirationDate(controlQuality.getStorehouses().get(0), food));
        controlQuality.getStorehouses().remove(store);
        store = new Shop("ShopTest", 2);
        controlQuality.getStorehouses().add(store);
        controlQuality.addFoodOnStorehouse(food);
        Assert.assertFalse(controlQuality.checkFoodByExpirationDate(controlQuality.getStorehouses().get(0), food));
        controlQuality.getStorehouses().remove(store);
        store = new FoodProcessing("FoodProcessingTest", 2);
        controlQuality.getStorehouses().add(store);
        controlQuality.addFoodOnStorehouse(food);
        Assert.assertFalse(controlQuality.checkFoodByExpirationDate(controlQuality.getStorehouses().get(0), food));
    }


    private void createStorehouseAndAddFood() {
        addStorehouses();
        addExpiryDate();
        controlQuality.addFoodOnStorehouse(food);
        controlQuality.addFoodOnStorehouse(food1);
        controlQuality.addFoodOnStorehouse(food2);
        controlQuality.addFoodOnStorehouse(food3);
    }

    private void addStorehouses() {
        controlQuality.getStorehouses().add(store);
        controlQuality.getStorehouses().add(store1);
        controlQuality.getStorehouses().add(store2);
        controlQuality.getStorehouses().add(store3);
        controlQuality.getStorehouses().add(store4);
    }

    private void addExpiryDate() {
        food.getExpiryDate();
        food1.getExpiryDate();
        food2.getExpiryDate();
        food3.getExpiryDate();
        food4.getExpiryDate();
    }

    private List<Food> createFoodList() {
        List<Food> foods = new ArrayList<>();
        addExpiryDate();
        foods.add(food);
        foods.add(food1);
        foods.add(food2);
        foods.add(food3);
        foods.add(food4);
        return foods;
    }
}