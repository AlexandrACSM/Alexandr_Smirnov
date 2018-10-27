package ru.job4j.tictactoe;

/**
 * Класс отвечает за вывод графики в консоль.
 * @author Aleksandr Smirnov.
 */
public class UI {
    /**
     * Метод выводит графическое отображение игры.
     * @param board - игровое поле.
     */
    public static void printBoard(Cell[][] board) {
        System.out.print("   ");
        for (int i = 0; i < board.length; i++) {
            System.out.print(String.format("%s%s", i+1, "  "));
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print(String.format("%s%s", i+1, " "));
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j].toString());
            }
            System.out.println();
        }
    }
}
