package com.kimoji.kniffelig.model.score;

import com.kimoji.kniffelig.controller.game.ScoreCalculator;

import java.io.Serializable;

import static com.kimoji.kniffelig.controller.game.ScoreType.FOUR_OF_A_KIND;

public class FourOfAKind extends Score implements Serializable {

    @Override
    public int calculateScore(int[] diceValues) {
        return ScoreCalculator.calculateSomeOfAKind(FOUR_OF_A_KIND, diceValues);
    }
}
