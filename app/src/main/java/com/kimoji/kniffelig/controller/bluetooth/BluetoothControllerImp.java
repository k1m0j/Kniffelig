package com.kimoji.kniffelig.controller.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.widget.Toast;

import com.kimoji.kniffelig.view.bluetooth.BluetoothClientFragment;

import java.util.ArrayList;

public class BluetoothControllerImp implements BluetoothController {

    private Context context;

    private BluetoothScanner scanner;

    public BluetoothControllerImp(Context context) {
        this.context = context;
    }

    @Override
    public void startServerThread() {
        init();

        BluetoothServerThread serverThread = new BluetoothServerThread(context);
        serverThread.start();
    }

    @Override
    public void scanForBTDevices(BluetoothClientFragment clientFragment) {
        init();
        scanner = new BluetoothScanner(clientFragment);
        scanner.scanForBTDevices();
    }

    @Override
    public ArrayList<BluetoothObject> getBluetoothObjectList() {
        return scanner.getBluetoothObjectList();
    }

    @Override
    public void startConnectionThread(Context context, BluetoothDevice device) {
        BluetoothConnectionThread connectThread = new BluetoothConnectionThread(context, device);
        connectThread.start();
    }

    @Override
    public void write() {

    }

    @Override
    public void read() {

    }

    private void init() {
        try {
            BluetoothSetup.init();
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
