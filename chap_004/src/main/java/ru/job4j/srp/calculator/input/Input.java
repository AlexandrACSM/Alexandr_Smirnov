package ru.job4j.srp.calculator.input;
import ru.job4j.srp.calculator.operations.Operations;

/**
 * @author Aleksandr Smirnov.
 */
public interface Input {
    double writeArgument();
    Operations writeOperation();
    boolean writeCloseOrContinue();
}
