package com.kimoji.kniffelig.controller.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;

public class BluetoothSetup {

    private Context context;

    public BluetoothSetup(Context context) {
        this.context = context;
    }

    public static void init() throws Exception {
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        if (adapter == null) {
            throw new Exception("This device does not support Bluettooth");
        }
        if (!adapter.isEnabled()) {
            adapter.enable();
        }
    }
}
