package com.kimoji.kniffelig.controller.game;

public enum ScoreType {
    ACES, TWOS, THREES, FOURS, FIVES, SIXES, THREE_OF_A_KIND, FOUR_OF_A_KIND, FULLHOUSE, SMALL_STRAIGHT, LARGE_STRAIGHT,
    KNIFFEL, CHANCE;

    private String text;

    static {
        ACES.text = "Aces";
        TWOS.text = "Twos";
        THREES.text = "Threes";
        FOURS.text = "Fours";
        FIVES.text = "Fives";
        SIXES.text = "Sixes";
        THREE_OF_A_KIND.text = "TOAK";
        FOUR_OF_A_KIND.text = "FOAK";
        FULLHOUSE.text = "Full House";
        SMALL_STRAIGHT.text = "Small S";
        LARGE_STRAIGHT.text = "Large S";
        KNIFFEL.text = "Kniffel";
        CHANCE.text = "Chance";
    }

    public static ScoreType getScore(String name) {
        switch (name) {
            case "Aces":
                return ACES;
            case "Twos":
                return TWOS;
            case "Threes":
                return THREES;
            case "Fours":
                return FOURS;
            case "Fives":
                return FIVES;
            case "Sixes":
                return SIXES;
            case "TOAK":
                return THREE_OF_A_KIND;
            case "FOAK":
                return FOUR_OF_A_KIND;
            case "Full House":
                return FULLHOUSE;
            case "Small S":
                return SMALL_STRAIGHT;
            case "Large S":
                return LARGE_STRAIGHT;
            case "Kniffel":
                return KNIFFEL;
            case "Chance":
                return CHANCE;
            default:
                return null;
        }
    }
}
