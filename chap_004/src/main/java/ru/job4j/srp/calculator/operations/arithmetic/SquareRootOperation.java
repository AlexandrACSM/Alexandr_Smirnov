package ru.job4j.srp.calculator.operations.arithmetic;

import ru.job4j.srp.calculator.operations.Operations;

/**
 * @author Aleksandr Smirnov.
 */
public class SquareRootOperation extends Operations {
    /**
     * Необходимое кол-во атрибутов для операции.
     * true- два атрибута.
     * false - один атрибут.
     */
    private static final boolean QUANTITY_ARGUMENT = false;
    /**
     * Ключь операции.
     */
    private static final String OPERATION_KEY = "cbrt";
    /**
     * Информация по операции.
     */
    private static final String INFO = "Квадратный корень - '" + OPERATION_KEY + "'";
    /**
     * Конструктор по умолчанию.
     */
    public SquareRootOperation() {
        super(QUANTITY_ARGUMENT, OPERATION_KEY, INFO);
    }

    @Override
    public double execute(double... argument) {
        return Math.cbrt(argument[0]);
    }

}
