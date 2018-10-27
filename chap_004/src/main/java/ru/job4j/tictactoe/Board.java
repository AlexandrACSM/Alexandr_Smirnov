package ru.job4j.tictactoe;

/**
 * Класс игрового поля.
 *
 * @author Aleksandr Smirnov.
 */
public class Board {
    /**
     * Массив ячеек.
     */
    private Cell[][] cells;
    private int cellSSize = 3;

    /**
     * Метод формирует игровое поле и устанавливает в ячейки статус EMPTY.
     *
     * @param cellSize - размер поля.
     * @return - массив.
     */
    public Cell[][] fillGameBoard(int cellSize) {
        cells = new Cell[cellSize][cellSize];
        for (int i = 0; i < cellSize; i++) {
            for (int j = 0; j < cellSize; j++) {
                cells[i][j] = new Cell();
                cells[i][j].setCellStatus(StatusCell.EMPTY);
            }
        }
        return cells;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getCellSSize() {
        return cellSSize;
    }

    public void setCellSSize(int cellSSize) {
        this.cellSSize = cellSSize;
    }
}