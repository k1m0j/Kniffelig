package com.kimoji.kniffelig.model;

/**
 * Interface for the dice model.
 */
public interface Dice {
    /**
     * Returning the current value of this dice
     *
     * @return current value
     */
    int getValue();

    /**
     * Setting a new value for the dice. Used f.e. to recreate a saved game
     *
     * @param value new dice value
     * @throws IllegalArgumentException thrown when the value given value is not between 1 and 6 (included)
     */
    void setValue(int value) throws IllegalArgumentException;

    /**
     * Returning a boolean for the lock status of this dice
     *
     * @return true if dice locked, false if unlocked
     */
    boolean isLocked();

    /**
     * Locking the dice
     */
    void lock();

    /**
     * Unlocking the dice
     */
    void unlock();

    /**
     * Change the current dice lock status the the opposite value
     */
    void toggleLock();
}
