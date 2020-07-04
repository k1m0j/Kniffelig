package com.kimoji.kniffelig.model.game.score;

import com.kimoji.kniffelig.controller.game.ScoreCalculator;

import java.io.Serializable;

import static com.kimoji.kniffelig.controller.game.ScoreType.TWOS;

public class Twos extends Score implements Serializable {

    @Override
    public int calculateScore(int[] diceValues) {
        return ScoreCalculator.calculateUpperScore(TWOS, diceValues);
    }
}
