package com.kimoji.kniffelig.model.game;

public class GameStatusImp implements GameStatus {

    private int activePlayer;
    private int currentRound;
    private int leftTries;


    public GameStatusImp(int activePlayer, int currentRound, int leftTries) {
        this.activePlayer = activePlayer;
        this.currentRound = currentRound;
        this.leftTries = leftTries;
    }

    @Override
    public int getActivePlayer() {
        return activePlayer;
    }

    @Override
    public int getCurrentRound() {
        return currentRound;
    }

    @Override
    public int getLeftTries() {
        return leftTries;
    }

    @Override
    public void setActivePlayer(int activePlayer) {
        this.activePlayer = activePlayer;
    }

    @Override
    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    @Override
    public void setLeftTries(int leftTries) {
        this.leftTries = leftTries;
    }
}
