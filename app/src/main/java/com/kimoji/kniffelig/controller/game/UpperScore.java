package com.kimoji.kniffelig.controller.game;

enum UpperScore {
    ACES(1), TWOS(2), THREES(3), FOURS(4), FIVES(5), SIXES(6);

    private UpperScore(int number) {
        this.number = number;
    }
     public final int number;
}
