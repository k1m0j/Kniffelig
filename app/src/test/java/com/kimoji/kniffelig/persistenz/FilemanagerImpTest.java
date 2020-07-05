package com.kimoji.kniffelig.persistenz;

import android.content.Context;

import com.kimoji.kniffelig.model.GameStatus;
import com.kimoji.kniffelig.model.GameStatusImp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class FilemanagerImpTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void saveGameStatus() {


    }

    @org.junit.jupiter.api.Test
    void loadGameStatus() {

        ObjectOutputStream oos = mock(ObjectOutputStream.class);
        GameStatus expectedStatus = new GameStatusImp(2, 3, 1);

        FilemanagerImp filemanagerImp = new FilemanagerImp();

        filemanagerImp.saveGameStatus(oos, expectedStatus);

        GameStatus actualGameStatus = filemanagerImp.loadGameStatus();

        assertEquals(3, actualGameStatus.getCurrentRound());


    }

    @org.junit.jupiter.api.Test
    void savePlayers() {

        ObjectOutputStream oos = mock(ObjectOutputStream.class);
        GameStatus gs = new GameStatusImp(1, 2, 3);
        FilemanagerImp fm = new FilemanagerImp();

        fm.saveGameStatus(oos, gs);

        try {
            verify(oos).writeObject(any());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}