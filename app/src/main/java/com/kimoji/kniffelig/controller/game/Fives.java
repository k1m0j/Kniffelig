package com.kimoji.kniffelig.controller.game;

class Fives extends ScoreClass {

    @Override
    public int calculateScore(int[] diceValues) {
        return ScoreCalculator.calcUpperScore(UpperScore.FIVES, diceValues);
    }
}
