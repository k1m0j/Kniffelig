package com.kimoji.kniffelig.model.game;


import java.io.Serializable;

public class DiceImp implements Dice, Serializable {
    private static final String TAG = DiceImp.class.getSimpleName();

    private final int DICE_MIN = 1;
    private final int DICE_MAX = 6;

    private int value;
    private boolean locked;

    public DiceImp() {
        this.value = 1;
        this.locked = false;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) throws IllegalArgumentException {
        if (value < DICE_MIN || value > DICE_MAX) {
            throw new IllegalArgumentException("Dice Value not in MIN MAX range");
        } else {
            this.value = value;
        }
    }

    @Override
    public boolean isLocked() {
        return locked;
    }

    @Override
    public void lock() {
        this.locked = true;
    }

    @Override
    public void unlock() {
        this.locked = false;
    }

    @Override
    public void toggleLock() {
        locked = !locked;
    }
}
