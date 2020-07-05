package com.kimoji.kniffelig.controller.game;

import com.kimoji.kniffelig.exception.InvalidUserInteractionException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaygroundTest {
    private Playground playground;
    private String[] playerNames = {"Hans", "Maus", "Dieter", "Karl"};

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
        assertEquals(0, playground.getCurrentRound());
    }

    @Test
    void addScoreCurrentRound4() {
        playground.addScore(ScoreType.ACES);
        playground.addScore(ScoreType.TWOS);
        playground.addScore(ScoreType.FIVES);
        playground.addScore(ScoreType.FIVES);
        playground.addScore(ScoreType.FIVES);
        assertEquals(1, playground.getCurrentRound());
    }

    @Test
    void addScoreActivePlayer3() {
        playground.addScore(ScoreType.ACES);
        playground.addScore(ScoreType.THREES);
        playground.addScore(ScoreType.KNIFFEL);
        assertEquals(3, playground.getActivePlayer());
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
        playground.addScore(ScoreType.ACES);
        playground.addScore(ScoreType.ACES);
        playground.addScore(ScoreType.ACES);
        playground.addScore(ScoreType.TWOS);
        playground.addScore(ScoreType.TWOS);
        playground.addScore(ScoreType.TWOS);
        playground.addScore(ScoreType.TWOS);
        playground.addScore(ScoreType.THREES);
        playground.addScore(ScoreType.THREES);
        playground.addScore(ScoreType.THREES);
        playground.addScore(ScoreType.THREES);
        playground.addScore(ScoreType.FOURS);
        playground.addScore(ScoreType.FOURS);
        playground.addScore(ScoreType.FOURS);
        playground.addScore(ScoreType.FOURS);
        playground.addScore(ScoreType.FIVES);
        playground.addScore(ScoreType.FIVES);
        playground.addScore(ScoreType.FIVES);
        playground.addScore(ScoreType.FIVES);
        playground.addScore(ScoreType.SIXES);
        playground.addScore(ScoreType.SIXES);
        playground.addScore(ScoreType.SIXES);
        playground.addScore(ScoreType.SIXES);
        playground.addScore(ScoreType.THREE_OF_A_KIND);
        playground.addScore(ScoreType.THREE_OF_A_KIND);
        playground.addScore(ScoreType.THREE_OF_A_KIND);
        playground.addScore(ScoreType.THREE_OF_A_KIND);
        playground.addScore(ScoreType.FOUR_OF_A_KIND);
        playground.addScore(ScoreType.FOUR_OF_A_KIND);
        playground.addScore(ScoreType.FOUR_OF_A_KIND);
        playground.addScore(ScoreType.FOUR_OF_A_KIND);
        playground.addScore(ScoreType.FULLHOUSE);
        playground.addScore(ScoreType.FULLHOUSE);
        playground.addScore(ScoreType.FULLHOUSE);
        playground.addScore(ScoreType.FULLHOUSE);
        playground.addScore(ScoreType.SMALL_STRAIGHT);
        playground.addScore(ScoreType.SMALL_STRAIGHT);
        playground.addScore(ScoreType.SMALL_STRAIGHT);
        playground.addScore(ScoreType.SMALL_STRAIGHT);
        playground.addScore(ScoreType.LARGE_STRAIGHT);
        playground.addScore(ScoreType.LARGE_STRAIGHT);
        playground.addScore(ScoreType.LARGE_STRAIGHT);
        playground.addScore(ScoreType.LARGE_STRAIGHT);
        playground.addScore(ScoreType.KNIFFEL);
        playground.addScore(ScoreType.KNIFFEL);
        playground.addScore(ScoreType.KNIFFEL);
        playground.addScore(ScoreType.KNIFFEL);
        playground.addScore(ScoreType.CHANCE);
        playground.addScore(ScoreType.CHANCE);
        playground.addScore(ScoreType.CHANCE);
        playground.addScore(ScoreType.CHANCE);
        assertEquals(13, playground.getCurrentRound());
    }

    @Test
    void addScoreMaxWorking() {
        playground.addScore(ScoreType.ACES);
        playground.addScore(ScoreType.ACES);
        playground.addScore(ScoreType.ACES);
        playground.addScore(ScoreType.ACES);
        playground.addScore(ScoreType.TWOS);
        playground.addScore(ScoreType.TWOS);
        playground.addScore(ScoreType.TWOS);
        playground.addScore(ScoreType.TWOS);
        playground.addScore(ScoreType.THREES);
        playground.addScore(ScoreType.THREES);
        playground.addScore(ScoreType.THREES);
        playground.addScore(ScoreType.THREES);
        playground.addScore(ScoreType.FOURS);
        playground.addScore(ScoreType.FOURS);
        playground.addScore(ScoreType.FOURS);
        playground.addScore(ScoreType.FOURS);
        playground.addScore(ScoreType.FIVES);
        playground.addScore(ScoreType.FIVES);
        playground.addScore(ScoreType.FIVES);
        playground.addScore(ScoreType.FIVES);
        playground.addScore(ScoreType.SIXES);
        playground.addScore(ScoreType.SIXES);
        playground.addScore(ScoreType.SIXES);
        playground.addScore(ScoreType.SIXES);
        playground.addScore(ScoreType.THREE_OF_A_KIND);
        playground.addScore(ScoreType.THREE_OF_A_KIND);
        playground.addScore(ScoreType.THREE_OF_A_KIND);
        playground.addScore(ScoreType.THREE_OF_A_KIND);
        playground.addScore(ScoreType.FOUR_OF_A_KIND);
        playground.addScore(ScoreType.FOUR_OF_A_KIND);
        playground.addScore(ScoreType.FOUR_OF_A_KIND);
        playground.addScore(ScoreType.FOUR_OF_A_KIND);
        playground.addScore(ScoreType.FULLHOUSE);
        playground.addScore(ScoreType.FULLHOUSE);
        playground.addScore(ScoreType.FULLHOUSE);
        playground.addScore(ScoreType.FULLHOUSE);
        playground.addScore(ScoreType.SMALL_STRAIGHT);
        playground.addScore(ScoreType.SMALL_STRAIGHT);
        playground.addScore(ScoreType.SMALL_STRAIGHT);
        playground.addScore(ScoreType.SMALL_STRAIGHT);
        playground.addScore(ScoreType.LARGE_STRAIGHT);
        playground.addScore(ScoreType.LARGE_STRAIGHT);
        playground.addScore(ScoreType.LARGE_STRAIGHT);
        playground.addScore(ScoreType.LARGE_STRAIGHT);
        playground.addScore(ScoreType.KNIFFEL);
        playground.addScore(ScoreType.KNIFFEL);
        playground.addScore(ScoreType.KNIFFEL);
        playground.addScore(ScoreType.KNIFFEL);
        playground.addScore(ScoreType.CHANCE);
        playground.addScore(ScoreType.CHANCE);
        playground.addScore(ScoreType.CHANCE);
        playground.addScore(ScoreType.CHANCE);
        playground.addScore(ScoreType.CHANCE);
        playground.addScore(ScoreType.CHANCE);
        playground.addScore(ScoreType.CHANCE);
        playground.addScore(ScoreType.CHANCE);
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

    @Test
    void addFilledScoreDoesNotSkipPlayer() {
        playground.addScore(ScoreType.ACES);
        playground.addScore(ScoreType.ACES);
        playground.addScore(ScoreType.ACES);
        playground.addScore(ScoreType.ACES);
        assertEquals("Hans", playground.getActivePlayerName());
        assertEquals(1, playground.getCurrentRound());
        assertEquals(2, playground.getLeftTries());
        playground.addScore(ScoreType.ACES);
        assertEquals("Hans", playground.getActivePlayerName());
        assertEquals(1, playground.getCurrentRound());
        assertEquals(2, playground.getLeftTries());
    }

    @Test
    void playgroundIntegrationTest() {
        assertEquals("Hans", playground.getActivePlayerName());
        assertEquals(0, playground.getCurrentRound());
        assertEquals(2, playground.getLeftTries());

        try {
            playground.shake();
            assertEquals("Hans", playground.getActivePlayerName());
            assertEquals(0, playground.getCurrentRound());
            assertEquals(1, playground.getLeftTries());

            playground.shake();
            assertEquals("Hans", playground.getActivePlayerName());
            assertEquals(0, playground.getCurrentRound());
            assertEquals(0, playground.getLeftTries());
        } catch (InvalidUserInteractionException e) {
            fail();
        }
        assertThrows(InvalidUserInteractionException.class, () -> playground.shake());
        assertEquals("Hans", playground.getActivePlayerName());
        assertEquals(0, playground.getCurrentRound());
        assertEquals(0, playground.getLeftTries());

        assertFalse(playground.getAllPlayers()[0].getScore(ScoreType.ACES).isFilledIn());

        playground.addScore(ScoreType.ACES);

        assertTrue(playground.getAllPlayers()[0].getScore(ScoreType.ACES).isFilledIn());
        assertEquals("Maus", playground.getActivePlayerName());
        assertEquals(0, playground.getCurrentRound());
        assertEquals(2, playground.getLeftTries());

        assertFalse(playground.getAllPlayers()[1].getScore(ScoreType.FULLHOUSE).isFilledIn());

        playground.addScore(ScoreType.FULLHOUSE);

        assertTrue(playground.getAllPlayers()[1].getScore(ScoreType.FULLHOUSE).isFilledIn());

        assertEquals("Dieter", playground.getActivePlayerName());
        assertEquals(0, playground.getCurrentRound());
        assertEquals(2, playground.getLeftTries());

        try {
            playground.shake();
            assertEquals("Dieter", playground.getActivePlayerName());
            assertEquals(0, playground.getCurrentRound());
            assertEquals(1, playground.getLeftTries());
        } catch (InvalidUserInteractionException e) {
            fail();
        }

        assertFalse(playground.getAllPlayers()[2].getScore(ScoreType.SIXES).isFilledIn());

        playground.addScore(ScoreType.SIXES);

        assertTrue(playground.getAllPlayers()[2].getScore(ScoreType.SIXES).isFilledIn());

        assertEquals("Karl", playground.getActivePlayerName());
        assertEquals(0, playground.getCurrentRound());
        assertEquals(2, playground.getLeftTries());
    }


}