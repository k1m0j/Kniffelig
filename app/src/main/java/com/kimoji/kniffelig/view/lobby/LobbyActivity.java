package com.kimoji.kniffelig.view.lobby;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.kimoji.kniffelig.R;

public class LobbyActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private LobbyFragmentAdapter lobbyFragmentAdapter;

    private static final int STORAGE_PERMISSION_CODE = 101;


    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lobbyFragmentAdapter = new LobbyFragmentAdapter(getSupportFragmentManager(), 0);

        viewPager = findViewById(R.id.viewPager);
        setupViewPager();

        checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, STORAGE_PERMISSION_CODE);
    }


    private void setupViewPager() {
        lobbyFragmentAdapter.addFragment(new MainLobbyFragment(), "Main Fragment");
        lobbyFragmentAdapter.addFragment(new LocalLobbyFragment(), "Local lobby");

        viewPager.setAdapter(lobbyFragmentAdapter);
    }

    public void setViewPager(int fragmentNumber) {
        viewPager.setCurrentItem(fragmentNumber);
    }

    // Function to check and request permission
    private void checkPermission(String permission, int requestCode) {

        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(LobbyActivity.this, permission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(LobbyActivity.this, new String[]{permission}, requestCode);
        } else {
            Toast.makeText(LobbyActivity.this, "Permission already granted", Toast.LENGTH_SHORT).show();
        }
    }
}
