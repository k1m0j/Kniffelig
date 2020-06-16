package com.kimoji.kniffelig.view.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.kimoji.kniffelig.R;
import com.kimoji.kniffelig.controller.game.Playground;
import com.kimoji.kniffelig.controller.game.Score;

public class ScoreFragment extends Fragment {

    private static final String TAG = "ScoreFragment";

    private Playground playground;

    private Button btnAces;
    private Button btnTwos;
    private Button btnThrees;
    private Button btnFours;
    private Button btnFives;
    private Button btnSixes;

    private Button btnTOAK;
    private Button btnFOAK;
    private Button btnFullhouse;
    private Button btnSmallS;
    private Button btnLargeS;
    private Button btnKniffle;
    private Button btnChance;


    public ScoreFragment(Playground playground) {
        this.playground = playground;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.score_fragment, container, false);

        btnAces = view.findViewById(R.id.btn_aces);
        btnAces.setOnClickListener(this::addAces);

        btnTwos = view.findViewById(R.id.btn_twos);
        btnTwos.setOnClickListener(this::addTwos);

        btnThrees = view.findViewById(R.id.btn_threes);
        btnThrees.setOnClickListener(this::addThrees);

        btnFours = view.findViewById(R.id.btn_fours);
        btnFours.setOnClickListener(this::adFours);

        btnFives = view.findViewById(R.id.btn_fives);
        btnFives.setOnClickListener(this::addFives);

        btnSixes = view.findViewById(R.id.btn_sixes);
        btnSixes.setOnClickListener(this::addSixes);

        btnTOAK = view.findViewById(R.id.btn_toak);
        btnTOAK.setOnClickListener(this::addTOAK);

        btnFOAK = view.findViewById(R.id.btn_foak);
        btnFOAK.setOnClickListener(this::addFOAK);

        btnFullhouse = view.findViewById(R.id.btn_fullHouse);
        btnFullhouse.setOnClickListener(this::addFullhouse);

        btnSmallS = view.findViewById(R.id.btn_smallStraight);
        btnSmallS.setOnClickListener(this::addSmallStraight);

        btnLargeS = view.findViewById(R.id.btn_largeStraight);
        btnLargeS.setOnClickListener(this::addLargeStraight);

        btnKniffle = view.findViewById(R.id.btn_kniffle);
        btnKniffle.setOnClickListener(this::addKniffle);

        btnChance = view.findViewById(R.id.btn_chance);
        btnChance.setOnClickListener(this::addChance);

        return view;
    }

    private void addAces(View v) {
        playground.addScore(Score.ACES);
    }

    private void addTwos(View v) {
        playground.addScore(Score.ACES);
    }

    private void addThrees(View v) {
        playground.addScore(Score.THREES);
    }

    private void adFours(View v) {
        playground.addScore(Score.FOURS);
    }

    private void addFives(View v) {
        playground.addScore(Score.FIVES);
    }

    private void addSixes(View v) {
        playground.addScore(Score.SIXES);
    }

    private void addTOAK(View v) {
        playground.addScore(Score.THREEOFAKIND);
    }

    private void addFOAK(View v) {
        playground.addScore(Score.FOUROFAKIND);
    }

    private void addFullhouse(View v) {
        playground.addScore(Score.FULLHOUSE);
    }

    private void addSmallStraight(View v) {
        playground.addScore(Score.SMALLSTRAIGHT);
    }

    private void addLargeStraight(View v) {
        playground.addScore(Score.LARGESTRAIGHT);
    }

    private void addKniffle(View v) {
        playground.addScore(Score.KNIFFEL);
    }

    private void addChance(View v) {
        playground.addScore(Score.CHANCE);
    }
}
