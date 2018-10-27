package ru.job4j.tictactoe.player;

/**
 * Класс хранит игроков.
 * @author Aleksandr Smirnov.
 */
public class PlayersFactory {
    /**
     * Переключатель игроков.
     */
    private int playerSwitch = 1;
    /**
     * Массив игроков.
     */
    private Player[] playersArray;

    /**
     * Метод получения игрока.
     * @return - игрок.
     */
    public Player getPlayer() {
            if (playerSwitch % 2 == 0) {
                playerSwitch++;
                return playersArray[1];
            }
            playerSwitch++;
            return playersArray[0];
    }

    /**
     * Метод добовляет игроков в массив.
     *
     * @param positionPlayer - если  = 1, то Player ходит первым.
     */
    public void addArrayPlayer(int positionPlayer) {
        if (positionPlayer == 1) {
            playersArray = new Player[]{
                    new PlayerUser("Player", "X"),
                    new Bot("O"),
            };
        }else {
            playersArray = new Player[]{
                    new Bot("X"),
                    new PlayerUser("Player", "O"),
            };
        }
    }

    /**
     * Метод переставляет игроков после и меняет их playerKey.
     */
    public void reversStatusCellAtPlayers() {
        Player temp;
        if (playersArray[0].getPlayerKey().equals("X")) {
            temp = playersArray[0];
            playersArray[0] = playersArray[1];
            playersArray[1] = temp;
            playersArray[0].setPlayerKey("X");
            playersArray[1].setPlayerKey("O");
        }
    }

    public Player[] getPlayersArray() {
        return playersArray;
    }

    public void setPlayerSwitch() {
        this.playerSwitch = 1;
    }

    public int getPlayerSwitch() {
        return playerSwitch;
    }
}

