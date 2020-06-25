package com.kimoji.kniffelig.model.game;


import com.kimoji.kniffelig.controller.game.ScoreType;
import com.kimoji.kniffelig.model.game.score.Aces;
import com.kimoji.kniffelig.model.game.score.Chance;
import com.kimoji.kniffelig.model.game.score.Fives;
import com.kimoji.kniffelig.model.game.score.FourOfAKind;
import com.kimoji.kniffelig.model.game.score.Fours;
import com.kimoji.kniffelig.model.game.score.Fullhouse;
import com.kimoji.kniffelig.model.game.score.Kniffel;
import com.kimoji.kniffelig.model.game.score.LargeStraight;
import com.kimoji.kniffelig.model.game.score.Score;
import com.kimoji.kniffelig.model.game.score.Sixes;
import com.kimoji.kniffelig.model.game.score.SmallStraight;
import com.kimoji.kniffelig.model.game.score.ThreeOfAKind;
import com.kimoji.kniffelig.model.game.score.Threes;
import com.kimoji.kniffelig.model.game.score.Twos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import static com.kimoji.kniffelig.controller.game.ScoreType.ACES;
import static com.kimoji.kniffelig.controller.game.ScoreType.CHANCE;
import static com.kimoji.kniffelig.controller.game.ScoreType.FIVES;
import static com.kimoji.kniffelig.controller.game.ScoreType.FOURS;
import static com.kimoji.kniffelig.controller.game.ScoreType.FOUR_OF_A_KIND;
import static com.kimoji.kniffelig.controller.game.ScoreType.FULLHOUSE;
import static com.kimoji.kniffelig.controller.game.ScoreType.KNIFFEL;
import static com.kimoji.kniffelig.controller.game.ScoreType.LARGE_STRAIGHT;
import static com.kimoji.kniffelig.controller.game.ScoreType.SIXES;
import static com.kimoji.kniffelig.controller.game.ScoreType.SMALL_STRAIGHT;
import static com.kimoji.kniffelig.controller.game.ScoreType.THREES;
import static com.kimoji.kniffelig.controller.game.ScoreType.THREE_OF_A_KIND;
import static com.kimoji.kniffelig.controller.game.ScoreType.TWOS;

public class PlayerImp implements Player, Serializable {


    private String name;

    private Map<ScoreType, Score> scores = new HashMap<ScoreType, Score>() {{
        put(ACES, new Aces());
        put(TWOS, new Twos());
        put(THREES, new Threes());
        put(FOURS, new Fours());
        put(FIVES, new Fives());
        put(SIXES, new Sixes());
        put(THREE_OF_A_KIND, new ThreeOfAKind());
        put(FOUR_OF_A_KIND, new FourOfAKind());
        put(FULLHOUSE, new Fullhouse());
        put(SMALL_STRAIGHT, new SmallStraight());
        put(LARGE_STRAIGHT, new LargeStraight());
        put(KNIFFEL, new Kniffel());
        put(CHANCE, new Chance());
    }};


    public PlayerImp(String name, Map<ScoreType, Score> scores) {
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
    public Score getScore(ScoreType scoreType) {
        return scores.get(scoreType);
    }

    @Override
    public int getScoreValue(ScoreType scoreType) {
        return scores.get(scoreType).getValue();
    }

    @Override
    public void setScore(ScoreType scoreType, int actualScore) {
        scores.get(scoreType).setValue(actualScore);
    }

    @Override
    public Map<ScoreType, Score> getScores() {
        return scores;
    }

    @Override
    public void setScores(Map<ScoreType, Score> scores) {
        this.scores = scores;
    }
}
