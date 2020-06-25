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


public class
GameActivity extends AppCompatActivity {

    private static final String TAG = "Gameactivity";
    private GameSectionAdapter sectionsPageAdapter;

    private ViewPager viewPager;

    private Playground playground;

    private Player player1, player2, player3, player4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        viewPager = findViewById(R.id.view_pager);
        // setupViewPager();

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        //TODO Player Name


        // PlayerImp testPlayer1 = new PlayerImp("Peter Lustig");
        //  PlayerImp testPlayer2 = new PlayerImp("Daniel Düsentrieb");
        //  PlayerImp testPlayer3 = new PlayerImp("Daisy Duck");
        //  PlayerImp testPlayer4 = new PlayerImp("Zapzarap");

        final String sender = this.getIntent().getExtras().getString("SENDER_KEY");

        if (sender != null) {
            this.receiveData();
            Toast.makeText(this, "Received", Toast.LENGTH_SHORT).show();

        }


        setupViewPager();
    }

    @Override
    protected void onResume() {
        super.onResume();

        final String sender = this.getIntent().getExtras().getString("SENDER_KEY");

        if (sender != null) {
            this.receiveData();
            Toast.makeText(this, "Received", Toast.LENGTH_SHORT).show();

        }
    }

    private void receiveData() {
        //RECEIVE DATA VIA INTENT
        Intent i = getIntent();
        String nameOne = i.getStringExtra("PlayerOneName");
        String nameTwo = i.getStringExtra("PlayerTwoName");
        String nameThree = i.getStringExtra("PlayerThreeName");
        String nameFour = i.getStringExtra("PlayerFourName");

        player1 = new PlayerImp(nameOne);
        player2 = new PlayerImp(nameTwo);
        player3 = new PlayerImp(nameThree);
        player4 = new PlayerImp(nameFour);


        String[] playerNames = {player1.getName(), player2.getName(), player3.getName(), player4.getName()};
        playground = new PlaygroundImp(playerNames);


    }

    private void setupViewPager() {
        sectionsPageAdapter = new GameSectionAdapter(getSupportFragmentManager(), 0);
        sectionsPageAdapter.addFragment(new ShakerFragment(playground), "Shaker");
        sectionsPageAdapter.addFragment(new ScoreFragment(playground), "Score Board");

        viewPager.setAdapter(sectionsPageAdapter);


    }

}
