package com.kimoji.kniffelig.persistenz;


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

public class FilemanagerImp {

    private static final String TAG = "persistence";


    public FilemanagerImp() {

    }


    public void saveGameStatus(GameStatus gameStatus) {
        File outFile = new File(Environment.getExternalStorageDirectory(), "appSaveStateGameStatus.data");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outFile));
            saveGameStatus(oos, gameStatus);
            Log.i(TAG, "saveGameStatus: aufgerufen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    public void savePlayers(Player[] allPlayers) {
        File outFile = new File(Environment.getExternalStorageDirectory(), "appSaveStatePlayers.data");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outFile));
            savePlayers(oos, allPlayers);
            Log.i(TAG, "savePlayers: aufgerufen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    public void saveShaker(Shaker shaker) {
        File outFile = new File(Environment.getExternalStorageDirectory(), "appSaveStateShaker.data");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outFile));
            saveShaker(oos, shaker);
            Log.i(TAG, "saveShaker: aufgerufen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    public Shaker loadShaker(ObjectInputStream ois) {
        Shaker shaker;
        try {
            shaker = (Shaker) ois.readObject();
            return shaker;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveShaker(ObjectOutputStream oos, Shaker shaker) {
        try {
            oos.writeObject(shaker);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void saveGameStatus(ObjectOutputStream oos, GameStatus gameStatus) {
        try {
            oos.writeObject(gameStatus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GameStatus loadGameStatus(ObjectInputStream ois) {
        GameStatus gameStatus;
        try {
            gameStatus = (GameStatus) ois.readObject();
            return gameStatus;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void savePlayers(ObjectOutputStream oos, Player[] allPlayers) {
        try {
            oos.writeObject(allPlayers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Player[] loadPlayers(ObjectInputStream ois) {
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
