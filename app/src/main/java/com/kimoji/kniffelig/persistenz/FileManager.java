package com.kimoji.kniffelig.persistenz;

import com.kimoji.kniffelig.controller.game.Shaker;
import com.kimoji.kniffelig.model.GameStatus;
import com.kimoji.kniffelig.model.Player;

public interface FileManager {

    void saveGameState(GameStatus gameStatus, Player[] allPlayer, Shaker shaker);

    ValueHolder loadGameState();
}

