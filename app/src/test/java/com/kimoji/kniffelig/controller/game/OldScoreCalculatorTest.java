package com.kimoji.kniffelig.controller.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OldScoreCalculatorTest {

    @Test
    public void testTest() {
        assertEquals(true, true);
    }

    @Test
    public void calcScoreException() {
        final int[] dices = {1, 2, 3};
        assertThrows(IllegalArgumentException.class, () -> ScoreCalculator.calcScore(OldScore.ACES, dices));
    }

    @Test
    public void calcScoreAceTest() {
        int[] dices = {1, 2, 3, 4, 5};
        try {
            assertEquals(1, ScoreCalculator.calcScore(OldScore.ACES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreZeroAcesTest() {
        int[] dices = {2, 2, 3, 4, 5};
        try {
            assertEquals(0, ScoreCalculator.calcScore(OldScore.ACES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreMultAcesTest() {
        int[] dices = {1, 1, 1, 4, 5};
        try {
            assertEquals(3, ScoreCalculator.calcScore(OldScore.ACES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreOnlyAcesTest() {
        int[] dices = {1, 1, 1, 1, 1};
        try {
            assertEquals(5, ScoreCalculator.calcScore(OldScore.ACES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreTwoTest() {
        int[] dices = {2, 1, 3, 4, 5};
        try {
            assertEquals(2, ScoreCalculator.calcScore(OldScore.TWOS, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreZeroTwosTest() {
        int[] dices = {1, 1, 3, 4, 5};
        try {
            assertEquals(0, ScoreCalculator.calcScore(OldScore.TWOS, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreMultTwosTest() {
        int[] dices = {2, 2, 2, 4, 5};
        try {
            assertEquals(6, ScoreCalculator.calcScore(OldScore.TWOS, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreOnlyTwosTest() {
        int[] dices = {2, 2, 2, 2, 2};
        try {
            assertEquals(10, ScoreCalculator.calcScore(OldScore.TWOS, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreThreesTest() {
        int[] dices = {1, 2, 3, 4, 5};
        try {
            assertEquals(3, ScoreCalculator.calcScore(OldScore.THREES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreZeroThreesTest() {
        int[] dices = {2, 2, 5, 4, 5};
        try {
            assertEquals(0, ScoreCalculator.calcScore(OldScore.THREES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreMultThreesTest() {
        int[] dices = {3, 3, 3, 4, 5};
        try {
            assertEquals(9, ScoreCalculator.calcScore(OldScore.THREES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreOnlyThreesTest() {
        int[] dices = {3, 3, 3, 3, 3};
        try {
            assertEquals(15, ScoreCalculator.calcScore(OldScore.THREES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScorFoursTest() {
        int[] dices = {1, 2, 3, 4, 5};
        try {
            assertEquals(4, ScoreCalculator.calcScore(OldScore.FOURS, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreZeroFoursTest() {
        int[] dices = {2, 2, 5, 1, 5};
        try {
            assertEquals(0, ScoreCalculator.calcScore(OldScore.FOURS, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreMultFoursTest() {
        int[] dices = {4, 4, 3, 4, 5};
        try {
            assertEquals(12, ScoreCalculator.calcScore(OldScore.FOURS, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreOnlyFoursTest() {
        int[] dices = {4, 4, 4, 4, 4};
        try {
            assertEquals(20, ScoreCalculator.calcScore(OldScore.FOURS, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreFivesTest() {
        int[] dices = {1, 2, 3, 4, 5};
        try {
            assertEquals(5, ScoreCalculator.calcScore(OldScore.FIVES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreZeroFivesTest() {
        int[] dices = {2, 2, 3, 4, 1};
        try {
            assertEquals(0, ScoreCalculator.calcScore(OldScore.FIVES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreMultFivesTest() {
        int[] dices = {5, 5, 3, 4, 5};
        try {
            assertEquals(15, ScoreCalculator.calcScore(OldScore.FIVES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreOnlyFivesTest() {
        int[] dices = {5, 5, 5, 5, 5};
        try {
            assertEquals(25, ScoreCalculator.calcScore(OldScore.FIVES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreSixesTest() {
        int[] dices = {1, 2, 3, 4, 6};
        try {
            assertEquals(6, ScoreCalculator.calcScore(OldScore.SIXES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreZeroSixesTest() {
        int[] dices = {2, 2, 5, 4, 5};
        try {
            assertEquals(0, ScoreCalculator.calcScore(OldScore.SIXES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreMultSixesTest() {
        int[] dices = {6, 6, 6, 4, 5};
        try {
            assertEquals(18, ScoreCalculator.calcScore(OldScore.SIXES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreOnlySixesTest() {
        int[] dices = {6, 6, 6, 6, 6};
        try {
            assertEquals(30, ScoreCalculator.calcScore(OldScore.SIXES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreTOAKgood1() {
        int[] dices = {1, 2, 6, 6, 6};
        try {
            assertEquals(21, ScoreCalculator.calcScore(OldScore.THREEOFAKIND, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreTOAKgood2() {
        int[] dices = {1, 1, 1, 6, 6};
        try {
            assertEquals(15, ScoreCalculator.calcScore(OldScore.THREEOFAKIND, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreTOAKMult() {
        int[] dices = {6, 2, 6, 6, 6};
        try {
            assertEquals(26, ScoreCalculator.calcScore(OldScore.THREEOFAKIND, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreTOAKZero() {
        int[] dices = {1, 2, 2, 6, 6};
        try {
            assertEquals(0, ScoreCalculator.calcScore(OldScore.THREEOFAKIND, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreFOAKgood1() {
        int[] dices = {1, 6, 6, 6, 6};
        try {
            assertEquals(25, ScoreCalculator.calcScore(OldScore.FOUROFAKIND, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreFOAKgood2() {
        int[] dices = {1, 1, 1, 1, 6};
        try {
            assertEquals(10, ScoreCalculator.calcScore(OldScore.FOUROFAKIND, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreFOAKMult() {
        int[] dices = {6, 6, 6, 6, 6};
        try {
            assertEquals(30, ScoreCalculator.calcScore(OldScore.FOUROFAKIND, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreFOAKZero1() {
        int[] dices = {1, 2, 2, 6, 6};
        try {
            assertEquals(0, ScoreCalculator.calcScore(OldScore.FOUROFAKIND, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreFOAKZero2() {
        int[] dices = {1, 2, 2, 2, 6};
        try {
            assertEquals(0, ScoreCalculator.calcScore(OldScore.FOUROFAKIND, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreSmallStraightZero1() {
        int[] dices = {1, 2, 2, 2, 6};
        try {
            assertEquals(0, ScoreCalculator.calcScore(OldScore.SMALLSTRAIGHT, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreSmallStraightZero2() {
        int[] dices = {1, 2, 3, 2, 6};
        try {
            assertEquals(0, ScoreCalculator.calcScore(OldScore.SMALLSTRAIGHT, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreSmallStraightGood1() {
        int[] dices = {1, 2, 3, 2, 4};
        try {
            assertEquals(30, ScoreCalculator.calcScore(OldScore.SMALLSTRAIGHT, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreSmallStraightGood2() {
        int[] dices = {5, 2, 3, 2, 4};
        try {
            assertEquals(30, ScoreCalculator.calcScore(OldScore.SMALLSTRAIGHT, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreSmallStraightGood3() {
        int[] dices = {1, 5, 3, 2, 4};
        try {
            assertEquals(30, ScoreCalculator.calcScore(OldScore.SMALLSTRAIGHT, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreSmallStraightGood4() {
        int[] dices = {6, 5, 3, 2, 4};
        try {
            assertEquals(30, ScoreCalculator.calcScore(OldScore.SMALLSTRAIGHT, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreSmallStraightGood5() {
        int[] dices = {6, 5, 3, 3, 4};
        try {
            assertEquals(30, ScoreCalculator.calcScore(OldScore.SMALLSTRAIGHT, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreLargeStraightZero1() {
        int[] dices = {1, 2, 2, 2, 4};
        try {
            assertEquals(0, ScoreCalculator.calcScore(OldScore.LARGESTRAIGHT, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreLargeStraightZero2() {
        int[] dices = {1, 2, 3, 2, 4};
        try {
            assertEquals(0, ScoreCalculator.calcScore(OldScore.LARGESTRAIGHT, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreLargeStraightZero3() {
        int[] dices = {5, 2, 3, 2, 4};
        try {
            assertEquals(0, ScoreCalculator.calcScore(OldScore.LARGESTRAIGHT, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreLargeStraightGood1() {
        int[] dices = {5, 2, 3, 6, 4};
        try {
            assertEquals(40, ScoreCalculator.calcScore(OldScore.LARGESTRAIGHT, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreLargeStraightGood2() {
        int[] dices = {5, 2, 3, 1, 4};
        try {
            assertEquals(40, ScoreCalculator.calcScore(OldScore.LARGESTRAIGHT, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreFullHouseZero1() {
        int[] dices = {5, 2, 3, 1, 4};
        try {
            assertEquals(0, ScoreCalculator.calcScore(OldScore.FULLHOUSE, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreFullHouseZero2() {
        int[] dices = {2, 2, 2, 2, 4};
        try {
            assertEquals(0, ScoreCalculator.calcScore(OldScore.FULLHOUSE, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreFullHouseZero3() {
        int[] dices = {2, 2, 3, 3, 4};
        try {
            assertEquals(0, ScoreCalculator.calcScore(OldScore.FULLHOUSE, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreFullHouseGood1() {
        int[] dices = {2, 2, 2, 4, 4};
        try {
            assertEquals(25, ScoreCalculator.calcScore(OldScore.FULLHOUSE, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreFullHouseGood2() {
        int[] dices = {2, 2, 2, 6, 6};
        try {
            assertEquals(25, ScoreCalculator.calcScore(OldScore.FULLHOUSE, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreKniffleZero1() {
        int[] dices = {2, 2, 2, 6, 6};
        try {
            assertEquals(0, ScoreCalculator.calcScore(OldScore.KNIFFEL, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreKniffleZero2() {
        int[] dices = {2, 2, 2, 2, 1};
        try {
            assertEquals(0, ScoreCalculator.calcScore(OldScore.KNIFFEL, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreKniffleGood1() {
        int[] dices = {2, 2, 2, 2, 2};
        try {
            assertEquals(50, ScoreCalculator.calcScore(OldScore.KNIFFEL, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreKniffleGood2() {
        int[] dices = {1, 1, 1, 1, 1};
        try {
            assertEquals(50, ScoreCalculator.calcScore(OldScore.KNIFFEL, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreChance1() {
        int[] dices = {1, 1, 1, 1, 1};
        try {
            assertEquals(5, ScoreCalculator.calcScore(OldScore.CHANCE, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreChance2() {
        int[] dices = {2, 2, 1, 1, 1};
        try {
            assertEquals(7, ScoreCalculator.calcScore(OldScore.CHANCE, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }


    @Test
    public void calcScoreChance3() {
        int[] dices = {1, 4, 1, 5, 3};
        try {
            assertEquals(14, ScoreCalculator.calcScore(OldScore.CHANCE, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }
}