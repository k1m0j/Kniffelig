package com.kimoji.kniffelig.model.game.score;

import com.kimoji.kniffelig.exception.InvalidUserInteractionException;

public abstract class Score {
    private int value = 0;

    private boolean filledIn = false;

    public abstract int calculateScore(int[] diceValues);

    public void addScoreToScoreboard(int[] diceValues) {
        if (!filledIn) {
            setValue(calculateScore(diceValues));
            filledIn = true;
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    //TODO replace or jactor them
    private void checkArrayLength(int[] dices) throws IllegalArgumentException {
        if (dices.length != 5) {
            throw new IllegalArgumentException("int Array should only contain 5 values");
        }
    }
}
