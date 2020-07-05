package com.kimoji.kniffelig.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameStatusImpTest {

    GameStatus gameStatus;

    @BeforeEach
    void setUp() {

        gameStatus = new GameStatusImp(3, 4, 2);
    }

    @Test
    void getActivePlayer() {
        assertEquals(3, gameStatus.getActivePlayer());
    }

    @Test
    void getCurrentRound() {
        assertEquals(4, gameStatus.getCurrentRound());
    }

    @Test
    void getLeftTries() {
        assertEquals(2, gameStatus.getLeftTries());
    }

    @Test
    void setActivePlayer() {
        gameStatus.setActivePlayer(4);
        assertEquals(4, gameStatus.getActivePlayer());

    }

    @Test
    void setCurrentRound() {
        gameStatus.setCurrentRound(14);
        assertEquals(14, gameStatus.getCurrentRound());
    }

    @Test
    void setLeftTries() {
        gameStatus.setLeftTries(5);
        assertEquals(5, gameStatus.getLeftTries());
    }
}