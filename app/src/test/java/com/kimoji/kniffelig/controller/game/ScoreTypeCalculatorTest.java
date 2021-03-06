package com.kimoji.kniffelig.controller.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ScoreTypeCalculatorTest {

    @Test
    public void testTest() {
        assertEquals(true, true);
    }

    // FIXME: 03.07.20 Gibt es dich noch?
    /* 
    @Test
    public void calcScoreException() {
        final int[] dices = {1, 2, 3};
        assertThrows(IllegalArgumentException.class, () -> ScoreCalculator.calculateUpperScore(ScoreType.ACES, dices));
    }
    
     */

    @Test
    public void calcScoreAceTest() {
        int[] dices = {1, 2, 3, 4, 5};
        try {
            assertEquals(1, ScoreCalculator.calculateUpperScore(ScoreType.ACES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreZeroAcesTest() {
        int[] dices = {2, 2, 3, 4, 5};
        try {
            assertEquals(0, ScoreCalculator.calculateUpperScore(ScoreType.ACES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreMultAcesTest() {
        int[] dices = {1, 1, 1, 4, 5};
        try {
            assertEquals(3, ScoreCalculator.calculateUpperScore(ScoreType.ACES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreOnlyAcesTest() {
        int[] dices = {1, 1, 1, 1, 1};
        try {
            assertEquals(5, ScoreCalculator.calculateUpperScore(ScoreType.ACES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreTwoTest() {
        int[] dices = {2, 1, 3, 4, 5};
        try {
            assertEquals(2, ScoreCalculator.calculateUpperScore(ScoreType.TWOS, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreZeroTwosTest() {
        int[] dices = {1, 1, 3, 4, 5};
        try {
            assertEquals(0, ScoreCalculator.calculateUpperScore(ScoreType.TWOS, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreMultTwosTest() {
        int[] dices = {2, 2, 2, 4, 5};
        try {
            assertEquals(6, ScoreCalculator.calculateUpperScore(ScoreType.TWOS, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreOnlyTwosTest() {
        int[] dices = {2, 2, 2, 2, 2};
        try {
            assertEquals(10, ScoreCalculator.calculateUpperScore(ScoreType.TWOS, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreThreesTest() {
        int[] dices = {1, 2, 3, 4, 5};
        try {
            assertEquals(3, ScoreCalculator.calculateUpperScore(ScoreType.THREES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreZeroThreesTest() {
        int[] dices = {2, 2, 5, 4, 5};
        try {
            assertEquals(0, ScoreCalculator.calculateUpperScore(ScoreType.THREES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreMultThreesTest() {
        int[] dices = {3, 3, 3, 4, 5};
        try {

            assertEquals(9, ScoreCalculator.calculateUpperScore(ScoreType.THREES, dices));

        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreOnlyThreesTest() {
        int[] dices = {3, 3, 3, 3, 3};
        try {
            assertEquals(15, ScoreCalculator.calculateUpperScore(ScoreType.ACES.THREES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScorFoursTest() {
        int[] dices = {1, 2, 3, 4, 5};
        try {
            assertEquals(4, ScoreCalculator.calculateUpperScore(ScoreType.FOURS, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreZeroFoursTest() {
        int[] dices = {2, 2, 5, 1, 5};
        try {
            assertEquals(0, ScoreCalculator.calculateUpperScore(ScoreType.FOURS, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreMultFoursTest() {
        int[] dices = {4, 4, 3, 4, 5};
        try {
            assertEquals(12, ScoreCalculator.calculateUpperScore(ScoreType.FOURS, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreOnlyFoursTest() {
        int[] dices = {4, 4, 4, 4, 4};
        try {
            assertEquals(20, ScoreCalculator.calculateUpperScore(ScoreType.FOURS, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreFivesTest() {
        int[] dices = {1, 2, 3, 4, 5};
        try {
            assertEquals(5, ScoreCalculator.calculateUpperScore(ScoreType.FIVES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreZeroFivesTest() {
        int[] dices = {2, 2, 3, 4, 1};
        try {
            assertEquals(0, ScoreCalculator.calculateUpperScore(ScoreType.FIVES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreMultFivesTest() {
        int[] dices = {5, 5, 3, 4, 5};
        try {
            assertEquals(15, ScoreCalculator.calculateUpperScore(ScoreType.FIVES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreOnlyFivesTest() {
        int[] dices = {5, 5, 5, 5, 5};
        try {
            assertEquals(25, ScoreCalculator.calculateUpperScore(ScoreType.FIVES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreSixesTest() {
        int[] dices = {1, 2, 3, 4, 6};
        try {
            assertEquals(6, ScoreCalculator.calculateUpperScore(ScoreType.SIXES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreZeroSixesTest() {
        int[] dices = {2, 2, 5, 4, 5};
        try {
            assertEquals(0, ScoreCalculator.calculateUpperScore(ScoreType.SIXES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreMultSixesTest() {
        int[] dices = {6, 6, 6, 4, 5};
        try {
            assertEquals(18, ScoreCalculator.calculateUpperScore(ScoreType.SIXES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreOnlySixesTest() {
        int[] dices = {6, 6, 6, 6, 6};
        try {
            assertEquals(30, ScoreCalculator.calculateUpperScore(ScoreType.SIXES, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreTOAKgood1() {
        int[] dices = {1, 2, 6, 6, 6};
        try {
            assertEquals(21, ScoreCalculator.calculateSomeOfAKind(ScoreType.THREE_OF_A_KIND, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreTOAKgood2() {
        int[] dices = {1, 1, 1, 6, 6};
        try {
            assertEquals(15, ScoreCalculator.calculateSomeOfAKind(ScoreType.THREE_OF_A_KIND, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreTOAKMult() {
        int[] dices = {6, 2, 6, 6, 6};
        try {
            assertEquals(26, ScoreCalculator.calculateSomeOfAKind(ScoreType.THREE_OF_A_KIND, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreTOAKZero() {
        int[] dices = {1, 2, 2, 6, 6};
        try {
            assertEquals(0, ScoreCalculator.calculateSomeOfAKind(ScoreType.THREE_OF_A_KIND, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreFOAKgood1() {
        int[] dices = {1, 6, 6, 6, 6};
        try {
            assertEquals(25, ScoreCalculator.calculateSomeOfAKind(ScoreType.FOUR_OF_A_KIND, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreFOAKgood2() {
        int[] dices = {1, 1, 1, 1, 6};
        try {
            assertEquals(10, ScoreCalculator.calculateSomeOfAKind(ScoreType.FOUR_OF_A_KIND, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreFOAKMult() {
        int[] dices = {6, 6, 6, 6, 6};
        try {
            assertEquals(30, ScoreCalculator.calculateSomeOfAKind(ScoreType.FOUR_OF_A_KIND, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreFOAKZero1() {
        int[] dices = {1, 2, 2, 6, 6};
        try {
            assertEquals(0, ScoreCalculator.calculateSomeOfAKind(ScoreType.FOUR_OF_A_KIND, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreFOAKZero2() {
        int[] dices = {1, 2, 2, 2, 6};
        try {
            assertEquals(0, ScoreCalculator.calculateSomeOfAKind(ScoreType.FOUR_OF_A_KIND, dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreSmallStraightZero1() {
        int[] dices = {1, 2, 2, 2, 6};
        try {
            assertEquals(0, ScoreCalculator.calculateSmallStraight(dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreSmallStraightZero2() {
        int[] dices = {1, 2, 3, 2, 6};
        try {
            assertEquals(0, ScoreCalculator.calculateSmallStraight(dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreSmallStraightGood1() {
        int[] dices = {1, 2, 3, 2, 4};
        try {
            assertEquals(30, ScoreCalculator.calculateSmallStraight(dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreSmallStraightGood2() {
        int[] dices = {5, 2, 3, 2, 4};
        try {
            assertEquals(30, ScoreCalculator.calculateSmallStraight(dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreSmallStraightGood3() {
        int[] dices = {1, 5, 3, 2, 4};
        try {
            assertEquals(30, ScoreCalculator.calculateSmallStraight(dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreSmallStraightGood4() {
        int[] dices = {6, 5, 3, 2, 4};
        try {
            assertEquals(30, ScoreCalculator.calculateSmallStraight(dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreSmallStraightGood5() {
        int[] dices = {6, 5, 3, 3, 4};
        try {
            assertEquals(30, ScoreCalculator.calculateSmallStraight(dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreLargeStraightZero1() {
        int[] dices = {1, 2, 2, 2, 4};
        try {
            assertEquals(0, ScoreCalculator.calculateLargeStraight(dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreLargeStraightZero2() {
        int[] dices = {1, 2, 3, 2, 4};
        try {
            assertEquals(0, ScoreCalculator.calculateLargeStraight(dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreLargeStraightZero3() {
        int[] dices = {5, 2, 3, 2, 4};
        try {
            assertEquals(0, ScoreCalculator.calculateLargeStraight(dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreLargeStraightGood1() {
        int[] dices = {5, 2, 3, 6, 4};
        try {
            assertEquals(40, ScoreCalculator.calculateLargeStraight(dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreLargeStraightGood2() {
        int[] dices = {5, 2, 3, 1, 4};
        try {
            assertEquals(40, ScoreCalculator.calculateLargeStraight(dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreFullHouseZero1() {
        int[] dices = {5, 2, 3, 1, 4};
        try {
            assertEquals(0, ScoreCalculator.calculateFullHouse(dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreFullHouseZero2() {
        int[] dices = {2, 2, 2, 2, 4};
        try {
            assertEquals(0, ScoreCalculator.calculateFullHouse(dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreFullHouseZero3() {
        int[] dices = {2, 2, 3, 3, 4};
        try {
            assertEquals(0, ScoreCalculator.calculateFullHouse(dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreFullHouseGood1() {
        int[] dices = {2, 2, 2, 4, 4};
        try {
            assertEquals(25, ScoreCalculator.calculateFullHouse(dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreFullHouseGood2() {
        int[] dices = {2, 2, 2, 6, 6};
        try {
            assertEquals(25, ScoreCalculator.calculateFullHouse(dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreKniffleZero1() {
        int[] dices = {2, 2, 2, 6, 6};
        try {
            assertEquals(0, ScoreCalculator.calculateKniffel(dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreKniffleZero2() {
        int[] dices = {2, 2, 2, 2, 1};
        try {
            assertEquals(0, ScoreCalculator.calculateKniffel(dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreKniffleGood1() {
        int[] dices = {2, 2, 2, 2, 2};
        try {
            assertEquals(50, ScoreCalculator.calculateKniffel(dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreKniffleGood2() {
        int[] dices = {1, 1, 1, 1, 1};
        try {
            assertEquals(50, ScoreCalculator.calculateKniffel(dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreChance1() {
        int[] dices = {1, 1, 1, 1, 1};
        try {
            assertEquals(5, ScoreCalculator.sumAll(dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreChance2() {
        int[] dices = {2, 2, 1, 1, 1};
        try {
            assertEquals(7, ScoreCalculator.sumAll(dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void calcScoreChance3() {
        int[] dices = {1, 4, 1, 5, 3};
        try {
            assertEquals(14, ScoreCalculator.sumAll(dices));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }


}


