package com.kimoji.kniffelig.view.lobby;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.kimoji.kniffelig.R;
import com.kimoji.kniffelig.model.persistenz.DataStorage;
import com.kimoji.kniffelig.view.game.GameActivity;

public class LocalLobbyFragment extends Fragment {

    private static final String TAG = "local lobby fragment";
    public static final String TEST = "Testkey";
    private Button btn2Player;
    private EditText playerOneName;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_local_lobby, container, false); //TODO

        playerOneName = view.findViewById(R.id.player_one_name);
        btn2Player = view.findViewById(R.id.btn_2players);

        btn2Player.setOnClickListener(this::openPlayingInterface);
        //btn2Player.setOnClickListener(this::getUserName);

        /*
        DataStorage storage = new DataStorage(this.getActivity(), getResources().getString(R.string.sharedPreferencesFile));
        Editable nameOne = playerOneName.getText();
        storage.newSharedPreference("player1", nameOne.toString());
        */

        //Player Konstruktor mit init werten?
        //alles in eine methode? -> aufruf -> submit button für name?
        return view;
    }

    public void openPlayingInterface(View view) {
        DataStorage storage = new DataStorage(this.getActivity(), getResources().getString(R.string.sharedPreferencesFile));
        Editable nameOne = playerOneName.getText();
        storage.newSharedPreference(TEST, nameOne.toString());
        Log.i(TAG, "getUserName " + nameOne.toString());
        Intent intent = new Intent(getActivity(), GameActivity.class);
        startActivity(intent);
    }

    public void getUserName(View view) {
        DataStorage storage = new DataStorage(this.getActivity(), getResources().getString(R.string.sharedPreferencesFile));
        Editable nameOne = playerOneName.getText();
        storage.newSharedPreference(TEST, nameOne.toString());
        Log.i(TAG, "getUserName " + nameOne.toString());
    }
}
