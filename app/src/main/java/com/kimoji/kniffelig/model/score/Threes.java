package com.kimoji.kniffelig.model.score;

import com.kimoji.kniffelig.controller.game.ScoreCalculator;

import java.io.Serializable;

import static com.kimoji.kniffelig.controller.game.ScoreType.THREES;

public class Threes extends Score implements Serializable {

    @Override
    public int calculateScore(int[] diceValues) {
        return ScoreCalculator.calculateUpperScore(THREES, diceValues);
    }
}
