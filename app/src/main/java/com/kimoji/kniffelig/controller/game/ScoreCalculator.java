package com.kimoji.kniffelig.controller.game;

import java.util.Arrays;


public class ScoreCalculator {

    public static final int ACES_CALCULATION_HELPER = 1;
    public static final int TWOS_CALCULATION_HELPER = 2;
    public static final int THREES_CALCULATION_HELPER = 3;
    public static final int FOURS_CALCULATION_HELPER = 4;
    public static final int FIVES_CALCULATION_HELPER = 5;
    public static final int SIXES_CALCULATION_HELPER = 6;
    public static final int THREE_OF_A_KIND_CALCULATION_HELPER = 3;
    public static final int FOUR_OF_A_KIND_CALCULATION_HELPER = 4;

    public static final int FULLHOUSE_VALUE = 25;
    public static final int SMALL_STRAIGHT_VALUE = 30;
    public static final int LARGE_STRAIGHT_VALUE = 40;
    public static final int KNIFFEL_VALUE = 50;


    public static int getCalculationHelper(ScoreType score) throws IllegalArgumentException {
        switch (score) {
            case ACES:
                return ACES_CALCULATION_HELPER;
            case TWOS:
                return TWOS_CALCULATION_HELPER;
            case THREES:
                return THREES_CALCULATION_HELPER;
            case FOURS:
                return FOURS_CALCULATION_HELPER;
            case FIVES:
                return FIVES_CALCULATION_HELPER;
            case SIXES:
                return SIXES_CALCULATION_HELPER;
            case THREE_OF_A_KIND:
                return THREE_OF_A_KIND_CALCULATION_HELPER;
            case FOUR_OF_A_KIND:
                return FOUR_OF_A_KIND_CALCULATION_HELPER;
        }
        throw new IllegalArgumentException("THIS ENUM HAS NO CALCULATION HELPER");
    }

    public static int calculateSmallStraight(int[] dices) {
        int[] amount = getAmount(dices);
        int counter = 0;
        for (int val : amount) {
            if (val != 0) {
                counter++;
            } else {
                counter = 0;
            }
            if (counter == 4) return SMALL_STRAIGHT_VALUE;
        }
        return 0;
    }

    public static int calculateLargeStraight(int[] dices) {
        Arrays.sort(dices);
        for (int i = 0; i < dices.length; i++) {
            if (i != dices.length - 1) {
                if (dices[i] + 1 != dices[i + 1]) {
                    return 0;
                }
            }
        }
        return LARGE_STRAIGHT_VALUE;
    }

    public static int sumAll(int[] dices) {
        int result = 0;
        for (int dice : dices) {
            result += dice;
        }
        return result;
    }

    public static int calculateUpperScore(ScoreType score, int[] dices) {
        int result = 0;
        int value = getCalculationHelper(score);
        for (int dice : dices) {
            if (dice == value) {
                result += value;
            }
        }
        return result;
    }

    public static int calculateSomeOfAKind(ScoreType scoreType, int[] dices) {
        int[] amount = getAmount(dices);
        int calculationHelper = getCalculationHelper(scoreType);
        for (int val : amount) {
            if (val >= calculationHelper) return sumAll(dices);
        }
        return 0;
    }


    public static int calculateFullHouse(int[] dices) {
        // an amount-array of a fullhouse will always contain four 0 one 2 and one 3
        // therefor an amount-array of that amount-fullhouse-array will always contain
        // on index 1 and 2 the value 1 and an all other index value 0
        int[] amountOfAmount = getAmount(getAmount(dices));
        if (amountOfAmount[1] == 1 && amountOfAmount[2] == 1) {
            return FULLHOUSE_VALUE;
        }
        return 0;
    }

    public static int calculateKniffel(int[] dices) {
        int[] amount = getAmount(dices);
        for (int val : amount) {
            if (val == 5) return KNIFFEL_VALUE;
        }
        return 0;
    }

    private static int[] getAmount(int[] dices) {
        int[] amount = new int[6];
        for (int dice : dices) {
            if (dice != 0) amount[dice - 1] = amount[dice - 1] + 1;
        }
        return amount;
    }

    private static void checkArrayLength(int[] dices) throws IllegalArgumentException {
        if (dices.length != 5) {
            throw new IllegalArgumentException("int Array should only contain 5 values");
        }
    }
}
