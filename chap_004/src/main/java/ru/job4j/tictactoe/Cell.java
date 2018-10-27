package ru.job4j.tictactoe;

/**
 * Класс ячейки.
 * @author Aleksandr Smirnov.
 */
public class Cell {
    /**
     * Статус ячейки.
     */
    private StatusCell cellStatus;

    /**
     * Конструктор по умолчанию.
     */
    public Cell() {
    }

    public StatusCell getCellStatus() {
        return cellStatus;
    }

    public void setCellStatus(StatusCell cellStatus) {
        this.cellStatus = cellStatus;
    }

    @Override
    public String toString() {
        if (cellStatus == StatusCell.O) {
            return "[O]";
        } else if (cellStatus == StatusCell.X) {
            return "[X]";
        }
        return "[ ]";
    }
}
