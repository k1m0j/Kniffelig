package com.kimoji.kniffelig.controller.game;

import com.kimoji.kniffelig.exception.InvalidUserInteractionException;
import com.kimoji.kniffelig.model.GameStatus;
import com.kimoji.kniffelig.model.Player;

import java.util.LinkedList;

/**
 * Interface for the game controller
 */
public interface Playground {

    /**
     * Shakes all unlocked dices
     *
     * @throws InvalidUserInteractionException thrown when there are no shake tries left for current player
     */
    void shake() throws InvalidUserInteractionException;

    /**
     * Locks a specific dice
     *
     * @param index index of the dice
     */
    void lockDice(int index);

    /**
     * Unlocks a specific dice
     *
     * @param index index of the dice
     */
    void unlockDice(int index);

    /**
     * Adding a points of a specified score to the current active player
     *
     * @param scoreType specified score
     */
    void addScore(ScoreType scoreType);

    /**
     * Returning the left tries for the active player this round
     *
     * @return
     */
    int getLeftTries();

    /**
     * Returning the current round number
     *
     * @return current round number
     */
    int getCurrentRound();

    /**
     * Returning the index of the current active player
     *
     * @return index
     */
    int getActivePlayer();

    /**
     * Returning the name of the current active player
     *
     * @return
     */
    String getActivePlayerName();

    /**
     * Toggling the lock status of a specified dice
     *
     * @param index of the dice
     */
    void toggleLock(int index);

    /**
     * Returning the current dice values
     *
     * @return current dice values
     */
    int[] getCurrentDiceValues();

    /**
     * Checks if the specified dice is locked or not
     *
     * @param index of the dice
     * @return true if locked, false if unlocked
     */
    boolean isLocked(int index);

    LinkedList<Integer> getScores();

    String getPlayerName(int index);

    /**
     * Returns current gameStatus
     *
     * @return
     */
    GameStatus getGameStatus();

    /**
     * sets current gameStatus
     *
     * @param gameStatus
     */
    void setGameStatus(GameStatus gameStatus);

    /**
     * returns in game involved player
     *
     * @return
     */
    Player[] getAllPlayers();

    /**
     * sets players
     *
     * @param allPlayers
     */
    void setAllPlayers(Player[] allPlayers);

    /**
     * returns game Shaker
     *
     * @return Shaker
     */
    Shaker getShaker();

    void setShaker(Shaker shaker);

    LinkedList<Integer> getUpperTotals();

    LinkedList<Integer> getLowerTotals();

}
