package com.kimoji.kniffelig.controller.game;

class Twos extends ScoreClass {

    @Override
    public int calculateScore(int[] diceValues) {
        return ScoreCalculator.calcUpperScore(UpperScore.TWOS, diceValues);
    }
}
