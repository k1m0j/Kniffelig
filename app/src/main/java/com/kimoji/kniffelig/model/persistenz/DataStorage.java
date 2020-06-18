package com.kimoji.kniffelig.model.persistenz;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


public class DataStorage {

    private static final String TAG = "DateStorage";
    private Context context;
    private String dataFilename;
    private SharedPreferences data;

    public DataStorage(Context activityContext, String dataFilename) {
        this.context = activityContext;
        this.dataFilename = dataFilename;
        this.data = context.getSharedPreferences(dataFilename, Context.MODE_PRIVATE);
        Log.i(TAG, "DataStorage: constructor aufgerufen");
    }


    public void newSharedPreference(String key, String value) {
        data.edit().putString(key, value).apply();

        data.edit().commit();
        Log.i(TAG, "newSharedPreference: aufgerufen");
    }

    public String getSharedPreferences(String key) {
        Log.i(TAG, "getSharedPreferences: aufgerufen ");
        return data.getString(key, null);

    }

    public void clearPreferences() {
        data.edit().clear();
        data.edit().commit();
        Log.i(TAG, "clearPreferences: aufgerufen");

    }

}
