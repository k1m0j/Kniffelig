package com.kimoji.kniffelig.persistenz;

import com.kimoji.kniffelig.controller.game.Shaker;
import com.kimoji.kniffelig.model.GameStatus;
import com.kimoji.kniffelig.model.Player;

public interface DataStorageController {

    /**
     * saves current game state
     *
     * @param gameStatus
     * @param allPlayer
     * @param shaker
     */
    void saveGameState(GameStatus gameStatus, Player[] allPlayer, Shaker shaker);

    /**
     * loads saved game state back in game
     *
     * @return ValueHolder with gamestatus, players and shaker
     */
    ValueHolder loadGameState();
}

