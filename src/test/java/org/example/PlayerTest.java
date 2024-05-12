package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    private Player player1;
    private Player player2;

    @BeforeEach
    public void setUp() {
        player1 = new Player("player1", 'X');
        player2 = new Player("player2", 'O');
    }

    @Test
    public void testGetId() {
        String id1 = player1.getId();

        assertEquals("player1", id1);

        String id2 = player2.getId();
        assertEquals("player2", id2);
    }

    @Test
    public void testGetSymbol() {

        char symbol1 = player1.getSymbol();

        assertEquals('X', symbol1);

        char symbol2 = player2.getSymbol();
        assertEquals('O', symbol2);
    }
}
