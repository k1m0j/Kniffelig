package com.kimoji.kniffelig.model.game.score;

import com.kimoji.kniffelig.controller.game.ScoreCalculator;

import static com.kimoji.kniffelig.controller.game.ScoreType.TWOS;

public class Twos extends Score {

    @Override
    public int calculateScore(int[] diceValues) {
        return ScoreCalculator.calculateUpperScore(TWOS, diceValues);
    }
}