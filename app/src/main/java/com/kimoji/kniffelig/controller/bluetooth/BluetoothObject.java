package com.kimoji.kniffelig.controller.bluetooth;

import android.bluetooth.BluetoothDevice;

public class BluetoothObject {

    private String name;
    private String adress;
    private String signalquality;
    private int state;
    private int type;
    private BluetoothDevice device;

    public BluetoothDevice getDevice() {
        return device;
    }

    public void setDevice(BluetoothDevice device) {
        this.device = device;
    }
//private ParcelUuid[] uuids;

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getSignalquality() {
        return signalquality;
    }

    public int getState() {
        return state;
    }

    public int getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setSignalquality(String signalquality) {
        this.signalquality = signalquality;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setType(int type) {
        this.type = type;
    }
}
