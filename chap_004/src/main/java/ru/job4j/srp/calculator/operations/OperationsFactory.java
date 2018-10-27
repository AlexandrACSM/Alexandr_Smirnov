package ru.job4j.srp.calculator.operations;

import ru.job4j.srp.calculator.operations.arithmetic.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Aleksandr Smirnov.
 */
public class OperationsFactory {
    /**
     * Массив операциий.
     */
    private List<Operations> operations = new ArrayList<>();

    {
        operations.add(new AddOperation());
        operations.add(new MultiplyOperation());
        operations.add(new SinOperation());
        operations.add(new DivOperation());
        operations.add(new SquareRootOperation());
        operations.add(new PowOperation());
        operations.add(new SubOperation());
        operations.add(new EquallyOperation());
        operations.add(new ExitOperation());
    }

    /**
     * Метод получения операции.
     *
     * @param operationName - ключь операции.
     * @return operation - операция.
     */
    public Operations getOperation(String operationName) {
        for (Operations operation : operations) {
            if (operationName.equals(operation.getKey())) {
                return operation;
            }
        }
        return operations.get(0);
    }

    /**
     * Метод возвращает массив операций.
     *
     * @return - массив операций.
     */
    public Collection<Operations> getOperationsArray() {
        return operations;
    }
}
