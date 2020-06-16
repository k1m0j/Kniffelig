package com.kimoji.kniffelig.view.bluetooth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.kimoji.kniffelig.R;

public class BluetoothRoleFragment extends Fragment {

    private Button btnStartServer;
    private Button btnStartClient;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bluetooth_role, container, false);

        btnStartClient = view.findViewById(R.id.client_btn);
        btnStartServer = view.findViewById(R.id.server_btn);

        btnStartServer.setOnClickListener(this::openBTServerActivity);
        btnStartClient.setOnClickListener(this::openBTClientActivity);

        return view;
    }

    public void openBTServerActivity(View view) {
        ((BluetoothActivity) getActivity()).setViewPager(1);
    }

    public void openBTClientActivity(View view) {
        ((BluetoothActivity) getActivity()).setViewPager(2);
    }
}
