package com.kimoji.kniffelig.model;

import com.kimoji.kniffelig.controller.game.ScoreType;
import com.kimoji.kniffelig.model.score.Score;

import java.util.LinkedList;
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
    LinkedList<Score> getScores();

    /**
     * Returning the points for a specific score
     *
     * @param scoreType identifying score
     * @return points for the specified score
     */
    Score getScore(ScoreType scoreType);

    /**
     * returns upper total player score
     *
     * @return int
     */
    int getUpperTotal();

    /**
     * adds score to player
     *
     * @param scoreType
     * @param dicesValues
     */
    void addScore(ScoreType scoreType, int[] dicesValues);

    /**
     * returns lower total player score
     *
     * @return int
     */
    int getLowerTotal();
}
