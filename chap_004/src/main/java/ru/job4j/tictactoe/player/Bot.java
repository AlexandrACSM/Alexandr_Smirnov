package ru.job4j.tictactoe.player;

/**
 * @author Aleksandr Smirnov.
 */
public class Bot extends Player {
    /**
     * Имя.
     */
    private final static String NAME = "BOT";
    /**
     * Поле хранит кол-во побед игрока в игре.
     */
    private static int playerReckoning = 0;
    /**
     * Общее кол-во побед игрока.
     */
    private static int totalCountWin = 0;

    /**
     * Конструктор по умолчанию.
     * @param key - ключ игрока.
     */
    public Bot(String key) {
        super(NAME, key, playerReckoning, totalCountWin);
    }
}