package com.kimoji.kniffelig.controller.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.util.Log;

import com.kimoji.kniffelig.R;

import java.io.IOException;
import java.util.UUID;

public class BluetoothConnectionThread extends Thread {
    private Context context;
    private static final String TAG = BluetoothConnectionThread.class.getSimpleName();

    private final BluetoothSocket socket;
    private final BluetoothDevice bluetoothDevice;
    private BluetoothCommunicationThread communicationThread;

    public BluetoothConnectionThread(Context context, BluetoothDevice device) {
        this.context = context;
        BluetoothSocket tmp = null;
        bluetoothDevice = device;

        try {
            tmp = device.createInsecureRfcommSocketToServiceRecord(UUID.fromString(context.getString(R.string.BT_UUID)));
        } catch (IOException e) {
            Log.e(TAG, "Socket´s create method failed");
            e.printStackTrace();
        }
        socket = tmp;
    }

    public void run() {
        Log.d(TAG, "run: start running");
        //Cancel discoervy because it otherwise slows down the connection
        BluetoothAdapter.getDefaultAdapter().cancelDiscovery();

        try {
            //Connect to the remote device trough the socket. This call blocks until it succseeds or throws an Exception
            socket.connect();
        } catch (IOException e) {
            //Unable to connect; close the socket and return
            try {
                socket.close();
            } catch (IOException ex) {
                Log.e(TAG, "Could not close the client socket", ex);
            }
            return;
        }
        Log.i(TAG, "run: it works");
        communicationThread = new BluetoothCommunicationThread(context, socket);
    }

    public BluetoothCommunicationThread getCommunicationThread() {
        return communicationThread;
    }

    public void cancel() {
        try {
            socket.close();
        } catch (IOException e) {
            Log.e(TAG, "Could not close the client socket", e);
        }
    }
}
