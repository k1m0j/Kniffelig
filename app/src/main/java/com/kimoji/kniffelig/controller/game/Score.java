package com.kimoji.kniffelig.controller.game;

public enum Score {
    ACES, TWOS, THREES, FOURS, FIVES, SIXES, THREEOFAKIND, FOUROFAKIND, FULLHOUSE, SMALLSTRAIGHT, LARGESTRAIGHT,
    KNIFFEL, CHANCE;

    private int index;
    private int value;
    private String text;

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

    static {
        ACES.text = "Aces";
        TWOS.text = "Twos";
        THREES.text = "Threes";
        FOURS.text = "Fours";
        FIVES.text = "Fives";
        SIXES.text = "Sixes";
        THREEOFAKIND.text = "TOAK";
        FOUROFAKIND.text = "FOAK";
        FULLHOUSE.text = "Full House";
        SMALLSTRAIGHT.text = "Small S";
        LARGESTRAIGHT.text = "Large S";
        KNIFFEL.text = "Kniffel";
        CHANCE.text = "Chance";
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }

    public static Score getScore(String name){
        switch (name){
            case  "Aces": return ACES;
            case  "Twos": return TWOS;
            case "Threes": return THREES;
            case  "Fours": return FOURS;
            case  "Fives": return FIVES;
            case  "Sixes": return SIXES;
            case  "TOAK": return THREEOFAKIND;
            case  "FOAK": return FOUROFAKIND;
            case  "Full House": return FULLHOUSE;
            case  "Small S": return SMALLSTRAIGHT;
            case  "Large S": return LARGESTRAIGHT;
            case  "Kniffel": return KNIFFEL;
            case  "Chance": return CHANCE;
            default: return null;
        }
    }
}
