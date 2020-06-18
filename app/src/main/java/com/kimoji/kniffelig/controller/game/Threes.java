package com.kimoji.kniffelig.controller.game;

class Threes extends ScoreClass {

    @Override
    public int calculateScore(int[] diceValues) {
        return ScoreCalculator.calcUpperScore(UpperScore.THREES, diceValues);
    }
}
