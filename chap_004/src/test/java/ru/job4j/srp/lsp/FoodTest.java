package ru.job4j.srp.lsp;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.lsp.food.Food;
import ru.job4j.lsp.food.Milk;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Aleksandr Smirnov.
 */
public class FoodTest {
    Calendar calendar = new GregorianCalendar();
    Food food = new Milk(new GregorianCalendar(2017, 3, 29));


    @Test
    public void getPercentByTime() {
        food.getExpiryDate();
        double oneAttribute = food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        double twoAttribute = calendar.getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        int expectedResult = (int) ((twoAttribute / oneAttribute) * 100);
        int actualResult = food.getPercentByTime();
        Assert.assertTrue(expectedResult == actualResult);
    }

    @Test
    public void getExpiryDate() {
        Calendar actualResult = food.getExpiryDate();
        int expiryDateInDay = food.getExpiryDateInDay();
        Calendar calendar = (Calendar) food.getCreateDate().clone();
        calendar.add(Calendar.DAY_OF_YEAR,expiryDateInDay);
        Assert.assertTrue(actualResult.equals(calendar));
    }

}
