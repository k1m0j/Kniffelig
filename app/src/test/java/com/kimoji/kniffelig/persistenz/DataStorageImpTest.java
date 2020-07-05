package com.kimoji.kniffelig.persistenz;

import com.kimoji.kniffelig.controller.game.Shaker;
import com.kimoji.kniffelig.model.GameStatus;
import com.kimoji.kniffelig.model.GameStatusImp;
import com.kimoji.kniffelig.model.Player;
import com.kimoji.kniffelig.model.PlayerImp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.ObjectOutput;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class DataStorageImpTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void saveGameStatusInteraction() {
        ObjectOutput oosMock = mock(ObjectOutput.class);
        DataStorageImp fm = new DataStorageImp();
        GameStatus gameStatus = new GameStatusImp(1, 2, 3);

        fm.saveGameStatus(oosMock, gameStatus);

        try {
            verify(oosMock).writeObject(any());
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void saveAndLoadGameStatusValues() {
        GameStatus gameStatus = new GameStatusImp(1, 2, 3);
        DataStorageImp fm = new DataStorageImp();

        fm.saveGameStatus(gameStatus);
        GameStatus loadedStatus = fm.loadGameStatus();

        assertEquals(1, loadedStatus.getActivePlayer());
        assertEquals(2, loadedStatus.getCurrentRound());
        assertEquals(3, loadedStatus.getLeftTries());

    }


    @Test
    void savePlayersInteraction() {

        ObjectOutput oosMock = mock(ObjectOutput.class);
        DataStorageImp fm = new DataStorageImp();
        Player[] players = {new PlayerImp("Hans"), new PlayerImp("Beate"), new PlayerImp("Thomas")};

        fm.savePlayers(oosMock, players);

        try {
            verify(oosMock).writeObject(any());
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void saveAndLoadPlayersValues() {


        DataStorageImp fm = new DataStorageImp();
        Player[] players = {new PlayerImp("Hans"), new PlayerImp("Beate"), new PlayerImp("Thomas")};
        fm.savePlayers(players);
        Player[] reloadedPlayers = fm.loadPlayers();


        assertNotEquals(players, reloadedPlayers);
        assertNotEquals(2, reloadedPlayers.length);
        assertEquals("Hans", players[0].getName());

    }

    @Test
    void saveShakerInteraction() {

        ObjectOutput oosMock = mock(ObjectOutput.class);
        DataStorageImp fm = new DataStorageImp();
        Shaker shaker = new Shaker();

        fm.saveShaker(oosMock, shaker);

        try {
            verify(oosMock).writeObject(any());
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    //Testes ob abgespeicherten Werde nach laden immer gleich sind
    @Test
    void saveAndLoadShakerValue() {
        Shaker shaker = new Shaker();

        int[] expectedValues = shaker.getValues();

        DataStorageImp fm = new DataStorageImp();

        fm.saveShaker(shaker);
        Shaker reloadedShaker = fm.loadShaker();

        assertArrayEquals(expectedValues, reloadedShaker.getValues());

    }

    @Test
    void saveAndLoadShakerLockStatus() {
        Shaker shaker = new Shaker();

        shaker.lockDice(0);
        shaker.lockDice(1);


        DataStorageImp fm = new DataStorageImp();

        fm.saveShaker(shaker);
        Shaker reloadedShaker = fm.loadShaker();

        assertTrue(reloadedShaker.isLocked(0));
        assertTrue(reloadedShaker.isLocked(1));

    }


}