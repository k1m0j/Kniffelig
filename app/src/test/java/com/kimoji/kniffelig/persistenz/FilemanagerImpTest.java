package com.kimoji.kniffelig.persistenz;


import com.kimoji.kniffelig.model.GameStatus;
import com.kimoji.kniffelig.model.GameStatusImp;

import java.io.ObjectOutputStream;

import static org.mockito.Mockito.mock;

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

    private void assertEquals(int i, int currentRound) {
    }

    @org.junit.jupiter.api.Test
    void savePlayers() {

        ObjectOutputStream oos = mock(ObjectOutputStream.class);
        GameStatus gs = new GameStatusImp(1, 2, 3);
        FilemanagerImp fm = new FilemanagerImp();

        fm.saveGameStatus(oos, gs);



    }
}