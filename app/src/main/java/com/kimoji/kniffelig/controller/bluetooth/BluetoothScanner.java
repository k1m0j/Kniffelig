package com.kimoji.kniffelig.controller.bluetooth;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import androidx.core.app.ActivityCompat;

import com.kimoji.kniffelig.R;
import com.kimoji.kniffelig.view.bluetooth.BluetoothClientFragment;

import java.util.ArrayList;

public class BluetoothScanner {
    BluetoothAdapter bluetoothAdapter;
    BluetoothClientFragment clientFragment;
    Context context;

    ArrayList<BluetoothObject> bluetoothObjectList;


    public BluetoothScanner(BluetoothClientFragment clientFragment) {
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        this.clientFragment = clientFragment;
        context = this.clientFragment.getContext();
    }

    public void scanForBTDevices() {
        bluetoothObjectList = new ArrayList<>();

        //Requests Location permission
        ActivityCompat.requestPermissions(clientFragment.getActivity(),
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                1);

        //start looking for devices
        bluetoothAdapter.startDiscovery();

        //Discover new Devices
        //Create a BR for ACTION_FOUND
        final BroadcastReceiver mReceiver = new BroadcastReceiver() {
            //Diese Action wird bei jedem Gefundenen Gerät ausgeführt
            @Override
            public void onReceive(Context context, Intent intent) {
                //dont know
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                //Get the rssi in dbm
                // Check aber nicht woher das dass das intent wissen soll
                int rssi = intent.getShortExtra(BluetoothDevice.EXTRA_RSSI, Short.MIN_VALUE);

                //Create the device object and add it to the arrayList of devices
                BluetoothObject bluetoothObject = new BluetoothObject();
                bluetoothObject.setName(device.getName()); //string
                bluetoothObject.setAdress(device.getAddress()); //string
                bluetoothObject.setState(device.getBondState()); //int
                bluetoothObject.setType(device.getType()); //int
                //bluetoothObject.getUuids(device.getUuids()); //ParcelUUIDS[]
                bluetoothObject.setSignalquality(RssiToAdjective(rssi));
                bluetoothObject.setDevice(device);

                bluetoothObjectList.add(bluetoothObject);

                clientFragment.notifyDataSetHasChanged();
            }
        };

        //Register BroadcastRe
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        context.registerReceiver(mReceiver, filter);

    }

    public ArrayList<BluetoothObject> getBluetoothObjectList() {
        return bluetoothObjectList;
    }

    private String RssiToAdjective(int rssi) {
        if (rssi >= -20 && rssi < 0) {
            return context.getString(R.string.excelent);
        } else if (rssi >= -40 && rssi < -20) {
            return context.getString(R.string.verygood);
        } else if (rssi >= -60 && rssi < -40) {
            return context.getString(R.string.good);
        } else if (rssi >= -80 && rssi < -60) {
            return context.getString(R.string.okay);
        } else if (rssi < -80) {
            return context.getString(R.string.poor);
        }
        return context.getString(R.string.unknown);
    }
}
