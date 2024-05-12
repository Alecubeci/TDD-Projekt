package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private GameBoard gameBoard;
    private boolean gameActive;

    public Game() {
        players = new ArrayList<>();
        gameBoard = new GameBoard();
        gameActive = false;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public boolean isGameActive() {
        return gameActive;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startGame() {
        gameActive = true;
    }

    public void endGame() {
        gameActive = false;
    }

    public boolean checkForWinner() {
        return gameBoard.checkForWinner();
    }

    public boolean executeMove(int column, char symbol) {
        gameBoard.addTokenToColumn(column, symbol);
        return true;
    }

    public void displayBoard() {
        gameBoard.display();
    }

}
