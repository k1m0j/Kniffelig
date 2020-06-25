package com.kimoji.kniffelig.view.lobby;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.kimoji.kniffelig.R;
import com.kimoji.kniffelig.view.game.GameActivity;

public class LocalLobbyFragment extends Fragment {

    private static final String TAG = "local lobby fragment";
    public static final String TEST = "Testkey";
    private Button btn2Player;
    private EditText playerOneName;
    private EditText playerTwoName;
    private EditText playerThreeName;
    private EditText playerFourName;

    Editable nameOne;
    Editable nameTwo;
    Editable nameThree;
    Editable nameFour;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_local_lobby, container, false); //TODO

        playerOneName = view.findViewById(R.id.player_one_name);
        playerTwoName = view.findViewById(R.id.player_two_name);
        playerThreeName = view.findViewById(R.id.player_three_name);
        playerFourName = view.findViewById(R.id.player_four_name);


        btn2Player = view.findViewById(R.id.btn_2players);

        btn2Player.setOnClickListener(this::openPlayingInterface);
        //btn2Player.setOnClickListener(this::getUserName);

        nameOne = playerOneName.getText();
        nameTwo = playerTwoName.getText();
        nameThree = playerThreeName.getText();
        nameFour = playerFourName.getText();





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


        Intent intent = new Intent(getActivity(), GameActivity.class);
        startActivity(intent);
        sendData();

    }

    private void sendData() {
        Intent i = new Intent(getActivity().getBaseContext(), GameActivity.class);

        i.putExtra("SENDER_KEY", "PlayerNames");
        i.putExtra("PlayerOneName", nameOne.toString());
        i.putExtra("PlayerTwoName", nameTwo.toString());
        i.putExtra("PlayerThreeName", nameThree.toString());
        i.putExtra("PlayerFourName", nameFour.toString());

        getActivity().startActivity(i);
    }


}
