package ru.job4j.srp;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.srp.calculator.operations.Operations;
import ru.job4j.srp.calculator.operations.OperationsFactory;

/**
 * @author Aleksandr Smirnov.
 */
public class InteractCalcTest {
    private static final String ADD_OPERATION_KEY = "+";
    private static final String SUB_OPERATION_KEY = "-";
    private static final String MULTIPLY_OPERATION_KEY = "*";
    private static final String DIV_OPERATION_KEY = "/";


    @Test
    public void execute() {
        final double zero = 0;
        final double one = 1;
        final double two = 2;
        final double tree = 3;
        final double four = 4;

        OperationsFactory operationsFactory = new OperationsFactory();
        //Тест сложения.
        Operations operations = operationsFactory.getOperation(ADD_OPERATION_KEY);
        double result = operations.execute(two, one);
        Assert.assertTrue(tree == result);
        //Тест вычитания.
        operations = operationsFactory.getOperation(SUB_OPERATION_KEY);
        result = operations.execute(tree, one);
        Assert.assertTrue(two == result);
        //Тест умножения.
        operations = operationsFactory.getOperation(MULTIPLY_OPERATION_KEY);
        result = operations.execute(tree, one);
        Assert.assertTrue(tree == result);
        //Тест деления.
        operations = operationsFactory.getOperation(DIV_OPERATION_KEY);
        result = operations.execute(four, two);
        Assert.assertTrue(two == result);
    }

    /**
     * Тест получения операции по ключу.
     */
    @Test
    public void getOperation() {
        final String operationName = "+";
        OperationsFactory operationsFactory = new OperationsFactory();
        Operations operations = operationsFactory.getOperation(operationName);
        Assert.assertEquals(operationName,operations.getKey());
    }

}
