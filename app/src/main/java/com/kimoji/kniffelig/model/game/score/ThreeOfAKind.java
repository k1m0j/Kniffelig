package com.kimoji.kniffelig.model.game.score;

import com.kimoji.kniffelig.controller.game.ScoreCalculator;

import static com.kimoji.kniffelig.controller.game.ScoreType.THREE_OF_A_KIND;

public class ThreeOfAKind extends Score {
    @Override
    public int calculateScore(int[] diceValues) {
        return ScoreCalculator.calculateSomeOfAKind(THREE_OF_A_KIND, diceValues);
    }
}
