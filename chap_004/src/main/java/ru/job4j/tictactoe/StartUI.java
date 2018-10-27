package ru.job4j.tictactoe;

import ru.job4j.tictactoe.input.InputConsole;
import ru.job4j.tictactoe.input.InputCoordinatesConsole;
import ru.job4j.tictactoe.input.InputIntValueConsole;
import ru.job4j.tictactoe.output.OutputTicTacToeConsole;
import ru.job4j.tictactoe.player.PlayersFactory;

/**
 * @author Aleksandr Smirnov.
 */
public class StartUI {



    public static void main(String[] args) {
        ProcessGame processGame = new ProcessGame(new InputCoordinatesConsole(), new Board(), new GameLogic(),
                new InputIntValueConsole(), new PlayersFactory(), new OutputTicTacToeConsole(), new InputConsole());
        processGame.playGame();
    }
}
