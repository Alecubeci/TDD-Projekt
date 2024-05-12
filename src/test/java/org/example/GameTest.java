package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    private Game game;
    private Player player1;
    private Player player2;

    @BeforeEach
    public void setUp() {
        game = new Game();
        player1 = new Player("player1", 'X');
        player2 = new Player("player2", 'O');
    }

    @Test
    public void testAddPlayer() {
        int initialNumPlayers = game.getPlayers().size();

        game.addPlayer(player1);
        game.addPlayer(player2);
        int numPlayersAfterAdding = game.getPlayers().size();

        assertEquals(initialNumPlayers + 2, numPlayersAfterAdding);
    }

    @Test
    public void testStartAndEndGame() {
        assertFalse(game.isGameActive());
        game.startGame();
        assertTrue(game.isGameActive());
        game.endGame();

        assertFalse(game.isGameActive());
    }

    @Test
    public void testCheckForWinner() {
        game.getGameBoard().addTokenToColumn(0, 'X');
        game.getGameBoard().addTokenToColumn(1, 'X');
        game.getGameBoard().addTokenToColumn(2, 'X');
        game.getGameBoard().addTokenToColumn(3, 'X');

        boolean winner = game.checkForWinner();

        assertTrue(winner);
    }

    @Test
    public void testExecuteMove() {
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.startGame();
        int initialNumTokens = game.getGameBoard().getTotalTokens();

        game.executeMove(0, player1.getSymbol());
        int numTokensAfterMove = game.getGameBoard().getTotalTokens();

        assertEquals(initialNumTokens + 1, numTokensAfterMove);
    }

    @Test
    public void testDisplayBoard() {
        // Arrange
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.startGame();

        String expectedBoard =
                "| - | - | - | - | - | - | - |\n" +
                        "| - | - | - | - | - | - | - |\n" +
                        "| - | - | - | - | - | - | - |\n" +
                        "| - | - | - | - | - | - | - |\n" +
                        "| - | - | - | - | - | - | - |\n" +
                        "| - | - | - | - | - | - | - |\n";

        // Act
        game.displayBoard();
    }

}
