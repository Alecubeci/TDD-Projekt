package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameBoardTest {
    private GameBoard gameBoard;

    @BeforeEach
    public void setUp() {
        gameBoard = new GameBoard();
    }

    @Test
    public void testAddTokenToColumn() {
        int column = 0;
        char symbol = 'X';

        boolean added = gameBoard.addTokenToColumn(column, symbol);

        assertTrue(added);
        assertEquals(symbol, gameBoard.getBoard()[5][0]);
    }

    @Test
    public void testAddTokenToInvalidColumn() {

        int column = -1;
        char symbol = 'X';

        boolean added = gameBoard.addTokenToColumn(column, symbol);

        assertFalse(added);
    }

    @Test
    public void testCheckForWinnerHorizontal() {
        gameBoard.addTokenToColumn(0, 'X');
        gameBoard.addTokenToColumn(1, 'X');
        gameBoard.addTokenToColumn(2, 'X');
        gameBoard.addTokenToColumn(3, 'X');

        boolean winner = gameBoard.checkForWinner();

        assertTrue(winner);
    }

    @Test
    public void testCheckForWinnerVertical() {
        gameBoard.addTokenToColumn(0, 'X');
        gameBoard.addTokenToColumn(0, 'X');
        gameBoard.addTokenToColumn(0, 'X');
        gameBoard.addTokenToColumn(0, 'X');

        boolean winner = gameBoard.checkForWinner();

        assertTrue(winner);
    }

    @Test
    public void testCheckForWinnerDiagonal() {
        gameBoard.addTokenToColumn(0, 'X');
        gameBoard.addTokenToColumn(1, 'O');
        gameBoard.addTokenToColumn(1, 'X');
        gameBoard.addTokenToColumn(2, 'O');
        gameBoard.addTokenToColumn(2, 'O');
        gameBoard.addTokenToColumn(2, 'X');
        gameBoard.addTokenToColumn(3, 'O');
        gameBoard.addTokenToColumn(3, 'O');
        gameBoard.addTokenToColumn(3, 'O');
        gameBoard.addTokenToColumn(3, 'X');

        boolean winner = gameBoard.checkForWinner();

        assertTrue(winner);
    }

    @Test
    public void testCheckForDraw() {
        for (int col = 0; col < 7; col++) {
            for (int row = 0; row < 6; row++) {
                gameBoard.addTokenToColumn(col, 'X');
            }
        }

        boolean draw = gameBoard.checkForDraw();

        assertTrue(draw);
    }
}
