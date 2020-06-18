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
import com.kimoji.kniffelig.controller.game.ScoreType;
import com.kimoji.kniffelig.controller.game.Playground;

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

        return view;
    }

    private void addScore(View v) {
        Button btn = (Button) v;
        playground.addScore(ScoreType.getScore(btn.getText().toString()));
    }
}
