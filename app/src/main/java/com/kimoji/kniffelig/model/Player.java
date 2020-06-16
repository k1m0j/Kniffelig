package com.kimoji.kniffelig.model;

import com.kimoji.kniffelig.controller.game.Score;

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
    int[] getScores();

    /**
     * Overwrite all scores of this player
     *
     * @param scores new scores
     */
    void setScores(int[] scores);

    /**
     * Returning the points for a specific score
     *
     * @param score identifying score
     * @return points for the specified score
     */
    int getScore(Score score);

    /**
     * Setting a specific score score to a given value
     *
     * @param score       specific score
     * @param actualScore new score value
     */
    void setScore(Score score, int actualScore);
}
