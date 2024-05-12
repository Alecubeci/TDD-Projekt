package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        GameDataService dataService = new GameDataService();

        Player player1 = new Player("Player 1", 'X');
        Player player2 = new Player("Player 2", 'O');

        game.addPlayer(player1);
        game.addPlayer(player2);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Willkommen zu Vier Gewinnt!");
        System.out.println("1. Neues Spiel starten");
        System.out.println("2. Gespeichertes Spiel laden");

        int choice = scanner.nextInt();

        if (choice == 1) {
            game.startGame();

        } else if (choice == 2) {

            System.out.println("Geben Sie den Namen des gespeicherten Spiels ein:");
            String savedGameName = scanner.next();
            game = dataService.loadGame(savedGameName);
            if (game == null) {
                System.out.println("Das gespeicherte Spiel konnte nicht gefunden werden.");
                return;
            }
        } else {
            System.out.println("Ungültige Eingabe. Das Spiel wird beendet.");
            return;
        }

        while (game.isGameActive()) {
            game.displayBoard();

            Player currentPlayer = game.getPlayers().get(game.getGameBoard().getTotalTokens() % 2);

            System.out.println(currentPlayer.getId() + ", bitte wähle eine Spalte (1-7) oder 's' zum Speichern: ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("s")) {
                dataService.saveGame("lastGame", game);
                System.out.println("Spiel wurde gespeichert.");
                continue;
            }
            int column;
            try {
                column = Integer.parseInt(input);
                column--;
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe! Bitte geben Sie eine Spalte (1-7) oder 's' ein.");
                continue;
            }

            if (game.executeMove(column, currentPlayer.getSymbol())) {
                if (game.checkForWinner()) {
                    game.displayBoard();
                    System.out.println("Herzlichen Glückwunsch, " + currentPlayer.getId() + "! Du hast gewonnen!");
                    break;
                } else if (game.getGameBoard().checkForDraw()) {
                    game.displayBoard();
                    System.out.println("Das Spiel endet unentschieden!");
                    break;
                }
            } else {
                System.out.println("Ungültiger Spielzug! Bitte wähle eine andere Spalte.");
            }
        }

        game.endGame();
        scanner.close();
    }
}
