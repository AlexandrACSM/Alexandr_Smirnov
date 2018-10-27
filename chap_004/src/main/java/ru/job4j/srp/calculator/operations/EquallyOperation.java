package ru.job4j.srp.calculator.operations;

/**
 * @author Aleksandr Smirnov.
 */
public class EquallyOperation extends Operations{
    /**
     * Требуемое кол-во атрибутов для операции.
     * true- два атрибута.
     * false - один атрибут.
     */
    private static final boolean QUANTITY_ARGUMENT = true;
    /**
     * Ключь операции.
     */
    private static final String OPERATION_KEY = "=";
    /**
     * Информация по операции.
     */
    private static final String INFO = "Равно - '" + OPERATION_KEY + "' " + "выводит резудьтат операции.";
    /**
     * Конструктор по умолчанию.
     */
    public EquallyOperation() {
        super(QUANTITY_ARGUMENT, OPERATION_KEY,INFO);
    }

    @Override
    public double execute(double... argument) {
        return 0;
    }
}
