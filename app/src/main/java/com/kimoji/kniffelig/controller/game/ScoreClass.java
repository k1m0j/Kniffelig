package com.kimoji.kniffelig.controller.game;

public abstract class ScoreClass {
    private int value;

    public abstract int calculateScore(int[] diceValues);

    public void addScoreToScoreboard(int[] diceValues) {
        setValue(calculateScore(diceValues));
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
