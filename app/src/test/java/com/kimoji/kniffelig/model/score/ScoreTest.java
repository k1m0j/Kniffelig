package com.kimoji.kniffelig.model.score;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class ScoreTest {

    @Test
    public void testInit() {
        Score score = new Aces();
        assertFalse(score.isFilledIn());
        assertEquals(0, score.getValue());
    }

    @Test
    public void testAddScore() {
        Score score = new Aces();
        score.addScoreToScoreboard(new int[]{2, 2, 2, 2, 2});
        assertTrue(score.isFilledIn());
    }

}