package com.kimoji.kniffelig.controller.game;

class Sixes extends ScoreClass {

    @Override
    public int calculateScore(int[] diceValues) {
        return ScoreCalculator.calcUpperScore(UpperScore.SIXES, diceValues);
    }
}
