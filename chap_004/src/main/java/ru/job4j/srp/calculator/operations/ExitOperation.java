package ru.job4j.srp.calculator.operations;

/**
 * @author Aleksandr Smirnov.
 */
public class ExitOperation extends Operations {

    private static final boolean QUANTITY_ARGUMENT = true;
    private static final String OPERATION_KEY = "exit";
    private static final String INFO = "Выход - '" + OPERATION_KEY + "' " + "выход из программы.";

    public ExitOperation() {
        super(QUANTITY_ARGUMENT, OPERATION_KEY, INFO);
    }

    @Override
    public double execute(double... argument) {
        return 0;
    }
}
