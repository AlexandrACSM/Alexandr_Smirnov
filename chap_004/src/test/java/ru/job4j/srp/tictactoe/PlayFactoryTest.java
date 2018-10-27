package ru.job4j.srp.tictactoe;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tictactoe.StatusCell;
import ru.job4j.tictactoe.player.Player;
import ru.job4j.tictactoe.player.PlayersFactory;

/**
 * @author Aleksandr Smirnov.
 */
public class PlayFactoryTest {
    private PlayersFactory playersFactory = new PlayersFactory();

    @Test
    public void getPlayer() {
        playersFactory.addArrayPlayer(1);
        Player player = playersFactory.getPlayersArray()[0];
        Player player1 = playersFactory.getPlayersArray()[1];
        Player actual = playersFactory.getPlayer();
        Assert.assertEquals(player, actual);
        actual = playersFactory.getPlayer();
        Assert.assertEquals(player1, actual);
    }

    @Test
    public void reversStatusCellAtPlayers() {
        playersFactory.addArrayPlayer(1);
        Player player = playersFactory.getPlayersArray()[0];
        Player player1 = playersFactory.getPlayersArray()[1];
        Assert.assertTrue(player.getPlayerKey().equals(String.valueOf(StatusCell.X)));
        Assert.assertTrue(player1.getPlayerKey().equals(String.valueOf(StatusCell.O)));
        playersFactory.reversStatusCellAtPlayers();
        Assert.assertTrue(player.getPlayerKey().equals(String.valueOf(StatusCell.O)));
        Assert.assertTrue(player1.getPlayerKey().equals(String.valueOf(StatusCell.X)));
    }
}
