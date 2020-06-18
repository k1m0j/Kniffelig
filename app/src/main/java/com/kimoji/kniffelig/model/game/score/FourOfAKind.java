package com.kimoji.kniffelig.model.game.score;

import com.kimoji.kniffelig.controller.game.ScoreCalculator;

import static com.kimoji.kniffelig.controller.game.ScoreType.FOUR_OF_A_KIND;

public class FourOfAKind extends Score {

    @Override
    public int calculateScore(int[] diceValues) {
        return ScoreCalculator.calculateSomeOfAKind(FOUR_OF_A_KIND, diceValues);
    }
}
