package com.kimoji.kniffelig.model.game;

import com.kimoji.kniffelig.controller.game.ScoreType;

public class PlayerImp implements Player {


    private String name;
    private int[] scores = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};


    public PlayerImp(String name, int[] scores) {
        this.name = name;
        this.scores = scores;
    }

    public PlayerImp(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int[] getScores() {
        return scores;
    }

    @Override
    public void setScores(int[] scores) {
        this.scores = scores;
    }

    @Override
    public int getScore(ScoreType scoreType) {
        return scores[scoreType.getIndex()];
    }

    @Override
    public void setScore(ScoreType scoreType, int actualScore) {
        scores[scoreType.getIndex()] = actualScore;
    }
}
