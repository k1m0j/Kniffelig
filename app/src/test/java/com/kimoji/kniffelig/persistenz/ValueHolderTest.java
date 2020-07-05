package com.kimoji.kniffelig.persistenz;


import com.kimoji.kniffelig.controller.game.Shaker;
import com.kimoji.kniffelig.model.GameStatus;
import com.kimoji.kniffelig.model.Player;
import com.kimoji.kniffelig.model.PlayerImp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ValueHolderTest {

    GameStatus gameStatus;
    Player[] players;
    Shaker shaker;
    ValueHolder valueHolder;


    @BeforeEach
    void setUp() {
        gameStatus = mock(GameStatus.class);
        shaker = mock(Shaker.class);
        players = new Player[]{mock(PlayerImp.class), mock(PlayerImp.class)};
        valueHolder = new ValueHolder(gameStatus, players, shaker);
    }


    @Test
    void getGameStatus() {
        assertEquals(gameStatus, valueHolder.getGameStatus());
    }

    @Test
    void getPlayers() {
        assertEquals(players, valueHolder.getPlayers());
    }

    @Test
    void getShaker() {
        assertEquals(shaker, valueHolder.getShaker());
    }

    @Test
    void setShaker() {
        Shaker newShaker = new Shaker();
        valueHolder.setShaker(newShaker);
        assertEquals(newShaker, valueHolder.getShaker());
    }
}