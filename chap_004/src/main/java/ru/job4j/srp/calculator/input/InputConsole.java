package ru.job4j.srp.calculator.input;

import ru.job4j.srp.calculator.operations.Operations;
import ru.job4j.srp.calculator.operations.OperationsFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Aleksandr Smirnov.
 */
public class InputConsole implements Input {
    /**
     * Ключ продолжения.
     */
    private static final String CONTINUE_KEY = "y";
    /**
     * Ключ выхода.
     */
    private static final String END_KEY = "n";
    /**
     * Сообщение перед вводом числа.
     */
    private static final String ENTER_NUMBER = "Enter number ";
    /**
     * Сообщение перед вводом операции.
     */
    private static final String ENTER_OPERATION = "Enter operation ";
    /**
     * Сообщение при некорректном вводе.
     */
    private static final String INCOMPLETE_INPUT = "Incomplete input";
    /**
     * Используем Scanner  для получения данных.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Метод ввода аргумента.
     *
     * @return - double number.
     */
    @Override
    public double writeArgument() {
        double result = 0.0;
        try {
            System.out.printf(ENTER_NUMBER);
            result = Double.valueOf(scanner.next().trim());
        } catch (NumberFormatException nfe) {
            System.out.println(INCOMPLETE_INPUT);
            writeArgument();
        }
        return result;
    }

    /**
     * Метод для ввода операции.
     *
     * @return - operation.
     */
    @Override
    public Operations writeOperation() {
        OperationsFactory operationsFactory = new OperationsFactory();
        Operations operation = null;
        while (operation == null) {
            System.out.print(ENTER_OPERATION);
            operation = operationsFactory.getOperation(scanner.next().trim());
            if (operation == null) {
                System.out.println(INCOMPLETE_INPUT);
            }
        }
        return operation;
    }

    /**
     * Метод выбора действия.
     *
     * @return true - для продожения, false - закрыть программу.
     */
    @Override
    public boolean writeCloseOrContinue() {
        String selectionOfAction;
        do {
            System.out.println("Желаете продолжить: y/n");
            selectionOfAction = scanner.next().trim();
            if (selectionOfAction.equals(END_KEY)) {
                return false;
            } else if (selectionOfAction.equals(CONTINUE_KEY)) {
                return true;
            }
            System.out.println(INCOMPLETE_INPUT);
        } while (!selectionOfAction.equals(END_KEY) || !selectionOfAction.equals(CONTINUE_KEY));
        return false;
    }
}
