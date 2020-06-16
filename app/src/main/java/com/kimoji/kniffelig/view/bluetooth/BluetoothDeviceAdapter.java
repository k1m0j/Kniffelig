package com.kimoji.kniffelig.view.bluetooth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kimoji.kniffelig.R;
import com.kimoji.kniffelig.controller.bluetooth.BluetoothController;
import com.kimoji.kniffelig.controller.bluetooth.BluetoothObject;

import java.util.ArrayList;

public class BluetoothDeviceAdapter extends RecyclerView.Adapter<BluetoothDeviceAdapter.BluetoothDeviceViewHolder> {
    private ArrayList<BluetoothObject> mDataSet;

    private BluetoothController btController;

    private Context context;

    public static class BluetoothDeviceViewHolder extends RecyclerView.ViewHolder {

        public TextView devicename;
        public TextView adress;
        public TextView rssi;

        public Button connectBTN;

        public BluetoothDeviceViewHolder(View itemView) {
            super(itemView);

            devicename = itemView.findViewById(R.id.bt_device_name);
            adress = itemView.findViewById(R.id.bt_device_adress);
            rssi = itemView.findViewById(R.id.bt_device_rssi);
            connectBTN = itemView.findViewById(R.id.connectBTN);
        }
    }

    public BluetoothDeviceAdapter(ArrayList<BluetoothObject> dataSet, BluetoothController btController) {
        this.btController = btController;
        mDataSet = dataSet;
    }

    @NonNull
    @Override
    public BluetoothDeviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.bt_device_view_holder, parent, false);
        BluetoothDeviceViewHolder bvh = new BluetoothDeviceViewHolder(v);

        context = parent.getContext();

        return bvh;
    }

    @Override
    public void onBindViewHolder(@NonNull final BluetoothDeviceViewHolder holder, int position) {
        final BluetoothObject currentItem = mDataSet.get(position);
        holder.devicename.setText(currentItem.getName());
        holder.adress.setText(currentItem.getAdress());
        holder.rssi.setText(currentItem.getSignalquality());

        holder.connectBTN.setOnClickListener(v -> {
            btController.startConnectionThread(context, currentItem.getDevice());
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
