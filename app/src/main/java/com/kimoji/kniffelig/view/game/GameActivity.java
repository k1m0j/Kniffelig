package com.kimoji.kniffelig.view.game;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.os.PersistableBundle;
import android.util.Log;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.kimoji.kniffelig.R;
import com.kimoji.kniffelig.controller.game.PlaygroundImp;
import com.kimoji.kniffelig.controller.game.Playground;


import com.kimoji.kniffelig.model.DataStorage;
import com.kimoji.kniffelig.model.Player;

import com.kimoji.kniffelig.model.PlayerImp;

import static com.kimoji.kniffelig.view.lobby.LocalLobbyFragment.TEST;


public class
GameActivity extends AppCompatActivity {

    private static final String TAG = "Gameactivity";
    private GameSectionAdapter sectionsPageAdapter;

    private ViewPager viewPager;

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
        int[] scores1 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        int[] scores2 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        int[] scores3 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        int[] scores4 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        PlayerImp testPlayer1 = new PlayerImp("Peter Lustig", scores1);
        PlayerImp testPlayer2 = new PlayerImp("Daniel Düsentrieb", scores2);
        PlayerImp testPlayer3 = new PlayerImp("Daisy Duck", scores3);
        PlayerImp testPlayer4 = new PlayerImp("Zapzarap", scores4);

        DataStorage storage = new DataStorage(this, getResources().getString(R.string.sharedPreferencesFile));
       String name = storage.getSharedPreferences(TEST);
        Log.i(TAG, "onCreate: " + name);

        String[] playerNames = {testPlayer1.getName(), testPlayer2.getName(), testPlayer3.getName(), testPlayer4.getName()};
        playground = new PlaygroundImp(playerNames);

        setupViewPager();
    }

    private void setupViewPager() {
        sectionsPageAdapter = new GameSectionAdapter(getSupportFragmentManager(), 0);
        sectionsPageAdapter.addFragment(new ShakerFragment(playground), "Shaker");
        sectionsPageAdapter.addFragment(new ScoreFragment(playground), "Score Board");

        viewPager.setAdapter(sectionsPageAdapter);
    }

}
