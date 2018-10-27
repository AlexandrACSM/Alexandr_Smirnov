package ru.job4j.tictactoe.player;

/**
 * @author Aleksandr Smirnov.
 */
public class PlayerUser extends Player {
    private static boolean move = true;
    private static int playerReckoning = 0;
    private static int totalCountWin = 0;

    public PlayerUser(final String playerName, String key) {
        super(playerName, key, playerReckoning, totalCountWin);
    }
}
