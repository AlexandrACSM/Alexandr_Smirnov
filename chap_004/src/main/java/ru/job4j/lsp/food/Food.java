package ru.job4j.lsp.food;


import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Абстрактный класс продукта.
 * @author Aleksandr Smirnov.
 */
public abstract class Food {
    /**
     * Имя продукта.
     */
    private String name;
    /**
     * Дата изготовленя.
     */
    private Calendar createDate;
    /**
     * Дата окончания срока годности.
     */
    private Calendar expiryDate;
    /**
     * Срок годности в днях.
     */
    private int expiryDateInDay;
    /**
     * Стоимость продукта.
     */
    private double price;
    /**
     * Скидка на уценненый продукт(25%).
     */
    private static final double discount = 0.75;
    private final boolean canReproduct;
    /**
     * Конструктор по умолчанию.
     * @param name - название.
     * @param createDate - дата изготовленя.
     * @param expiryDate - дата окончания срока годности.
     * @param expiryDateInDay - срок годности в днях.
     * @param price - стоимость.
     * @param canReproduct
     */
    public Food(String name, Calendar createDate, Calendar expiryDate, int expiryDateInDay, double price, boolean canReproduct) {
        this.name = name;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.expiryDate = expiryDate;
        this.expiryDateInDay = expiryDateInDay;
        this.price = price;
        this.canReproduct = canReproduct;
    }

    /**
     * Метод вычисляет истёкший срок годности, 0 - начало, 100 - конец.
     * @return
     */
    public int getPercentByTime() {
        Calendar calendar = new GregorianCalendar();
        double oneAttribute = expiryDate.getTimeInMillis() - createDate.getTimeInMillis();
        double twoAttribute = calendar.getTimeInMillis() - createDate.getTimeInMillis();
        double percent = (twoAttribute / oneAttribute) * 100;
        return (int) percent;
    }

    /**
     * Метод вычисляет дату окончания срока годности.
     * @return
     */
    public Calendar getExpiryDate() {
        expiryDate = (Calendar) createDate.clone();
        expiryDate.add(Calendar.DAY_OF_YEAR, expiryDateInDay);
        return expiryDate;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpiryDate(Calendar expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getExpiryDateInDay() {
        return expiryDateInDay;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public boolean isCanReproduct() {
        return canReproduct;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", createDate=" + createDate.getTime() +
                ", expiryDate=" + expiryDate.getTime() +
                ", price=" + price +
                '}'+"\n"+"\t" + getPercentByTime();
    }

}