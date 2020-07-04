package com.kimoji.kniffelig.model.game.score;

import com.kimoji.kniffelig.controller.game.ScoreCalculator;

import java.io.Serializable;

import static com.kimoji.kniffelig.controller.game.ScoreType.FOURS;

public class Fours extends Score implements Serializable {

    @Override
    public int calculateScore(int[] diceValues) {
        return ScoreCalculator.calculateUpperScore(FOURS, diceValues);
    }
}
