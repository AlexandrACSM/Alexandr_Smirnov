package ru.job4j.srp.calculator;

import ru.job4j.srp.calculator.input.InputConsole;
import ru.job4j.srp.calculator.operations.OperationsFactory;
import ru.job4j.srp.calculator.output.OutputConsole;

/**
 * Класс запускающий программу Клькулятор.
 * @author Aleksandr Smirnov.
 */
public class Start {
    public static void main(String[] args) {
        InteractCalc interactCalc = new InteractCalc(new OutputConsole(),new InputConsole(),new OperationsFactory());
        interactCalc.start();
    }
}
