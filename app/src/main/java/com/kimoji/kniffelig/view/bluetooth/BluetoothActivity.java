package com.kimoji.kniffelig.view.bluetooth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.kimoji.kniffelig.R;

public class BluetoothActivity extends AppCompatActivity {
    private BluetoothFragmentAdapter bluetoothFragmentAdapter;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        bluetoothFragmentAdapter = new BluetoothFragmentAdapter(getSupportFragmentManager(), 0);

        viewPager = findViewById(R.id.container);

        setupViewPager();
    }

    private void setupViewPager() {
        bluetoothFragmentAdapter.addFragment(new BluetoothRoleFragment(), "Bluetooth role fragment");
        bluetoothFragmentAdapter.addFragment(new BluetoothServerFragment(), "Bluetooth server fragment");
        bluetoothFragmentAdapter.addFragment(new BluetoothClientFragment(), "Bluetooth client fragment");


        viewPager.setAdapter(bluetoothFragmentAdapter);
    }

    public void setViewPager(int fragmentNumber) {
        viewPager.setCurrentItem(fragmentNumber);
    }
}
