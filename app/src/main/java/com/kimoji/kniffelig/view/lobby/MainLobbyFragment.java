package com.kimoji.kniffelig.view.lobby;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.kimoji.kniffelig.R;
import com.kimoji.kniffelig.view.bluetooth.BluetoothActivity;

public class MainLobbyFragment extends Fragment {

    private Button btnLocalLobby;
    private Button btnBluetoothLobby;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);

        btnLocalLobby = view.findViewById(R.id.btn_local_lobby);
        btnLocalLobby.setOnClickListener(this::openLocalLobby);

        btnBluetoothLobby = view.findViewById(R.id.btn_bluetooth_lobby);
        btnBluetoothLobby.setOnClickListener(this::openBluetoothLobby);

        return view;
    }

    public void openLocalLobby(View view) {
        ((LobbyActivity) getActivity()).setViewPager(1);
    }

    public void openBluetoothLobby(View view) {
        Intent intent = new Intent(getContext(), BluetoothActivity.class);
        startActivity(intent);
    }

}
