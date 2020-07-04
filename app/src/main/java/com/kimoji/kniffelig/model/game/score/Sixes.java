package com.kimoji.kniffelig.model.game.score;

import com.kimoji.kniffelig.controller.game.ScoreCalculator;

import java.io.Serializable;

import static com.kimoji.kniffelig.controller.game.ScoreType.SIXES;

public class Sixes extends Score implements Serializable {

    @Override
    public int calculateScore(int[] diceValues) {
        return ScoreCalculator.calculateUpperScore(SIXES, diceValues);
    }
}
