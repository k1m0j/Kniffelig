package com.kimoji.kniffelig.controller.game;

public class Fours extends ScoreClass {

    @Override
    public int calculateScore(int[] diceValues) {
        return ScoreCalculator.calcUpperScore(UpperScore.FOURS, diceValues);
    }
}
