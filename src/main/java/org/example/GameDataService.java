package org.example;
import java.util.HashMap;
import java.util.Map;

public class GameDataService {
    private final Map<String, Game> savedGames = new HashMap<>();

    public void saveGame(String gameName, Game game) {
        savedGames.put(gameName, game);
    }

    public Game loadGame(String gameName) {
        return savedGames.get(gameName);
    }

    public boolean deleteGame(String gameName) {
        if (savedGames.containsKey(gameName)) {
            savedGames.remove(gameName);
            return true;
        }
        return false;
    }
}
