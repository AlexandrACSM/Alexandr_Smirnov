package ru.job4j.synchronizy.input;

import java.util.Scanner;

public class ConcoleUserStoreInputController implements UserStoreInputController {

    @Override
    public int inputAmount() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
