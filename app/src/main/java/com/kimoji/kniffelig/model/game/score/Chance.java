package com.kimoji.kniffelig.model.game.score;

import com.kimoji.kniffelig.controller.game.ScoreCalculator;

public class Chance extends Score {
    @Override
    public int calculateScore(int[] diceValues) {
        return ScoreCalculator.sumAll(diceValues);
    }
}
