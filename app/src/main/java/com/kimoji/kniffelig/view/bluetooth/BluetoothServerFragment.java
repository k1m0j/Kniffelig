package com.kimoji.kniffelig.view.bluetooth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.kimoji.kniffelig.R;
import com.kimoji.kniffelig.controller.bluetooth.BluetoothController;
import com.kimoji.kniffelig.controller.bluetooth.BluetoothControllerImp;

public class BluetoothServerFragment extends Fragment {

    private BluetoothController btController;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bluetooth_server, container, false);

        btController = new BluetoothControllerImp(getContext());
        btController.startServerThread();

        return view;
    }
}
