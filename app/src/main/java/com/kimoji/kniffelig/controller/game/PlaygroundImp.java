package com.kimoji.kniffelig.controller.game;

import com.kimoji.kniffelig.exception.InvalidUserInteractionException;
import com.kimoji.kniffelig.model.game.GameStatusImp;
import com.kimoji.kniffelig.model.game.GameStatus;
import com.kimoji.kniffelig.model.game.PlayerImp;
import com.kimoji.kniffelig.model.game.Player;

public class PlaygroundImp implements Playground {

    private static final Shaker SHAKER = new Shaker();
    private static final int ROUND_NUMBER = 13;
    private static final int TRIES = 3;

    private Player[] allPlayers;

    private GameStatus gameStatus;


    public PlaygroundImp(String[] playerNames) {
        gameStatus = new GameStatusImp(0, 0, 3);
        Player[] newPlayers = new PlayerImp[playerNames.length];
        int index = 0;
        for (String name : playerNames) {
            newPlayers[index] = new PlayerImp(name);
            index++;
        }
        allPlayers = newPlayers;

    }

    @Override
    public void shake() throws InvalidUserInteractionException {
        if (gameStatus.getLeftTries() > 0) {
            SHAKER.shake();
            gameStatus.setLeftTries(gameStatus.getLeftTries() - 1);
        } else {
            throw new InvalidUserInteractionException("There are no left tries for " + allPlayers[gameStatus.getActivePlayer()].getName() + "!");
        }
    }

    @Override
    public void lockDice(int index) {
        SHAKER.lockDice(index);
    }

    @Override
    public void unlockDice(int index) {
        SHAKER.freeDice(index);
    }

    @Override
    public void toggleLock(int index) {
        SHAKER.toggleLock(index);
    }

    @Override
    public int[] getCurrentDiceValues() {
        return SHAKER.getValues();
    }

    @Override
    public boolean isLocked(int index) {
        return SHAKER.isLocked(index);
    }

    @Override
    public void addScore(ScoreType scoreType) {
        if (gameStatus.getCurrentRound() < ROUND_NUMBER) {
            int actualScore = ScoreCalculator.calcScore(scoreType, SHAKER.getValues());
            allPlayers[gameStatus.getActivePlayer()].setScore(scoreType, actualScore);
            gameStatus.setLeftTries(TRIES);
            gameStatus.setCurrentRound(getCurrentRound() + 1);
            SHAKER.setAllFree();
            setNextPlayer();
        } else {
            //TODO END OF GAME
        }
    }

    @Override
    public int getLeftTries() {
        return gameStatus.getLeftTries();
    }

    @Override
    public int getCurrentRound() {
        return gameStatus.getCurrentRound();
    }

    @Override
    public int getActivePlayer() {
        return gameStatus.getActivePlayer();
    }

    //todo checken
    @Override
    public String getActivePlayerName() {
        return allPlayers[getActivePlayer()].getName();
    }

    private void setNextPlayer() {
        if (allPlayers.length - 1 == gameStatus.getActivePlayer()) {
            gameStatus.setActivePlayer(0);
        } else {
            gameStatus.setActivePlayer(getActivePlayer() + 1);

        }
    }
}

