package com.kimoji.kniffelig.controller.game;

import java.util.Arrays;

import static com.kimoji.kniffelig.controller.game.Score.FULLHOUSE;


public class ScoreCalculator {

    public static int calcScore(Score score, int[] dices) throws IllegalArgumentException {
        checkArrayLength(dices);
        switch (score) {
            case ACES:
            case TWOS:
            case THREES:
            case FOURS:
            case FIVES:
            case SIXES:
                return calcUpperScore(score, dices);
            case THREEOFAKIND:
            case FOUROFAKIND:
                return calcOfAKind(score, dices);
            case FULLHOUSE:
                return calcFullHouse(dices);
            case SMALLSTRAIGHT:
                return calcSmallStraight(dices);
            case LARGESTRAIGHT:
                return calcLargeStraight(dices);
            case KNIFFEL:
                return calcKniffel(dices);
            case CHANCE:
                return sumAll(dices);
        }
        return -1;
    }

    private static int calcSmallStraight(int[] dices) {
        int[] amount = getAmount(dices);
        int counter = 0;
        for (int val : amount) {
            if (val != 0) {
                counter++;
            } else {
                counter = 0;
            }
            if (counter == 4) return Score.SMALLSTRAIGHT.getValue();
        }
        return 0;
    }

    private static int calcLargeStraight(int[] dices) {
        Arrays.sort(dices);
        for (int i = 0; i < dices.length; i++) {
            if (i != dices.length - 1) {
                if (dices[i] + 1 != dices[i + 1]) {
                    return 0;
                }
            }
        }
        return Score.LARGESTRAIGHT.getValue();
    }

    public static int sumAll(int[] dices) {
        int result = 0;
        for (int dice : dices) {
            result += dice;
        }
        return result;
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

    private static int calcUpperScore(Score score, int[] dices) {
        int result = 0;
        int value = score.getValue();
        for (int dice : dices) {
            if (dice == value) {
                result += value;
            }
        }
        return result;
    }

    private static int calcOfAKind(Score score, int[] dices) {
        int[] amount = getAmount(dices);
        for (int val : amount) {
            if (val >= score.getValue()) return sumAll(dices);
        }
        return 0;
    }

    private static int calcFullHouse(int[] dices) {
        // an amount-array of a fullhouse will always contain four 0 one 2 and one 3
        // therefor an amount-array of that amount-fullhouse-array will always contain
        // on index 1 and 2 the value 1 and an all other index value 0
        int[] amountOfAmount = getAmount(getAmount(dices));
        if (amountOfAmount[1] == 1 && amountOfAmount[2] == 1) {
            return FULLHOUSE.getValue();
        }
        return 0;
    }

    private static int calcKniffel(int[] dices) {
        int[] amount = getAmount(dices);
        for (int val : amount) {
            if (val == 5) return Score.KNIFFEL.getValue();
        }
        return 0;
    }
}
