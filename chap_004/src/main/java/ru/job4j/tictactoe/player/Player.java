package ru.job4j.tictactoe.player;

/**
 * Абстрактный класс игрока.
 * @author Aleksandr Smirnov.
 */
public abstract class Player {
    /**
     * Имя игрока.
     */
    private String playerName;
    /**
     * Поле статуса игрока 'X' или 'O'.
     */
    private String playerKey;
    /**
     * Поле хранит кол-во побед в матче.
     */
    private int playerReckoning;
    /**
     * Общее кол-во побед игрока.
     */
    private int totalCountWin;


    public Player(String playerName, String playerKey, int playerReckoning, int totalCountWin) {
        this.playerName = playerName;
        this.playerKey = playerKey;
        this.playerReckoning = playerReckoning;
        this.totalCountWin = totalCountWin;
    }

    public Player() {
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerReckoning() {
        return playerReckoning;
    }

    public String getPlayerKey() {
        return playerKey;
    }


    public void setPlayerKey(String playerKey) {
        this.playerKey = playerKey;
    }

    public void setPlayerReckoning(int playerReckoning) {
        this.playerReckoning = playerReckoning;
    }

    public void upPlayerReckoning() {
        this.playerReckoning++;
    }

    public int getTotalCountWin() {
        return totalCountWin;
    }

    public void setTotalCountWin() {
        this.totalCountWin++;
    }
}
