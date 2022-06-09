package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MancalaBoardTest {

    MancalaBoard gameBoard = new MancalaBoard();

    @Test
    public void testGetP1Store() {
        assertEquals(0, gameBoard.getP1Store().getStones().size());
    }

    @Test
    public void testGetP2Store() {
        assertEquals(0, gameBoard.getP2Store().getStones().size());
    }

    @Test
    public void testGetTotalStonesInP1Pit() {
        assertEquals(0, gameBoard.getP1Store().getStones().size());
    }

    @Test
    public void testGetTotalStonesInPit() {
        assertEquals(48, gameBoard.getGamePieceTotal());
    }

}
