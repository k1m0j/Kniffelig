package com.kimoji.kniffelig.persistenz;

import com.kimoji.kniffelig.controller.game.Shaker;
import com.kimoji.kniffelig.model.GameStatus;
import com.kimoji.kniffelig.model.Player;

public class DataStorageDelegater implements DataStorageController {

    DataStorageImp fm;


    public DataStorageDelegater() {
        this.fm = new DataStorageImp();
    }

    @Override
    public void saveGameState(GameStatus gameStatus, Player[] allPlayer, Shaker shaker) {
        fm.saveGameStatus(gameStatus);
        fm.savePlayers(allPlayer);
        fm.saveShaker(shaker);
    }

    @Override
    public ValueHolder loadGameState() {
        GameStatus gameStatus = fm.loadGameStatus();
        Player[] players = fm.loadPlayers();
        Shaker shaker = fm.loadShaker();

        ValueHolder valueHolder = new ValueHolder(gameStatus, players, shaker);
        return valueHolder;
    }
}
