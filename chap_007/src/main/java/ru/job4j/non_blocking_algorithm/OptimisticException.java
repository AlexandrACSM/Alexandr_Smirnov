package ru.job4j.non_blocking_algorithm;

public class OptimisticException extends RuntimeException {

    OptimisticException(String msg) {
        super(msg);
    }
}
