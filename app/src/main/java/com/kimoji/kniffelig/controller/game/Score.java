package com.kimoji.kniffelig.controller.game;

public enum Score {
    ACES, TWOS, THREES, FOURS, FIVES, SIXES, THREEOFAKIND, FOUROFAKIND, FULLHOUSE, SMALLSTRAIGHT, LARGESTRAIGHT,
    KNIFFEL, CHANCE;

    private int index;
    private int value;

    static {
        int index = 0;
        for (Score s : Score.values()) {
            s.index = index;
            index++;
        }
    }

    static {
        ACES.value = 1;
        TWOS.value = 2;
        THREES.value = 3;
        FOURS.value = 4;
        FIVES.value = 5;
        SIXES.value = 6;
        THREEOFAKIND.value = 3;
        FOUROFAKIND.value = 4;
        FULLHOUSE.value = 25;
        SMALLSTRAIGHT.value = 30;
        LARGESTRAIGHT.value = 40;
        KNIFFEL.value = 50;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }
}
