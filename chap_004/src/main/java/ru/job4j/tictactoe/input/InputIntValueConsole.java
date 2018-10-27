package ru.job4j.tictactoe.input;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Aleksandr Smirnov.
 */
public class InputIntValueConsole implements InputIntValue {

    @Override
    public int writeValue() {

        int value = 1;
        boolean flag = true;
        while (flag) {
            try {
                value = new Scanner(System.in).nextInt();
                flag = false;
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input");
            }
        }
        return value;
    }


}
