package com.kimoji.kniffelig.model.game.score;

import com.kimoji.kniffelig.controller.game.ScoreCalculator;

public class Fullhouse extends Score {
    @Override
    public int calculateScore(int[] diceValues) {
        return ScoreCalculator.calculateFullHouse(diceValues);
    }
}
