package com.kimoji.kniffelig.model.persistenz;

import android.content.Context;

import com.kimoji.kniffelig.model.game.Player;
import com.kimoji.kniffelig.model.game.score.Score;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

public class FileManagerImp implements FileManager {

    static final String PLAYER_FILE = "Player.txt";

    public static void writeToFile(Context context, Player player) {
        String playerName = player.getName();

        Collection<Score> data = player.getScores().values();
        ArrayList<Score> dataArrayList = new ArrayList<>(data);

        System.out.println("Following data gets saved: ");

        for (Score s : dataArrayList) System.out.println(s);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PLAYER_FILE))) {
            System.out.println("Write object in FileManagerImp called.");
            oos.writeObject(dataArrayList);
            oos.writeObject(playerName);
            System.out.println("Got saved in " + PLAYER_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
