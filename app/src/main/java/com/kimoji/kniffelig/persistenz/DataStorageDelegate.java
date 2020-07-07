package com.kimoji.kniffelig.persistenz;

import com.kimoji.kniffelig.controller.game.Shaker;
import com.kimoji.kniffelig.model.GameStatus;
import com.kimoji.kniffelig.model.Player;

public class DataStorageDelegate implements DataStorageController {

    DataStorageImp dataStorage;


    public DataStorageDelegate() {
        this.dataStorage = new DataStorageImp();
    }

    @Override
    public void saveGameState(GameStatus gameStatus, Player[] allPlayer, Shaker shaker) {
        dataStorage.saveGameStatus(gameStatus);
        dataStorage.savePlayers(allPlayer);
        dataStorage.saveShaker(shaker);
    }

    @Override
    public ValueHolder loadGameState() {
        GameStatus gameStatus = dataStorage.loadGameStatus();
        Player[] players = dataStorage.loadPlayers();
        Shaker shaker = dataStorage.loadShaker();

        ValueHolder valueHolder = new ValueHolder(gameStatus, players, shaker);
        return valueHolder;
    }
}
