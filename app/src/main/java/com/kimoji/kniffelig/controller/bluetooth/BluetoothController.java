package com.kimoji.kniffelig.controller.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.Context;

import com.kimoji.kniffelig.view.bluetooth.BluetoothClientFragment;

import java.util.ArrayList;

/**
 * Interface for the bluetooth component
 */
public interface BluetoothController {

    /**
     * Starting a java thread which function as a Bluetooth server, waiting for client to connect
     */
    void startServerThread();

    /**
     * Searching for nearby Bluetooth devices
     *
     * @param clientFragment the activity who displays the devices
     */
    void scanForBTDevices(BluetoothClientFragment clientFragment);

    /**
     * return a list of all nearby bluetooth devices
     *
     * @return bluetooth objects
     */
    ArrayList<BluetoothObject> getBluetoothObjectList();

    /**
     * Starting a java thread which tries to built a connection with a specific bluetooth device
     *
     * @param context current context
     * @param device  server device
     */
    void startConnectionThread(Context context, BluetoothDevice device);

    /**
     * Wir sind uns noch nicht sicher was wir allen schreiben wollen und welche überladungen
     * der methode wir haben möchten deswegen ist diese methode stellvertretend für alle write
     * methoden die wir haben werden
     */
    void write();

    /**
     * Wir sind uns noch nicht sicher was wir allen lesen wollen
     * deswegen ist diese methode stellvertretend für alle read methoden die wir haben werden
     */
    void read();

}
