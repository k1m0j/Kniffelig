package com.kimoji.kniffelig.controller.game;

import com.kimoji.kniffelig.exception.InvalidUserInteractionException;
import com.kimoji.kniffelig.model.GameStatus;
import com.kimoji.kniffelig.model.GameStatusImp;
import com.kimoji.kniffelig.model.Player;
import com.kimoji.kniffelig.model.PlayerImp;

import java.util.LinkedList;

public class PlaygroundImp implements Playground {

    private Shaker shaker = new Shaker();
    private static final int ROUND_NUMBER = 13;
    private static final int TRIES = 3;

    private Player[] allPlayers;

    private GameStatus gameStatus;


    public PlaygroundImp(String[] playerNames) {
        gameStatus = new GameStatusImp(0, 0, 2);
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
            shaker.shake();
            gameStatus.setLeftTries(gameStatus.getLeftTries() - 1);
        } else {
            throw new InvalidUserInteractionException("There are no left tries for " + allPlayers[gameStatus.getActivePlayer()].getName() + "!");
        }
    }

    @Override
    public void lockDice(int index) {
        shaker.lockDice(index);
    }

    @Override
    public void unlockDice(int index) {
        shaker.freeDice(index);
    }

    @Override
    public void toggleLock(int index) {
        shaker.toggleLock(index);
    }

    @Override
    public int[] getCurrentDiceValues() {
        return shaker.getValues();
    }

    @Override
    public boolean isLocked(int index) {
        return shaker.isLocked(index);
    }

    @Override
    public void addScore(ScoreType scoreType) {
        if (gameStatus.getCurrentRound() < ROUND_NUMBER) {
            try {
                if (!allPlayers[getActivePlayer()].getScore(scoreType).isFilledIn()) {
                    allPlayers[getActivePlayer()].addScore(scoreType, shaker.getValues());
                    gameStatus.setLeftTries(TRIES);
                    if (getActivePlayer() == allPlayers.length - 1) {
                        gameStatus.setCurrentRound(getCurrentRound() + 1);
                    }
                    shaker.setAllFree();
                    setNextPlayer();
                    shake();
                }
            } catch (InvalidUserInteractionException e) {
                e.printStackTrace();
            }
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

    public LinkedList<Integer> getScores() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < allPlayers.length; i++) {
            allPlayers[i].getScores().forEach(score -> list.add(score.getValue()));
        }
        return list;
    }

    @Override
    public String getPlayerName(int index) {
        if (index >= allPlayers.length) {
            return "";
        } else {
            return allPlayers[index].getName();
        }
    }

    @Override
    public LinkedList<Integer> getUpperTotals() {
        LinkedList<Integer> upperTotals = new LinkedList<>();
        for (Player player : allPlayers) {
            upperTotals.add(player.getUpperTotal());
        }
        return upperTotals;
    }

    @Override
    public LinkedList<Integer> getLowerTotals() {
        LinkedList<Integer> upperTotals = new LinkedList<>();
        for (Player player : allPlayers) {
            upperTotals.add(player.getLowerTotal());
        }
        return upperTotals;
    }

    @Override
    public GameStatus getGameStatus() {
        return gameStatus;
    }

    @Override
    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    @Override
    public void setAllPlayers(Player[] allPlayers) {
        this.allPlayers = allPlayers;
    }

    @Override
    public Player[] getAllPlayers() {
        return allPlayers;
    }


    private void setNextPlayer() {
        if (allPlayers.length - 1 == gameStatus.getActivePlayer()) {
            gameStatus.setActivePlayer(0);
        } else {
            gameStatus.setActivePlayer(getActivePlayer() + 1);

        }
    }

    @Override
    public Shaker getShaker() {
        return shaker;
    }

    @Override
    public void setShaker(Shaker shaker) {
        this.shaker = shaker;
    }
}

