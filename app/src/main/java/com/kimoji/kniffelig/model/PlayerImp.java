package com.kimoji.kniffelig.model;


import com.kimoji.kniffelig.controller.game.ScoreType;
import com.kimoji.kniffelig.model.score.Aces;
import com.kimoji.kniffelig.model.score.Chance;
import com.kimoji.kniffelig.model.score.Fives;
import com.kimoji.kniffelig.model.score.FourOfAKind;
import com.kimoji.kniffelig.model.score.Fours;
import com.kimoji.kniffelig.model.score.Fullhouse;
import com.kimoji.kniffelig.model.score.Kniffel;
import com.kimoji.kniffelig.model.score.LargeStraight;
import com.kimoji.kniffelig.model.score.Score;
import com.kimoji.kniffelig.model.score.Sixes;
import com.kimoji.kniffelig.model.score.SmallStraight;
import com.kimoji.kniffelig.model.score.ThreeOfAKind;
import com.kimoji.kniffelig.model.score.Threes;
import com.kimoji.kniffelig.model.score.Twos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
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
    public LinkedList<Score> getScores() {
        LinkedList<Score> list = new LinkedList<>();
        list.add(scores.get(ACES));
        list.add(scores.get(TWOS));
        list.add(scores.get(THREES));
        list.add(scores.get(FOURS));
        list.add(scores.get(FIVES));
        list.add(scores.get(SIXES));
        list.add(scores.get(THREE_OF_A_KIND));
        list.add(scores.get(FOUR_OF_A_KIND));
        list.add(scores.get(FULLHOUSE));
        list.add(scores.get(SMALL_STRAIGHT));
        list.add(scores.get(LARGE_STRAIGHT));
        list.add(scores.get(KNIFFEL));
        list.add(scores.get(CHANCE));
        return list;
    }


    @Override
    public void addScore(ScoreType scoreType, int[] dicesValues) {
        scores.get(scoreType).addScoreToScoreboard(dicesValues);
    }

    @Override
    public int getUpperTotal() {
        int total = 0;
        total += scores.get(ACES).getValue();
        total += scores.get(TWOS).getValue();
        total += scores.get(THREES).getValue();
        total += scores.get(FOURS).getValue();
        total += scores.get(FIVES).getValue();
        total += scores.get(SIXES).getValue();
        return total;
    }

    @Override
    public int getLowerTotal() {
        int total = 0;
        total += scores.get(THREE_OF_A_KIND).getValue();
        total += scores.get(FOUR_OF_A_KIND).getValue();
        total += scores.get(FULLHOUSE).getValue();
        total += scores.get(SMALL_STRAIGHT).getValue();
        total += scores.get(LARGE_STRAIGHT).getValue();
        total += scores.get(KNIFFEL).getValue();
        total += scores.get(CHANCE).getValue();
        return total;
    }


}
