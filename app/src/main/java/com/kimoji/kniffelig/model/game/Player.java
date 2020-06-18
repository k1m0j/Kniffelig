package com.kimoji.kniffelig.model.game;

import com.kimoji.kniffelig.controller.game.ScoreType;
import com.kimoji.kniffelig.model.game.score.Score;

import java.util.Map;

/**
 * Interface for the player model
 */
public interface Player {
    /**
     * Returning the name of the Player
     *
     * @return name of player
     */
    String getName();

    /**
     * Setting the name of the Player
     *
     * @param name nam of the Player
     */
    void setName(String name);

    /**
     * Returning all the scores from this customer
     *
     * @return all scores
     */
    Map<ScoreType, Score> getScores();

    /**
     * Returning the points for a specific score
     *
     * @param scoreType identifying score
     * @return points for the specified score
     */
    Score getScore(ScoreType scoreType);

    /**
     * Setting a specific score score to a given value
     *
     * @param scoreType   specific score
     * @param actualScore new score value
     */
    void setScore(ScoreType scoreType, int actualScore);

    //TODO
    int getScoreValue(ScoreType scoreType);

    void setScores(Map<ScoreType, Score> scores);
}
