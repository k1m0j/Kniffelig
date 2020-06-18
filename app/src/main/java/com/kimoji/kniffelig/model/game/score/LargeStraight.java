package com.kimoji.kniffelig.model.game.score;

import com.kimoji.kniffelig.controller.game.ScoreCalculator;

public class LargeStraight extends Score {
    @Override
    public int calculateScore(int[] diceValues) {
        return ScoreCalculator.calculateLargeStraight(diceValues);
    }
}