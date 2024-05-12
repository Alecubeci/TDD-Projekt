package org.example;

public class GameBoard {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private char[][] board;

    public GameBoard() {
        board = new char[ROWS][COLUMNS];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public boolean addTokenToColumn(int column, char symbol) {
        try {
            try {
                for (int row = ROWS - 1; row >= 0; row--) {
                    if (board[row][column] == ' ') {
                        board[row][column] = symbol;
                        return true;
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Ungültige Eingabe");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Füll");
        }
        return false;
    }

    public boolean checkForWinner() {
        // Horizontale Überprüfung
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col <= COLUMNS - 4; col++) {
                char token = board[row][col];
                if (token != ' ' && token == board[row][col + 1] && token == board[row][col + 2] && token == board[row][col + 3]) {
                    return true;
                }
            }
        }

        for (int col = 0; col < COLUMNS; col++) {
            for (int row = 0; row <= ROWS - 4; row++) {
                char token = board[row][col];
                if (token != ' ' && token == board[row + 1][col] && token == board[row + 2][col] && token == board[row + 3][col]) {
                    return true;
                }
            }
        }

        for (int row = 0; row <= ROWS - 4; row++) {
            for (int col = 0; col <= COLUMNS - 4; col++) {
                char token = board[row][col];
                if (token != ' ' && token == board[row + 1][col + 1] && token == board[row + 2][col + 2] && token == board[row + 3][col + 3]) {
                    return true;
                }
            }
        }

        for (int row = 0; row <= ROWS - 4; row++) {
            for (int col = 3; col < COLUMNS; col++) {
                char token = board[row][col];
                if (token != ' ' && token == board[row + 1][col - 1] && token == board[row + 2][col - 2] && token == board[row + 3][col - 3]) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkForDraw() {
        for (int col = 0; col < COLUMNS; col++) {
            if (board[0][col] == ' ') {
                return false;
            }
        }
        return true;
    }

    public void display() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                System.out.print("| " + board[row][col] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-----------------------------");
    }

    public char[][] getBoard() {
        return board;
    }

    public int getTotalTokens() {
        int count = 0;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                if (board[row][col] != ' ') {
                    count++;
                }
            }
        }
        return count;
    }
}
