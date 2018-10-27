package ru.job4j.tictactoe.output;

/**
 * @author Aleksandr Smirnov.
 */
public class OutputTicTacToeConsole implements OutputTicTacToe {
    @Override
    public void ask(String msg) {
        System.out.println(msg);
    }
}
