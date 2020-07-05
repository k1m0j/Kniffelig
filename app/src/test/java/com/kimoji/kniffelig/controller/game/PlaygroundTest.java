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
        assertEquals(2, playground.getLeftTries());
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
        assertEquals(1, playground.getLeftTries());
    }

    @Test
    public void shakeTwoShakes() {
        try {
            playground.shake();
            playground.shake();
        } catch (InvalidUserInteractionException e) {
            fail();
        }
        assertEquals(0, playground.getLeftTries());
    }

    @Test
    public void shakeThreeShakes() {
        try {
            //First shake gets called with opening game / view
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
            //?
        }
        assertThrows(InvalidUserInteractionException.class, () -> playground.shake());
    }

    @Test
    void lockDiceNoChangeOfTries() {
        playground.lockDice(1);
        assertEquals(2, playground.getLeftTries());
    }

    @Test
    void lockDiceNoChangeOfActivePlayer() {
        playground.lockDice(1);
        assertEquals(0, playground.getActivePlayer());
    }

    @Test
    void freeDice() {
        playground.unlockDice(1);
        assertEquals(2, playground.getLeftTries());
    }

    @Test
    void addScoreCurrentRound1() {
        playground.unlockDice(1);
        assertEquals(2, playground.getLeftTries());
    }

    @Test
    void addScoreActivePlayer1() {
        playground.addScore(ScoreType.ACES);
        assertEquals(1, playground.getActivePlayer());
    }

    @Test
    void addScoreCurrentRound2() {
        playground.addScore(ScoreType.ACES);
        playground.addScore(ScoreType.TWOS);
        assertEquals(0, playground.getCurrentRound());
    }

    @Test
    void addScoreActivePlayer2() {
        playground.addScore(ScoreType.ACES);
        playground.addScore(ScoreType.THREES);
        assertEquals(2, playground.getActivePlayer());
    }

    @Test
    void addScoreCurrentRound3() {
        playground.addScore(ScoreType.ACES);
        playground.addScore(ScoreType.TWOS);
        playground.addScore(ScoreType.FIVES);
        assertEquals(1, playground.getCurrentRound());
    }

    @Test
    void addScoreActivePlayer3() {
        playground.addScore(ScoreType.ACES);
        playground.addScore(ScoreType.THREES);
        playground.addScore(ScoreType.KNIFFEL);
        assertEquals(0, playground.getActivePlayer());
    }

    @Test
    public void addScoreResetShakes() {
        try {
            playground.shake();
        } catch (InvalidUserInteractionException e) {
            fail();
        }
        playground.addScore(ScoreType.FULLHOUSE);
        assertEquals(2, playground.getLeftTries());
    }

    @Test
    public void addScoreResetShakes2() {
        try {
            playground.shake();
            playground.shake();
        } catch (InvalidUserInteractionException e) {
            fail();
        }
        playground.addScore(ScoreType.FULLHOUSE);
        assertEquals(2, playground.getLeftTries());
    }

    @Test
    void addScoreMaxReachable() {
        playground.addScore(ScoreType.ACES);
        playground.addScore(ScoreType.TWOS);
        playground.addScore(ScoreType.THREES);
        playground.addScore(ScoreType.FOURS);
        playground.addScore(ScoreType.FIVES);
        playground.addScore(ScoreType.SIXES);
        playground.addScore(ScoreType.THREE_OF_A_KIND);
        playground.addScore(ScoreType.FOUR_OF_A_KIND);
        playground.addScore(ScoreType.FULLHOUSE);
        playground.addScore(ScoreType.SMALL_STRAIGHT);
        playground.addScore(ScoreType.LARGE_STRAIGHT);
        playground.addScore(ScoreType.KNIFFEL);
        playground.addScore(ScoreType.CHANCE);
        assertEquals(4, playground.getCurrentRound());
    }

    @Test
    void addScoreMaxWorking() {
        playground.addScore(ScoreType.ACES);
        playground.addScore(ScoreType.TWOS);
        playground.addScore(ScoreType.THREES);
        playground.addScore(ScoreType.FOURS);
        playground.addScore(ScoreType.FIVES);
        playground.addScore(ScoreType.SIXES);
        playground.addScore(ScoreType.THREE_OF_A_KIND);
        playground.addScore(ScoreType.FOUR_OF_A_KIND);
        playground.addScore(ScoreType.FULLHOUSE);
        playground.addScore(ScoreType.SMALL_STRAIGHT);
        playground.addScore(ScoreType.LARGE_STRAIGHT);
        playground.addScore(ScoreType.KNIFFEL);
        playground.addScore(ScoreType.KNIFFEL);
        playground.addScore(ScoreType.CHANCE);
        assertEquals(4, playground.getCurrentRound());
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