package com.kimoji.kniffelig.view.lobby;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.kimoji.kniffelig.R;

public class LobbyActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private LobbyFragmentAdapter lobbyFragmentAdapter;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lobbyFragmentAdapter = new LobbyFragmentAdapter(getSupportFragmentManager(), 0);

        viewPager = findViewById(R.id.viewPager);
        setupViewPager();
    }

    private void setupViewPager() {
        lobbyFragmentAdapter.addFragment(new MainLobbyFragment(), "Main Fragment");
        lobbyFragmentAdapter.addFragment(new LocalLobbyFragment(), "Local lobby");

        viewPager.setAdapter(lobbyFragmentAdapter);
    }

    public void setViewPager(int fragmentNumber) {
        viewPager.setCurrentItem(fragmentNumber);
    }
}
