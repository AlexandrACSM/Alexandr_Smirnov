package ru.job4j.srp.calculator.output;

import ru.job4j.srp.calculator.operations.Operations;

import java.util.Collection;

/**
 * @author Aleksandr Smirnov.
 */
public class OutputConsole implements Output {

    private String message;

    @Override
    public void writeResult(double result) {
        message = "Result = " + result;
        System.out.println(message);
    }

    @Override
    public void helpInfo(Collection<Operations> list) {
        System.out.println("Программа поддерживает следующие команды:");
        for (Operations operation : list) {
            System.out.println(operation.getInfo());
        }
    }

    public String getMessage() {
        return message;
    }

}
