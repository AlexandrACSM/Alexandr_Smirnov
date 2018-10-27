package ru.job4j.tictactoe;


import ru.job4j.tictactoe.player.Player;


/**
 * Класс отвечает за определения победителя и ходы игроков.
 *
 * @author Aleksandr Smirnov.
 */
public class GameLogic {
    /**
     * Сообщение.
     */
    private String msg;

    /**
     * Метод отвечает за ход бота.
     *
     * @param cells - игровое поле.
     * @return - координаты ячейки.
     */
    public int[] botMove(Cell[][] cells) {
        int[] coordinates = new int[2];
        boolean flag = true;
        while (flag) {
            coordinates[0] = 1 + (int) (Math.random() * cells.length);
            coordinates[1] = 1 + (int) (Math.random() * cells.length);
            if (cells[coordinates[0] - 1][coordinates[1] - 1].getCellStatus().equals(StatusCell.EMPTY)) {
                flag = false;
            }
        }
        return coordinates;
    }

    /**
     * Метод определяет ячейку для изменения.
     *
     * @param coordinates
     * @param player
     * @param cells
     */
    public void setStatusCellByCoordinates(int[] coordinates, Player player, Cell[][] cells) {
        setStatusCell(player, cells[coordinates[0] - 1][coordinates[1] - 1]);
    }

    /**
     * Метод изменяет ячейку.
     *
     * @param player - игрок.
     * @param cell   - ячейка.
     */
    private void setStatusCell(Player player, Cell cell) {
        if (player.getPlayerKey().equals(String.valueOf(StatusCell.X))) {
            cell.setCellStatus(StatusCell.X);
        } else if (player.getPlayerKey().equals(String.valueOf(StatusCell.O))) {
            cell.setCellStatus(StatusCell.O);
        }
    }

    /**
     * Метод определяет победителя в раунде.
     *
     * @param cells  - игровое поле.
     * @param player - игрок.
     * @return - true - есть победитель, false - нет победителя.
     */
    public boolean checkWinnerInRound(Cell[][] cells, Player player) {
        if (checkWinnerDiagonalLine(cells)) {
            msg = String.format("%s%s", "Победил ", player.getPlayerKey());
            return true;
        } else if (checkWinnerVerticalLine(cells)) {
            msg = String.format("%s%s", "Победил ", player.getPlayerKey());
            return true;
        } else if (checkWinnerLine(cells)) {
            msg = String.format("%s%s", "Победил ", player.getPlayerKey());
            return true;
        } else if (checkTie(cells)) {
            msg = String.format("%s", "Ничья ");
            return true;
        }
        return false;
    }

    /**
     * Метод определяет победителя в матче.
     *
     * @param countRound - число раундов.
     * @param round      - сколько раундов сыграно.
     * @param player     - игрок.
     * @param player1    игрок.
     * @return - true - есть победитель, false - нет победителя.
     */
    public boolean checkWinnerMach(int countRound, int round, Player player, Player player1) {
        if (countRound == round) {
            if (player.getPlayerReckoning() > player1.getPlayerReckoning()) {
                msg = String.format("%s%s", "Победу в игре одержал ", player.getPlayerName());
            } else if (player.getPlayerReckoning() < player1.getPlayerReckoning()) {
                msg = String.format("%s%s", "Победу в игре одержал ", player1.getPlayerName());
            } else if (player.getPlayerReckoning() == player1.getPlayerReckoning()) {
                msg = String.format("%s", "Ничья");
            }
            return true;
        }
        return false;
    }

    /**
     * Метод проверяет горизонталь.
     *
     * @param cells - игровое поле.
     * @return - true - есть победитель, false - нет победителя.
     */
    private boolean checkWinnerLine(Cell[][] cells) {
        int checkLine = 0;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length - 1; j++) {
                if (cells[i][j].getCellStatus() != StatusCell.EMPTY &&
                        cells[i][j].getCellStatus().equals(cells[i][j + 1].getCellStatus())) {
                    checkLine++;
                    if (checkLine == 2) {
                        return true;
                    }
                }
            }
            checkLine = 0;
        }
        return false;
    }

    /**
     * Метод проверяет вертикаль.
     *
     * @param cells - игровое поле.
     * @return - true - есть победитель, false - нет победителя.
     */
    private boolean checkWinnerVerticalLine(Cell[][] cells) {
        int checkLine = 0;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length - 1; j++) {
                if (cells[j][i].getCellStatus() != StatusCell.EMPTY &&
                        cells[j][i].getCellStatus().equals(cells[j + 1][i].getCellStatus())) {
                    checkLine++;
                    if (checkLine == 2) {
                        return true;
                    }
                }
            }
            checkLine = 0;
        }
        return false;
    }

    /**
     * Метод проверяет диагональ.
     *
     * @param cells - игровое поле.
     * @return - true - есть победитель, false - нет победителя.
     */
    private boolean checkWinnerDiagonalLine(Cell[][] cells) {
        int checkLine = 0;
        for (int i = 0; i < cells.length - 1; i++) {
            int j = i;
            if (cells[i][j].getCellStatus() != StatusCell.EMPTY &&
                    cells[i][j].getCellStatus().equals(cells[i + 1][j + 1].getCellStatus())) {
                checkLine++;
                if (checkLine == 2) {
                    return true;
                }
            }
        }
        checkLine = 0;
        int j = 0;
        for (int i = cells.length - 1; i > 0; i--) {
            if (cells[i][j].getCellStatus() != StatusCell.EMPTY &&
                    cells[i][j].getCellStatus().equals(cells[i - 1][j + 1].getCellStatus())) {
                checkLine++;
                if (checkLine == cells.length - 1) {
                    return true;
                }
            }
            j++;
        }
        return false;
    }

    /**
     * Метод определят ничью.
     *
     * @param cells - игровое поле.
     * @return - true - ничья.
     */
    private boolean checkTie(Cell[][] cells) {
        int checkTieValue = 0;
        for (int i = 0; i <= cells.length - 1; i++) {
            for (int j = 0; j <= cells.length - 1; j++) {
                if (!cells[i][j].getCellStatus().equals(StatusCell.EMPTY)) {
                    checkTieValue++;
                    if (checkTieValue == ((cells.length) * (cells.length))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkInputY(String command) {
        return command.equals("y") ? true : false;
    }

    public String getMsg() {
        return msg;
    }
}