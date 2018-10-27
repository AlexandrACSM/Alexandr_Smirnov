package ru.job4j.srp.calculator.output;

import ru.job4j.srp.calculator.operations.Operations;

import java.util.Collection;

/**
 * @author Aleksandr Smirnov.
 */
public interface Output {
    void writeResult(double result);
    void helpInfo(Collection<Operations> list);
    String getMessage();
}
