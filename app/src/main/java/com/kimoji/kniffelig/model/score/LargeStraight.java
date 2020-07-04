package com.kimoji.kniffelig.model.score;

import com.kimoji.kniffelig.controller.game.ScoreCalculator;

import java.io.Serializable;

public class LargeStraight extends Score implements Serializable {
    @Override
    public int calculateScore(int[] diceValues) {
        return ScoreCalculator.calculateLargeStraight(diceValues);
    }
}
