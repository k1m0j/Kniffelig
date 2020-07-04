package com.kimoji.kniffelig.model;

/**
 * Interface for the game status model
 */
public interface GameStatus {

    /**
     * Return the current round number
     *
     * @return current round number
     */
    int getCurrentRound();

    /**
     * Returns the index of the current active player
     *
     * @return index
     */
    int getActivePlayer();

    /**
     * Returns the amount of left tries to shake for this players turn
     *
     * @return number of left tries
     */
    int getLeftTries();

    /**
     * Update the current round number
     *
     * @param currentRound round number
     */
    void setCurrentRound(int currentRound);

    /**
     * Update the new current player index
     *
     * @param activePlayer new index
     */
    void setActivePlayer(int activePlayer);

    /**
     * Updates the new value for left tries for this players round
     *
     * @param leftTries new value for left tries
     */
    void setLeftTries(int leftTries);
}
