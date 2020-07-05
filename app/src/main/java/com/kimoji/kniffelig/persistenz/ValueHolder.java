package com.kimoji.kniffelig.persistenz;

import com.kimoji.kniffelig.controller.game.Shaker;
import com.kimoji.kniffelig.model.GameStatus;
import com.kimoji.kniffelig.model.Player;

public class ValueHolder {

    GameStatus gameStatus;
    Player[] players;
    Shaker shaker;

    public ValueHolder(GameStatus gameStatus, Player[] players, Shaker shaker) {
        this.gameStatus = gameStatus;
        this.players = players;
        this.shaker = shaker;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Shaker getShaker() {
        return shaker;
    }

    public void setShaker(Shaker shaker) {
        this.shaker = shaker;
    }
}
