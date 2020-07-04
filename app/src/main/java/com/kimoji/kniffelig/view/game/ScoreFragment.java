package com.kimoji.kniffelig.view.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.kimoji.kniffelig.R;
import com.kimoji.kniffelig.controller.game.ScoreType;
import com.kimoji.kniffelig.controller.game.Playground;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ScoreFragment extends Fragment {

    private static final String TAG = "ScoreFragment";

    private Playground playground;

    //UPPER SCORES
    private Button btnAces;
    private Button btnTwos;
    private Button btnThrees;
    private Button btnFours;
    private Button btnFives;
    private Button btnSixes;

    //LOWER SCORES
    private Button btnTOAK;
    private Button btnFOAK;
    private Button btnFullhouse;
    private Button btnSmallS;
    private Button btnLargeS;
    private Button btnKniffle;
    private Button btnChance;

    //SCORE TEXT VIEWS
    private List<TextView> scoreTextViews = new ArrayList<>();

    //UPPER TOTAL TEXT VIEWS
    private List<TextView> upperTotalTextViews = new LinkedList<>();
    private List<TextView> bonusTextViews = new LinkedList<>();
    private List<TextView> upperTotalWithBonusTextViews = new LinkedList<>();

    //LOWER TOTAL TEXT VIEWS
    private List<TextView> lowerTotalTextViews = new LinkedList<>();
    private List<TextView> lowerUpperTotalTextViews = new LinkedList<>();
    private List<TextView> finalTotalTextViews = new LinkedList<>();

    //PLAYER NAME TEXT VIEWS
    private TextView playerOneNameScore;
    private TextView playerTwoNameScore;
    private TextView playerThreeNameScore;
    private TextView playerFourNameScore;

    public ScoreFragment(Playground playground) {
        this.playground = playground;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.score_fragment, container, false);

        btnAces = view.findViewById(R.id.btn_aces);
        btnAces.setOnClickListener(this::addScore);

        btnTwos = view.findViewById(R.id.btn_twos);
        btnTwos.setOnClickListener(this::addScore);

        btnThrees = view.findViewById(R.id.btn_threes);
        btnThrees.setOnClickListener(this::addScore);

        btnFours = view.findViewById(R.id.btn_fours);
        btnFours.setOnClickListener(this::addScore);

        btnFives = view.findViewById(R.id.btn_fives);
        btnFives.setOnClickListener(this::addScore);

        btnSixes = view.findViewById(R.id.btn_sixes);
        btnSixes.setOnClickListener(this::addScore);

        btnTOAK = view.findViewById(R.id.btn_toak);
        btnTOAK.setOnClickListener(this::addScore);

        btnFOAK = view.findViewById(R.id.btn_foak);
        btnFOAK.setOnClickListener(this::addScore);

        btnFullhouse = view.findViewById(R.id.btn_fullHouse);
        btnFullhouse.setOnClickListener(this::addScore);

        btnSmallS = view.findViewById(R.id.btn_smallStraight);
        btnSmallS.setOnClickListener(this::addScore);

        btnLargeS = view.findViewById(R.id.btn_largeStraight);
        btnLargeS.setOnClickListener(this::addScore);

        btnKniffle = view.findViewById(R.id.btn_kniffle);
        btnKniffle.setOnClickListener(this::addScore);

        btnChance = view.findViewById(R.id.btn_chance);
        btnChance.setOnClickListener(this::addScore);

        scoreTextViews.add(view.findViewById(R.id.player_one_aces));
        scoreTextViews.add(view.findViewById(R.id.player_one_twos));
        scoreTextViews.add(view.findViewById(R.id.player_one_threes));
        scoreTextViews.add(view.findViewById(R.id.player_one_fours));
        scoreTextViews.add(view.findViewById(R.id.player_one_fives));
        scoreTextViews.add(view.findViewById(R.id.player_one_sixes));
        scoreTextViews.add(view.findViewById(R.id.player_one_three_of_a_kind));
        scoreTextViews.add(view.findViewById(R.id.player_one_four_of_a_kind));
        scoreTextViews.add(view.findViewById(R.id.player_one_full_house));
        scoreTextViews.add(view.findViewById(R.id.player_one_small_straight));
        scoreTextViews.add(view.findViewById(R.id.player_one_large_straight));
        scoreTextViews.add(view.findViewById(R.id.player_one_kniffel));
        scoreTextViews.add(view.findViewById(R.id.player_one_chance));

        scoreTextViews.add(view.findViewById(R.id.player_two_aces));
        scoreTextViews.add(view.findViewById(R.id.player_two_twos));
        scoreTextViews.add(view.findViewById(R.id.player_two_threes));
        scoreTextViews.add(view.findViewById(R.id.player_two_fours));
        scoreTextViews.add(view.findViewById(R.id.player_two_fives));
        scoreTextViews.add(view.findViewById(R.id.player_two_sixes));
        scoreTextViews.add(view.findViewById(R.id.player_two_three_of_a_kind));
        scoreTextViews.add(view.findViewById(R.id.player_two_four_of_a_kind));
        scoreTextViews.add(view.findViewById(R.id.player_two_full_house));
        scoreTextViews.add(view.findViewById(R.id.player_two_small_straight));
        scoreTextViews.add(view.findViewById(R.id.player_two_large_straight));
        scoreTextViews.add(view.findViewById(R.id.player_two_kniffel));
        scoreTextViews.add(view.findViewById(R.id.player_two_chance));

        scoreTextViews.add(view.findViewById(R.id.player_three_aces));
        scoreTextViews.add(view.findViewById(R.id.player_three_twos));
        scoreTextViews.add(view.findViewById(R.id.player_three_threes));
        scoreTextViews.add(view.findViewById(R.id.player_three_fours));
        scoreTextViews.add(view.findViewById(R.id.player_three_fives));
        scoreTextViews.add(view.findViewById(R.id.player_three_sixes));
        scoreTextViews.add(view.findViewById(R.id.player_three_three_of_a_kind));
        scoreTextViews.add(view.findViewById(R.id.player_three_four_of_a_kind));
        scoreTextViews.add(view.findViewById(R.id.player_three_full_house));
        scoreTextViews.add(view.findViewById(R.id.player_three_small_straight));
        scoreTextViews.add(view.findViewById(R.id.player_three_large_straight));
        scoreTextViews.add(view.findViewById(R.id.player_three_kniffel));
        scoreTextViews.add(view.findViewById(R.id.player_three_chance));

        scoreTextViews.add(view.findViewById(R.id.player_four_aces));
        scoreTextViews.add(view.findViewById(R.id.player_four_twos));
        scoreTextViews.add(view.findViewById(R.id.player_four_threes));
        scoreTextViews.add(view.findViewById(R.id.player_four_fours));
        scoreTextViews.add(view.findViewById(R.id.player_four_fives));
        scoreTextViews.add(view.findViewById(R.id.player_four_sixes));
        scoreTextViews.add(view.findViewById(R.id.player_four_three_of_a_kind));
        scoreTextViews.add(view.findViewById(R.id.player_four_four_of_a_kind));
        scoreTextViews.add(view.findViewById(R.id.player_four_full_house));
        scoreTextViews.add(view.findViewById(R.id.player_four_small_straight));
        scoreTextViews.add(view.findViewById(R.id.player_four_large_straight));
        scoreTextViews.add(view.findViewById(R.id.player_four_kniffel));
        scoreTextViews.add(view.findViewById(R.id.player_four_chance));

        upperTotalTextViews.add(view.findViewById(R.id.player_one_upper_total));
        upperTotalTextViews.add(view.findViewById(R.id.player_two_upper_total));
        upperTotalTextViews.add(view.findViewById(R.id.player_three_upper_total));
        upperTotalTextViews.add(view.findViewById(R.id.player_four_upper_total));

        bonusTextViews.add(view.findViewById(R.id.player_one_bonus));
        bonusTextViews.add(view.findViewById(R.id.player_two_bonus));
        bonusTextViews.add(view.findViewById(R.id.player_three_bonus));
        bonusTextViews.add(view.findViewById(R.id.player_four_bonus));

        upperTotalWithBonusTextViews.add(view.findViewById(R.id.player_one_upper_total_with_bonus));
        upperTotalWithBonusTextViews.add(view.findViewById(R.id.player_two_upper_total_with_bonus));
        upperTotalWithBonusTextViews.add(view.findViewById(R.id.player_three_upper_total_with_bonus));
        upperTotalWithBonusTextViews.add(view.findViewById(R.id.player_four_upper_total_with_bonus));

        lowerTotalTextViews.add(view.findViewById(R.id.player_one_lower_total));
        lowerTotalTextViews.add(view.findViewById(R.id.player_two_lower_total));
        lowerTotalTextViews.add(view.findViewById(R.id.player_three_lower_total));
        lowerTotalTextViews.add(view.findViewById(R.id.player_four_lower_total));

        lowerUpperTotalTextViews.add(view.findViewById(R.id.player_one_lower_upper_total));
        lowerUpperTotalTextViews.add(view.findViewById(R.id.player_two_lower_upper_total));
        lowerUpperTotalTextViews.add(view.findViewById(R.id.player_three_lower_upper_total));
        lowerUpperTotalTextViews.add(view.findViewById(R.id.player_four_lower_upper_total));

        finalTotalTextViews.add(view.findViewById(R.id.player_one_final_total));
        finalTotalTextViews.add(view.findViewById(R.id.player_two_final_total));
        finalTotalTextViews.add(view.findViewById(R.id.player_three_final_total));
        finalTotalTextViews.add(view.findViewById(R.id.player_four_final_total));

        playerOneNameScore = view.findViewById(R.id.player_one_name_score);
        playerOneNameScore.setText(playground.getPlayerName(0));

        playerTwoNameScore = view.findViewById(R.id.player_two_name_score);
        playerTwoNameScore.setText(playground.getPlayerName(1));

        playerThreeNameScore = view.findViewById(R.id.player_three_name_score);
        playerThreeNameScore.setText(playground.getPlayerName(2));

        playerFourNameScore = view.findViewById(R.id.player_four_name_score);
        playerFourNameScore.setText(playground.getPlayerName(3));

        return view;
    }

    private void addScore(View v) {
        Button btn = (Button) v;
        playground.addScore(ScoreType.getScore(btn.getText().toString()));

        GameActivity gameActivity = (GameActivity) getActivity();
        ShakerFragment shakerFragment = gameActivity.getShakerFragment();

        shakerFragment.setAllDicesColorRed();
        shakerFragment.updateView();
        updateView();
    }

    public void updateView() {
        List<Integer> scores = playground.getScores();
        for (int i = 0; i < scores.size(); i++) {
            scoreTextViews.get(i).setText(String.valueOf(scores.get(i)));
        }

        List<Integer> upperTotals = playground.getUpperTotals();
        List<Integer> lowerTotals = playground.getLowerTotals();
        for (int i = 0; i < upperTotals.size(); i++) {
            int upperValue = upperTotals.get(i);
            int lowerValue = lowerTotals.get(i);
            upperTotalTextViews.get(i).setText(String.valueOf(upperValue));
            lowerUpperTotalTextViews.get(i).setText(String.valueOf(upperValue));

            if (upperValue >= 63) {
                bonusTextViews.get(i).setText(String.valueOf(36));
                upperValue += 36;
                upperTotalWithBonusTextViews.get(i).setText(String.valueOf(upperValue));
            } else upperTotalWithBonusTextViews.get(i).setText(String.valueOf(upperValue));

            lowerUpperTotalTextViews.get(i).setText(String.valueOf(upperValue));
            lowerTotalTextViews.get(i).setText(String.valueOf(lowerValue));
            finalTotalTextViews.get(i).setText(String.valueOf(upperValue + lowerValue));
        }

    }

}
