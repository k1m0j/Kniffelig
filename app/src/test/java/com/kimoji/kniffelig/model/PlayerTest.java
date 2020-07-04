package com.kimoji.kniffelig.model;

import com.kimoji.kniffelig.controller.game.ScoreType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PlayerTest {

    private Player testPlayer;
    private int[] scores;
    ScoreType scoreType = ScoreType.ACES; //TODO Mocken?


    @BeforeEach
    void setUp() {
        scores = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        // testPlayer = new PlayerImp("Peter Lustig", scores);


    }

    @Test
    void getName() {
        assertEquals("Peter Lustig", testPlayer.getName());
    }

    @Test
    void setName() {
        testPlayer.setName("Rip WEMO");
        assertEquals("Rip WEMO", testPlayer.getName());
    }


    @Test
    void getScores() {
        //    assertArrayEquals(scores, testPlayer.getScores());
    }

    @Test
    void setScores() {

    }

    @Test
    void getScore() {
    }

    @Test
    void setScore() {
    }
}