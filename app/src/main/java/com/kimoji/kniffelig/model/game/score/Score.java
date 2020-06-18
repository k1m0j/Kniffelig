package com.kimoji.kniffelig.model.game.score;

public abstract class Score {
    private int value = 0;

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


    //TODO replace or jactor them
    private void checkArrayLength(int[] dices) throws IllegalArgumentException {
        if (dices.length != 5) {
            throw new IllegalArgumentException("int Array should only contain 5 values");
        }
    }
}
