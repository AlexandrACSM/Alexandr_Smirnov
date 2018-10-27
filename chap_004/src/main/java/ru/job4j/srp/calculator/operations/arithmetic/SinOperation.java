package ru.job4j.srp.calculator.operations.arithmetic;

import ru.job4j.srp.calculator.operations.Operations;

/**
 * @author Aleksandr Smirnov.
 */
public class SinOperation extends Operations {
    /**
     * Необходимое кол-во атрибутов для операции.
     * true- два атрибута.
     * false - один атрибут.
     */
    private static final boolean QUANTITY_ARGUMENT = false;
    /**
     * Ключь операции.
     */
    private static final String OPERATION_KEY = "sin";
    /**
     * Информация по операции.
     */
    private static final String INFO = "Синус - '" + OPERATION_KEY + "'";
    /**
     * Конструктор по умолчанию.
     */
    public SinOperation() {
        super(QUANTITY_ARGUMENT, OPERATION_KEY, INFO);
    }

    @Override
    public double execute(double... argument) {
        return Math.sin(argument[0]);
    }
}
