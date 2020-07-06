package com.kimoji.kniffelig.model.score;

import java.io.Serializable;

public abstract class Score implements Serializable {
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

    public boolean isFilledIn() {
        return filledIn;
    }
}
