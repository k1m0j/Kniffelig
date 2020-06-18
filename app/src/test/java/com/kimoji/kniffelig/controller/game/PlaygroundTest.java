package com.kimoji.kniffelig.controller.game;

import com.kimoji.kniffelig.exception.InvalidUserInteractionException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaygroundTest {
    private Playground playground;
    private String[] playerNames = {"Hans", "Maus", "Dieter"};

    @BeforeEach
    public void setup() {
        playground = new PlaygroundImp(playerNames);
    }

    @Test
    void shakeInitLeftTries() {
        assertEquals(3, playground.getLeftTries());
    }

    @Test
    void shakeInitCurrentRound() {
        assertEquals(0, playground.getCurrentRound());
    }

    @Test
    void activePlayerInitCurrentRound() {
        assertEquals(0, playground.getActivePlayer());
    }


    @Test
    public void shakeOneShakes() {
        try {
            playground.shake();
        } catch (InvalidUserInteractionException e) {
            fail();
        }
        assertEquals(2, playground.getLeftTries());
    }

    @Test
    public void shakeTwoShakes() {
        try {
            playground.shake();
            playground.shake();
        } catch (InvalidUserInteractionException e) {
            fail();
        }
        assertEquals(1, playground.getLeftTries());
    }

    @Test
    public void shakeThreeShakes() {
        try {
            playground.shake();
            playground.shake();
            playground.shake();
        } catch (InvalidUserInteractionException e) {
            fail();
        }
        assertEquals(0, playground.getLeftTries());
    }

    @Test
    public void shakeFourShakes() {
        try {
            playground.shake();
            playground.shake();
            playground.shake();
            playground.shake();
            fail();
        } catch (InvalidUserInteractionException e) {
            assertEquals(0, playground.getLeftTries());
        }
    }

    @Test
    public void ShakeException() {
        try {
            playground.shake();
            playground.shake();
            playground.shake();
        } catch (InvalidUserInteractionException e) {
            fail();
        }
        assertThrows(InvalidUserInteractionException.class, () -> playground.shake());
    }

    @Test
    void lockDiceNoChangeOfTries() {
        playground.lockDice(1);
        assertEquals(3, playground.getLeftTries());
    }

    @Test
    void lockDiceNoChangeOfActivePlayer() {
        playground.lockDice(1);
        assertEquals(0, playground.getActivePlayer());
    }

    @Test
    void freeDice() {
        playground.unlockDice(1);
        assertEquals(3, playground.getLeftTries());
    }

    @Test
    void addScoreCurrentRound1() {
        playground.unlockDice(1);
        assertEquals(3, playground.getLeftTries());
    }

    @Test
    void addScoreActivePlayer1() {
        playground.addScore(OldScore.ACES);
        assertEquals(1, playground.getActivePlayer());
    }

    @Test
    void addScoreCurrentRound2() {
        playground.addScore(OldScore.ACES);
        playground.addScore(OldScore.TWOS);
        assertEquals(2, playground.getCurrentRound());
    }

    @Test
    void addScoreActivePlayer2() {
        playground.addScore(OldScore.ACES);
        playground.addScore(OldScore.THREES);
        assertEquals(2, playground.getActivePlayer());
    }

    @Test
    void addScoreCurrentRound3() {
        playground.addScore(OldScore.ACES);
        playground.addScore(OldScore.TWOS);
        playground.addScore(OldScore.FIVES);
        assertEquals(3, playground.getCurrentRound());
    }

    @Test
    void addScoreActivePlayer3() {
        playground.addScore(OldScore.ACES);
        playground.addScore(OldScore.THREES);
        playground.addScore(OldScore.KNIFFEL);
        assertEquals(0, playground.getActivePlayer());
    }

    @Test
    public void addScoreResetShakes() {
        try {
            playground.shake();
        } catch (InvalidUserInteractionException e) {
            fail();
        }
        playground.addScore(OldScore.FULLHOUSE);
        assertEquals(3, playground.getLeftTries());
    }

    @Test
    public void addScoreResetShakes2() {
        try {
            playground.shake();
            playground.shake();
        } catch (InvalidUserInteractionException e) {
            fail();
        }
        playground.addScore(OldScore.FULLHOUSE);
        assertEquals(3, playground.getLeftTries());
    }

    @Test
    void addScoreMaxReachable() {
        playground.addScore(OldScore.ACES);
        playground.addScore(OldScore.TWOS);
        playground.addScore(OldScore.THREES);
        playground.addScore(OldScore.FOURS);
        playground.addScore(OldScore.FIVES);
        playground.addScore(OldScore.SIXES);
        playground.addScore(OldScore.THREEOFAKIND);
        playground.addScore(OldScore.FOUROFAKIND);
        playground.addScore(OldScore.FULLHOUSE);
        playground.addScore(OldScore.SMALLSTRAIGHT);
        playground.addScore(OldScore.LARGESTRAIGHT);
        playground.addScore(OldScore.KNIFFEL);
        playground.addScore(OldScore.CHANCE);
        assertEquals(13, playground.getCurrentRound());
    }

    @Test
    void addScoreMaxWorking() {
        playground.addScore(OldScore.ACES);
        playground.addScore(OldScore.TWOS);
        playground.addScore(OldScore.THREES);
        playground.addScore(OldScore.FOURS);
        playground.addScore(OldScore.FIVES);
        playground.addScore(OldScore.SIXES);
        playground.addScore(OldScore.THREEOFAKIND);
        playground.addScore(OldScore.FOUROFAKIND);
        playground.addScore(OldScore.FULLHOUSE);
        playground.addScore(OldScore.SMALLSTRAIGHT);
        playground.addScore(OldScore.LARGESTRAIGHT);
        playground.addScore(OldScore.KNIFFEL);
        playground.addScore(OldScore.KNIFFEL);
        playground.addScore(OldScore.CHANCE);
        assertEquals(13, playground.getCurrentRound());
    }

    @Test
    void toggleLock() {
        playground.toggleLock(0);
        assertTrue(playground.isLocked(0));
    }

    @Test
    void isLocked() {
        playground.isLocked(0);
    }

    @Test
    void getActivePlayer() {
        playground.getActivePlayer();

    }


}