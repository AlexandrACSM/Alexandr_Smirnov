package ru.job4j.tictactoe.input;

import ru.job4j.tictactoe.Cell;
import ru.job4j.tictactoe.CoordinatesExeption;
import ru.job4j.tictactoe.StatusCell;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Aleksandr Smirnov.
 */
public class InputCoordinatesConsole implements InputCoordinates {

    @Override
    public int[] writeCoordinates() {
        Scanner scanner = new Scanner(System.in);
        int[] coordinates = new int[2];
        coordinates[0] = scanner.nextInt();
        coordinates[1] = scanner.nextInt();
        return coordinates;
    }

    @Override
    public int[] writeCoordinates(Cell[][] cells) {
        boolean flag = true;
        int[] coordinates = new int[0];
        do {
            try {
                coordinates = this.writeCoordinates();
                if (cells[coordinates[0] - 1][coordinates[1] - 1].getCellStatus().equals(StatusCell.EMPTY)) {
                    flag = false;
                } else {
                    System.out.println("this cell not empty ");
                }
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException ex) {
                System.out.println("Incorrect input ");
            }
        } while (flag);
        return coordinates;
    }


}



