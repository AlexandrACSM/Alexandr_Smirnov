package ru.job4j.tictactoe.input;

import ru.job4j.tictactoe.Cell;
import ru.job4j.tictactoe.CoordinatesExeption;

/**
 * @author Aleksandr Smirnov.
 */
public interface InputCoordinates {
    int[] writeCoordinates();

    int[] writeCoordinates(Cell[][] cells);
}
