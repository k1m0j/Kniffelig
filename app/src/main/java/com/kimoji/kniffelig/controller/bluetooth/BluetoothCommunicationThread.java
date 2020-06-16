package com.kimoji.kniffelig.controller.bluetooth;

import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BluetoothCommunicationThread extends Thread {
    private Context context;
    private static final String TAG = BluetoothCommunicationThread.class.getSimpleName();

    private Handler handler;

    private final BluetoothSocket socket;
    private final InputStream inputStream;
    private final OutputStream outputStream;
    private byte[] buffer;

    public BluetoothCommunicationThread(Context context, BluetoothSocket socket) {
        this.context = context;
        this.socket = socket;
        InputStream tmpIn = null;
        OutputStream tmpOut = null;

        try {
            tmpIn = socket.getInputStream();
        } catch (IOException e) {
            Log.e(TAG, "BluetoothConnection: Error when creating InputStream", e);
        }
        try {
            tmpOut = socket.getOutputStream();
        } catch (IOException e) {
            Log.e(TAG, "BluetoothConnection: Error when creating OutputStream", e);
        }
        inputStream = tmpIn;
        outputStream = tmpOut;
    }

    public void run() {
        buffer = new byte[1024];
        int numBytes; //bytes returned from read()

        while (true) {
            try {
                numBytes = inputStream.read(buffer);
                Message readMsg = handler.obtainMessage(0, numBytes, -1, buffer);
                readMsg.sendToTarget();
            } catch (IOException e) {
                Log.e(TAG, "run: Input stream was dissconeccted", e);
                break;
            }
        }
    }

    public void write(byte[] bytes) {
        try {
            outputStream.write(bytes);

            Message writtenMSG = handler.obtainMessage(1, -1, -1, buffer);
            writtenMSG.sendToTarget();
        } catch (IOException e) {
            Log.e(TAG, "write: Error occurred when sending data", e);

            Message writeErrorMsg = handler.obtainMessage(2);
            Bundle bundle = new Bundle();
            bundle.putString("toast", "Couldnt send data to the other device");
            writeErrorMsg.setData(bundle);
            handler.sendMessage(writeErrorMsg);
        }
    }

    public void cancel() {
        try {
            socket.close();
        } catch (IOException e) {
            Log.e(TAG, "cancel: Could not close the connection socket", e);
        }
    }
}
