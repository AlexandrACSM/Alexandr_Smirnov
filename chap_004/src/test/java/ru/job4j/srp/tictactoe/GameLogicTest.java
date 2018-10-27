package ru.job4j.srp.tictactoe;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tictactoe.*;
import ru.job4j.tictactoe.player.Player;
import ru.job4j.tictactoe.player.PlayerUser;

/**
 * @author Aleksandr Smirnov.
 */
public class GameLogicTest {
    private Board board = new Board();
    private GameLogic gameLogic = new GameLogic();

    @Test
    public void botMove() {

    }

    @Test
    public void setStatusCellByCoordinates() {
        Player player = new PlayerUser("Ivan", "X");
        Cell[][] cells = board.fillGameBoard(3);
        Assert.assertFalse(cells[0][0].equals(StatusCell.X));
        int[] coordinates = {1,1};
        gameLogic.setStatusCellByCoordinates(coordinates,player,cells);
        Assert.assertTrue(cells[0][0].getCellStatus().equals(StatusCell.X));
    }


    @Test
    public void checkWinnerInRound() {
        Player player = new PlayerUser("Ivan", "X");
        Cell[][] cells = board.fillGameBoard(3);
        cells[0][0].setCellStatus(StatusCell.X);
        cells[0][1].setCellStatus(StatusCell.X);
        cells[0][2].setCellStatus(StatusCell.X);
        Assert.assertTrue(gameLogic.checkWinnerInRound(cells, player));
        cells[0][0].setCellStatus(StatusCell.O);
        Assert.assertFalse(gameLogic.checkWinnerInRound(cells, player));
        cells[1][0].setCellStatus(StatusCell.X);
        cells[1][1].setCellStatus(StatusCell.X);
        cells[1][2].setCellStatus(StatusCell.X);
        Assert.assertTrue(gameLogic.checkWinnerInRound(cells, player));
        cells[1][1].setCellStatus(StatusCell.O);
        Assert.assertFalse(gameLogic.checkWinnerInRound(cells, player));
        cells[2][0].setCellStatus(StatusCell.X);
        cells[2][1].setCellStatus(StatusCell.X);
        cells[2][2].setCellStatus(StatusCell.X);
        Assert.assertTrue(gameLogic.checkWinnerInRound(cells, player));

        cells = board.fillGameBoard(3);
        cells[0][0].setCellStatus(StatusCell.X);
        cells[1][0].setCellStatus(StatusCell.X);
        cells[2][0].setCellStatus(StatusCell.X);
        Assert.assertTrue(gameLogic.checkWinnerInRound(cells, player));
        cells[0][0].setCellStatus(StatusCell.O);
        Assert.assertFalse(gameLogic.checkWinnerInRound(cells, player));
        cells[0][1].setCellStatus(StatusCell.X);
        cells[1][1].setCellStatus(StatusCell.X);
        cells[2][1].setCellStatus(StatusCell.X);
        Assert.assertTrue(gameLogic.checkWinnerInRound(cells, player));
        cells[1][1].setCellStatus(StatusCell.O);
        Assert.assertFalse(gameLogic.checkWinnerInRound(cells, player));
        cells[0][2].setCellStatus(StatusCell.X);
        cells[1][2].setCellStatus(StatusCell.X);
        cells[2][2].setCellStatus(StatusCell.X);
        Assert.assertTrue(gameLogic.checkWinnerInRound(cells, player));

        cells = board.fillGameBoard(3);
        cells[0][0].setCellStatus(StatusCell.X);
        cells[1][1].setCellStatus(StatusCell.X);
        cells[2][2].setCellStatus(StatusCell.X);
        Assert.assertTrue(gameLogic.checkWinnerInRound(cells, player));
        cells[0][0].setCellStatus(StatusCell.O);
        cells[0][2].setCellStatus(StatusCell.X);
        cells[2][0].setCellStatus(StatusCell.X);
        Assert.assertTrue(gameLogic.checkWinnerInRound(cells, player));

        cells = board.fillGameBoard(3);
        Assert.assertFalse(gameLogic.checkWinnerInRound(cells, player));
        cells = fillArray(cells);
        Assert.assertTrue(gameLogic.checkWinnerInRound(cells, player));

    }

    @Test
    public void winnerMach() {
        Player player = new PlayerUser("David", "X");
        Player player1 = new PlayerUser("Mark", "O");
        Assert.assertFalse(gameLogic.checkWinnerMach(3, 1, player, player1));
        player.setPlayerReckoning(2);
        player.setPlayerReckoning(1);
        Assert.assertTrue(gameLogic.checkWinnerMach(3, 3, player, player1));
    }

    //
//    @Test
//    public void checkWinnerLine() {
//        Cell[][] cells = board.fillGameBoard(3);
//        cells[0][0].setCellStatus(StatusCell.X);
//        cells[0][1].setCellStatus(StatusCell.X);
//        cells[0][2].setCellStatus(StatusCell.X);
//        Assert.assertTrue(gameLogic.checkWinnerLine(cells));
//        cells[0][0].setCellStatus(StatusCell.O);
//        Assert.assertFalse(gameLogic.checkWinnerLine(cells));
//        cells[1][0].setCellStatus(StatusCell.X);
//        cells[1][1].setCellStatus(StatusCell.X);
//        cells[1][2].setCellStatus(StatusCell.X);
//        Assert.assertTrue(gameLogic.checkWinnerLine(cells));
//        cells[1][1].setCellStatus(StatusCell.O);
//        Assert.assertFalse(gameLogic.checkWinnerLine(cells));
//        cells[2][0].setCellStatus(StatusCell.X);
//        cells[2][1].setCellStatus(StatusCell.X);
//        cells[2][2].setCellStatus(StatusCell.X);
//        Assert.assertTrue(gameLogic.checkWinnerLine(cells));
//    }
//
//    @Test
//    public void checkWinnerVerticalLine() {
//        Cell[][] cells = board.fillGameBoard(3);
//        cells[0][0].setCellStatus(StatusCell.X);
//        cells[1][0].setCellStatus(StatusCell.X);
//        cells[2][0].setCellStatus(StatusCell.X);
//        Assert.assertTrue(gameLogic.checkWinnerVerticalLine(cells));
//        cells[0][0].setCellStatus(StatusCell.O);
//        Assert.assertFalse(gameLogic.checkWinnerVerticalLine(cells));
//        cells[0][1].setCellStatus(StatusCell.X);
//        cells[1][1].setCellStatus(StatusCell.X);
//        cells[2][1].setCellStatus(StatusCell.X);
//        Assert.assertTrue(gameLogic.checkWinnerVerticalLine(cells));
//        cells[1][1].setCellStatus(StatusCell.O);
//        Assert.assertFalse(gameLogic.checkWinnerVerticalLine(cells));
//        cells[0][2].setCellStatus(StatusCell.X);
//        cells[1][2].setCellStatus(StatusCell.X);
//        cells[2][2].setCellStatus(StatusCell.X);
//        Assert.assertTrue(gameLogic.checkWinnerVerticalLine(cells));
//
//    }
//
//    @Test
//    public void checkWinnerDiagonalLine() {
//        Cell[][] cells = board.fillGameBoard(3);
//        cells[0][0].setCellStatus(StatusCell.X);
//        cells[1][1].setCellStatus(StatusCell.X);
//        cells[2][2].setCellStatus(StatusCell.X);
//        Assert.assertTrue(gameLogic.checkWinnerDiagonalLine(cells));
//        cells[0][0].setCellStatus(StatusCell.O);
//        cells[0][2].setCellStatus(StatusCell.X);
//        cells[2][0].setCellStatus(StatusCell.X);
//        Assert.assertTrue(gameLogic.checkWinnerDiagonalLine(cells));
//    }
//
//    @Test
//    public void checkTie() {
//        Cell[][] cells = board.fillGameBoard(3);
//        Assert.assertFalse(gameLogic.checkTie(cells));
//        cells = fillArray(cells);
//        Assert.assertTrue(gameLogic.checkTie(cells));
//    }
//
    private Cell[][] fillArray(Cell[][] cells) {
        for (int i = 0; i <= cells.length - 1; i++) {
            for (int j = 0; j <= cells.length - 1; j++) {
                cells[i][j].setCellStatus(StatusCell.X);
            }
        }
        return cells;
    }
}