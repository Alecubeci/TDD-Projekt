package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameDataServiceTest {
    private GameDataService dataService;
    private Game game;

    @BeforeEach
    void setUp() {
        dataService = new GameDataService();
        game = new Game();
    }

    @Test
    void testSaveGame() {
        String gameName = "TestGame";

        dataService.saveGame(gameName, game);

        assertNotNull(dataService.loadGame(gameName));
    }

    @Test
    void testLoadGame() {
        String gameName = "TestGame";
        dataService.saveGame(gameName, game);

        Game loadedGame = dataService.loadGame(gameName);

        assertNotNull(loadedGame);
        assertEquals(game, loadedGame);
    }

    @Test
    void testDeleteGame() {
        String gameName = "TestGame";
        dataService.saveGame(gameName, game);

        boolean deleted = dataService.deleteGame(gameName);

        assertTrue(deleted);
        assertNull(dataService.loadGame(gameName));
    }

    @Test
    void testDeleteNonExistingGame() {
        String gameName = "NonExistingGame";

        boolean deleted = dataService.deleteGame(gameName);

        assertFalse(deleted);
    }
}
