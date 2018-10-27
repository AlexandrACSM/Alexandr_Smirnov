package ru.job4j;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.figure.Bishop;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Aleksandr Smirnov.
 * @version 1
 * @since 19.02.2017.
 */
public class ChessTest {

    /**
     * Тест добавления игуры на поле.
     */
    @Test
    public void addFigureTest() {
        Board board = new Board();
        final Position position = new Position(7, 7);
        board.addFigure(new Bishop(position, ColorFigure.WHITE, FigureType.BISHOP));
        String testNameFigure = "BISHOP";
        String testColorFigure = "WHITE";
        assertThat(testNameFigure, is(board.getFigure(position).getFigureType().name()));
        assertThat(testColorFigure, is(board.getFigure(position).getColorFigure().name()));
        System.out.println(String.format("Actual %s %s, Expected %s %s", position.getX(), position.getY(),
                board.getFigure(position).getPosition().getX(), board.getFigure(position).getPosition().getY()));
        assertThat(position, is(board.getFigure(position).getPosition()));
    }

    /**
     * Тест удаления фигуры.
     */
    @Test
    public void deleteFigureTest() {
        Board board = new Board();
        final Position position = new Position(3, 3);
        board.addFigure(new Bishop(position, ColorFigure.WHITE, FigureType.BISHOP));
        board.deleteFigure(position);
        Assert.assertNull(board.getFigure(position));
    }

    /**
     * Тест изменения кординат фигуры.
     */
    @Test
    public void editPositionFigureTest() {
        Board board = new Board();
        final Position position = new Position(3, 3);
        final Position testPosition = new Position(4, 4);
        board.addFigure(new Bishop(position, ColorFigure.WHITE, FigureType.BISHOP));
        board.editPositionFigure(board.getFigure(position), testPosition);
        Assert.assertNotNull(board.getFigure(testPosition));
    }

    /**
     * Проверяем правильность хода фигуры.
     */
    @Test
    public void moveTest() {
        Board board = new Board();
        final Position position = new Position(3, 3);
        final Position testPositionFalse = new Position(4, 4);
        final Position testPositionTrue = new Position(3, 5);
        board.addFigure(new Bishop(position, ColorFigure.WHITE, FigureType.BISHOP));
        Assert.assertTrue(board.getFigure(position).move(testPositionTrue));
        Assert.assertFalse(board.getFigure(position).move(testPositionFalse));
    }

    /**
     * Тест провровеки возможности хода по вертикали и горизонтали.
     */
    @Test
    public void pathOnFileOnChessboardAndHorizontalTest() {
        Board board = new Board();
        final Position position = new Position(3, 3);
        final Position positionTwoFirgure = new Position(5, 3);
        final Position testPositionFalse = new Position(6, 3);
        final Position testPositionTrue = new Position(4, 3);
        board.addFigure(new Bishop(position, ColorFigure.WHITE, FigureType.BISHOP));
        board.addFigure(new Bishop(positionTwoFirgure, ColorFigure.WHITE, FigureType.BISHOP));
        Assert.assertFalse(board.pathOnFileOnChessboardAndHorizontal(board.getFigure(position), testPositionFalse));
        Assert.assertTrue(board.pathOnFileOnChessboardAndHorizontal(board.getFigure(position), testPositionTrue));
    }
}
