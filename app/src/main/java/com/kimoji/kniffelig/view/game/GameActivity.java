package com.kimoji.kniffelig.view.game;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.kimoji.kniffelig.R;
import com.kimoji.kniffelig.controller.game.Playground;
import com.kimoji.kniffelig.controller.game.PlaygroundImp;
import com.kimoji.kniffelig.model.game.Player;
import com.kimoji.kniffelig.model.game.PlayerImp;


public class GameActivity extends AppCompatActivity {

    private static final String TAG = "Gameactivity";
    private GameSectionAdapter sectionsPageAdapter;

    private ViewPager viewPager;

    private ShakerFragment shakerFragment;
    private ScoreFragment scoreFragment;

    private Playground playground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        viewPager = findViewById(R.id.view_pager);
        // setupViewPager();

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        //TODO Player Name

        final String sender = this.getIntent().getExtras().getString("SENDER_KEY");

        if (sender != null) {
            this.receiveData();
            Toast.makeText(this, "Received", Toast.LENGTH_SHORT).show();
        }
        shakerFragment = new ShakerFragment(playground);
        scoreFragment = new ScoreFragment(playground);
        setupViewPager();
    }

    private void receiveData() {
        //RECEIVE DATA VIA INTENT
        Intent i = getIntent();
        String nameOne = i.getStringExtra("PlayerOneName");
        String nameTwo = i.getStringExtra("PlayerTwoName");
        String nameThree = i.getStringExtra("PlayerThreeName");
        String nameFour = i.getStringExtra("PlayerFourName");

        String[] playerNames = {nameOne, nameTwo, nameThree, nameFour};
        playground = new PlaygroundImp(playerNames);
    }

    private void setupViewPager() {
        sectionsPageAdapter = new GameSectionAdapter(getSupportFragmentManager(), 0);
        sectionsPageAdapter.addFragment(shakerFragment, "Shaker");
        sectionsPageAdapter.addFragment(scoreFragment, "Score Board");

        viewPager.setAdapter(sectionsPageAdapter);
    }

    public ShakerFragment getShakerFragment() {
        return shakerFragment;
    }

    public ScoreFragment getScoreFragment() {
        return scoreFragment;
    }
}
