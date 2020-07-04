package com.kimoji.kniffelig.persistenz;

import android.content.Context;

import com.kimoji.kniffelig.controller.game.Shaker;
import com.kimoji.kniffelig.model.GameStatus;
import com.kimoji.kniffelig.model.Player;

public interface Filemanager {


    /**
     * //TODO
     *
     * @param context
     * @param gameStatus
     */
    void saveGameStatus(Context context, GameStatus gameStatus);

    void savePlayers(Context context, Player[] allPlayers);

    void saveShaker(Context context, Shaker shaker);

    /**
     * //TODO
     *
     * @return
     */
    GameStatus loadGameStatus();

    Player[] loadPlayers();

    Shaker loadShaker();
}
