package com.kimoji.kniffelig.view.bluetooth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kimoji.kniffelig.R;
import com.kimoji.kniffelig.controller.bluetooth.BluetoothController;
import com.kimoji.kniffelig.controller.bluetooth.BluetoothControllerImp;

public class BluetoothClientFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private BluetoothController btController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bluetooth_lobby, container, false);

        btController = new BluetoothControllerImp(getContext());
        btController.scanForBTDevices(this);

        recyclerView = view.findViewById(R.id.BT_recyclerview);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.hasFixedSize();

        layoutManager = new LinearLayoutManager(getContext());
        mAdapter = new BluetoothDeviceAdapter(btController.getBluetoothObjectList(), btController);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        return view;
    }

    public void notifyDataSetHasChanged() {
        mAdapter.notifyDataSetChanged();
    }
}
