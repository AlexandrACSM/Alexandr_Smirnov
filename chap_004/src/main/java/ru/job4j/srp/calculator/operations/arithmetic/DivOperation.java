package ru.job4j.srp.calculator.operations.arithmetic;

import ru.job4j.srp.calculator.operations.Operations;

/**
 * @author Aleksandr Smirnov.
 */
public class DivOperation extends Operations {
    /**
     * Необходимое кол-во атрибутов для операции.
     * true- два атрибута.
     * false - один атрибут.
     */
    private static final boolean QUANTITY_ARGUMENT = true;
    /**
     * Ключь операции.
     */
    private static final String OPERATION_KEY = "/";
    /**
     * Информация по операции.
     */
    private static final String INFO = "Деление - '" + OPERATION_KEY + "'";
    /**
     * Конструктор по умолчанию.
     */
    public DivOperation() {
        super(QUANTITY_ARGUMENT, OPERATION_KEY, INFO);
    }

    @Override
    public double execute(double... argument) {
        return argument[0] / argument[1];
    }
}