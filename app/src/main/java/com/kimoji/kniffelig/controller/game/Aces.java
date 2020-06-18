package com.kimoji.kniffelig.controller.game;

import com.kimoji.kniffelig.view.game.ScoreFragment;

public class Aces extends ScoreClass {

    @Override
    public int calculateScore(int[] diceValues) {
        return ScoreCalculator.calcUpperScore(UpperScore.ACES, diceValues);
    }
}
