package com.kimoji.kniffelig.model.game.score;

import com.kimoji.kniffelig.controller.game.ScoreCalculator;

import static com.kimoji.kniffelig.controller.game.ScoreType.THREES;

public class Threes extends Score {

    @Override
    public int calculateScore(int[] diceValues) {
        return ScoreCalculator.calculateUpperScore(THREES, diceValues);
    }
}
