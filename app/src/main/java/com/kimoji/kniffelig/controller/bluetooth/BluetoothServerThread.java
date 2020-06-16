package com.kimoji.kniffelig.controller.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.kimoji.kniffelig.R;

import java.io.IOException;
import java.util.UUID;

public class BluetoothServerThread extends Thread {
    private Context context;
    private static final String TAG = BluetoothServerThread.class.getSimpleName();

    private final BluetoothServerSocket serverSocket;

    private BluetoothCommunicationThread communicationThread;

    public BluetoothServerThread(Context context) {
        this.context = context;
        BluetoothServerSocket tmp = null;
        try {
            tmp = BluetoothAdapter.getDefaultAdapter().listenUsingRfcommWithServiceRecord(context.getString(R.string.app_name), UUID.fromString(context.getString(R.string.BT_UUID)));
        } catch (IOException e) {
            Log.e(TAG, "Socket´s listen() method failed", e);
        }
        serverSocket = tmp;
    }

    public void run() {
        Log.d(TAG, "run: start running");
        BluetoothSocket socket = null;
        //Keep listening until exception occurs or a socket is returned
        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                Log.e(TAG, "Socket´s accept() method failed", e);
                break;
            }

            if (socket != null) {
                //A connection was accepted. Perform work associated with the connection in a separate thread
                Toast.makeText(context, "bro", Toast.LENGTH_LONG).show();
                Log.d(TAG, "run: it works");
                communicationThread = new BluetoothCommunicationThread(context, socket);
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    Log.e(TAG, "Sockets close() method failed", e);
                }
                break;
            }
        }
    }

    public BluetoothCommunicationThread getCommunicationThread() {
        return communicationThread;
    }

    public void cancel() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            Log.e(TAG, "Sockets close() method failed", e);
        }
    }

}
