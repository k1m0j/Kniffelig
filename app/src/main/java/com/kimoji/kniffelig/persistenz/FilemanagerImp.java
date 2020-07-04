package com.kimoji.kniffelig.persistenz;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.kimoji.kniffelig.controller.game.Shaker;
import com.kimoji.kniffelig.model.GameStatus;
import com.kimoji.kniffelig.model.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FilemanagerImp implements Filemanager {

    private static final String TAG = "persistence";


    public FilemanagerImp() {
    }

    @Override
    public void saveGameStatus(Context context, GameStatus gameStatus) {
        File outFile = new File(Environment.getExternalStorageDirectory(), "appSaveStateGameStatus.data");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outFile));
            saveGameStatus(oos, gameStatus);
            Log.i(TAG, "saveGameStatus: aufgerufen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public GameStatus loadGameStatus() {
        try {
            File inFile = new File(Environment.getExternalStorageDirectory(), "appSaveStateGameStatus.data");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inFile));
            Log.i(TAG, "loadGameStatus: aufgerufen");
            return loadGameStatus(ois);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void savePlayers(Context context, Player[] allPlayers) {
        File outFile = new File(Environment.getExternalStorageDirectory(), "appSaveStatePlayers.data");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outFile));
            savePlayers(oos, allPlayers);
            Log.i(TAG, "savePlayers: aufgerufen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Player[] loadPlayers() {
        try {
            File inFile = new File(Environment.getExternalStorageDirectory(), "appSaveStatePlayers.data");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inFile));
            Log.i(TAG, "loadPlayers: aufgerufen");
            return loadPlayers(ois);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveShaker(Context context, Shaker shaker) {
        File outFile = new File(Environment.getExternalStorageDirectory(), "appSaveStateShaker.data");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outFile));
            saveShaker(oos, shaker);
            Log.i(TAG, "saveShaker: aufgerufen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Shaker loadShaker() {
        try {
            File inFile = new File(Environment.getExternalStorageDirectory(), "appSaveStateShaker.data");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inFile));
            Log.i(TAG, "loadPlayers: aufgerufen");
            return loadShaker(ois);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Shaker loadShaker(ObjectInputStream ois) {
        Shaker shaker;
        try {
            shaker = (Shaker) ois.readObject();
            return shaker;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void saveShaker(ObjectOutputStream oos, Shaker shaker) {
        try {
            oos.writeObject(shaker);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void saveGameStatus(ObjectOutputStream oos, GameStatus gameStatus) {
        try {
            oos.writeObject(gameStatus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private GameStatus loadGameStatus(ObjectInputStream ois) {
        GameStatus gameStatus;
        try {
            gameStatus = (GameStatus) ois.readObject();
            return gameStatus;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    private void savePlayers(ObjectOutputStream oos, Player[] allPlayers) {
        try {
            oos.writeObject(allPlayers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Player[] loadPlayers(ObjectInputStream ois) {
        Player[] players;
        try {
            players = (Player[]) ois.readObject();
            return players;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
