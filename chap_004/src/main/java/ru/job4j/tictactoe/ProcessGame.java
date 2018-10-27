package ru.job4j.tictactoe;

import ru.job4j.tictactoe.input.Input;
import ru.job4j.tictactoe.input.InputCoordinates;
import ru.job4j.tictactoe.input.InputIntValue;
import ru.job4j.tictactoe.output.OutputTicTacToe;
import ru.job4j.tictactoe.player.Player;
import ru.job4j.tictactoe.player.PlayersFactory;

/**
 * @author Aleksandr Smirnov.
 */
public class ProcessGame {
    /**
     * Поле содержит значение текущего раунда.
     */
    private int playerRound;
    /**
     * Поля вывода сообщений для взаимодействия с пользователем.
     */
    private final static String INPUT_COUNT_ROUND = "Введите кол-во раундов ";
    private final static String INPUT_BOARD_SIZE = "Для смены размера игрового поля нажминие 'y'";
    private final static String MSG_END_GAME_OR_CONTINUE = "Чтобы продолжить введите 'y'";
    private final static String PLAYER_NAME = "Игрок ";
    private final static String COUNT_TOTAL_WIN = " имеет общее число побед - ";
    private final static String INPUT_POSITION_PlAYER = "Для предоставления первого хода игроку введите '1'";

    private InputCoordinates inputCoordinates;
    private Board board;
    private GameLogic gameLogic;
    private InputIntValue inputIntValue;
    private PlayersFactory playersFactory;
    private OutputTicTacToe outputTicTacToe;
    private Input input;

    /**
     * Конструктор по умолчанию.
     *
     * @param inputCoordinates - отвечает за ввод координат.
     * @param board            - игровое поле.
     * @param gameLogic        - проверяет победителя.
     * @param inputIntValue    - отвечает за ввод целочисленных значений.
     * @param playersFactory   - отвечает за хранение и выдачу игроков.
     * @param outputTicTacToe  - отвечает за вывод строковых сообщений.
     * @param input            - ввод строки.
     */
    public ProcessGame(final InputCoordinates inputCoordinates, final Board board, final GameLogic gameLogic,
                       final InputIntValue inputIntValue, final PlayersFactory playersFactory,
                       final OutputTicTacToe outputTicTacToe, final Input input) {
        this.input = input;
        this.playerRound = 0;
        this.inputCoordinates = inputCoordinates;
        this.board = board;
        this.gameLogic = gameLogic;
        this.inputIntValue = inputIntValue;
        this.playersFactory = playersFactory;
        this.outputTicTacToe = outputTicTacToe;
    }

    public ProcessGame() {
    }

    /**
     * Метод отвечает за ход одного раунда.
     *
     * @param boardSize - размер игрового поля.
     * @return - победителя.
     */
    private Player playOneRound(int boardSize) {
        board.fillGameBoard(boardSize);
        Player player;
        do {
            player = playersFactory.getPlayer();
            //если это первый раунд в игре и первый ход у бота, то нам нет необходимости выводить пустое игровое поле.
            if (playersFactory.getPlayerSwitch() != 1 && !player.getPlayerName().equals("BOT")) {
                UI.printBoard(board.getCells());
            }
            int[] coordinates = null;
            if (!player.getPlayerName().equals("BOT")) {
                coordinates = inputCoordinates.writeCoordinates(board.getCells());
            } else {

                coordinates = gameLogic.botMove(board.getCells());
            }
            gameLogic.setStatusCellByCoordinates(coordinates, player, board.getCells());
        } while (!gameLogic.checkWinnerInRound(board.getCells(), player));
        UI.printBoard(board.getCells());//после раунда выводим игровое поле.
        return player;
    }

    /**
     * Метод отвечает за одну игру.
     */
    private void playOneMatch() {
        System.out.println(INPUT_POSITION_PlAYER);
        playersFactory.addArrayPlayer(inputIntValue.writeValue());
        outputTicTacToe.ask(INPUT_BOARD_SIZE);
        int boardSize;
        if (gameLogic.checkInputY(input.write())) {
            boardSize = inputIntValue.writeValue();
        } else {
            boardSize = board.getCellSSize();
        }
        outputTicTacToe.ask(INPUT_COUNT_ROUND);
        int countWinnerForVictory = inputIntValue.writeValue();
        Player player;
        do {
            player = playOneRound(boardSize);
            outputTicTacToe.ask(gameLogic.getMsg());
            playerRound++;//Изменяем раунд.
            playersFactory.reversStatusCellAtPlayers();//меняем местами игроков.
            player.upPlayerReckoning();//изменяем поле побед игрока.
            playersFactory.setPlayerSwitch();//возвращаем переключателю значение по умолчанию.
        } while (!gameLogic.checkWinnerMach(countWinnerForVictory, playerRound, playersFactory.getPlayersArray()[0],
                playersFactory.getPlayersArray()[1]));
        outputTicTacToe.ask(gameLogic.getMsg());//выводим сообщение.
        player.setTotalCountWin();//изменяем поле общего числа побед.
    }

    public void playGame() {
        Player playerOne;
        Player playerTwo;
        do {
            playOneMatch();
            outputTicTacToe.ask(MSG_END_GAME_OR_CONTINUE);
            downPlayerRound();
            playerOne = playersFactory.getPlayersArray()[0];
            playerTwo = playersFactory.getPlayersArray()[1];
        } while (gameLogic.checkInputY(input.write()));
        outputTicTacToe.ask(String.format("%s%s%s%s", PLAYER_NAME, playerOne.getPlayerName(), COUNT_TOTAL_WIN,
                playerOne.getTotalCountWin()));
        outputTicTacToe.ask(String.format("%s%s%s%s", PLAYER_NAME, playerTwo.getPlayerName(), COUNT_TOTAL_WIN,
                playerTwo.getTotalCountWin()));
    }

    /**
     * Метод обнуляет счетчик раундов.
     */
    public void downPlayerRound() {
        this.playerRound = 0;
    }
}
