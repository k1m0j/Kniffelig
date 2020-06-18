package com.kimoji.kniffelig.controller.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ShakerTest {

    private Shaker shaker;
    private int min;
    private int max;

    @BeforeEach
    void setUp() {
        shaker = new Shaker();
        min = 0;
        max = 6;
    }

    @Test
    void getDiceArrayLength() {
        assertEquals(5, shaker.getDiceArrayLength());
    }

    @Test
    void shake() {
        shaker.shake();
    }

    @Test
    void lockDice() {
        shaker.lockDice(0);
        assertTrue(shaker.isLocked(0));
    }


    @Test
    void freeDice() {
        shaker.freeDice(4);
        assertFalse(shaker.isLocked(4));
    }

    @Test
    void getValuesIndex0Check() {
        int[] values = shaker.getValues();
        int valueIndex_0 = values[0];
        assertTrue(min <= valueIndex_0 && valueIndex_0 <= max);
    }

    @Test
    void getValuesIndex1Check() {
        int[] values = shaker.getValues();
        int valueIndex_1 = values[1];
        assertTrue(min <= valueIndex_1 && valueIndex_1 <= max);
    }

    @Test
    void getValuesIndex2Check() {
        int[] values = shaker.getValues();
        int valueIndex_2 = values[2];
        assertTrue(min <= valueIndex_2 && valueIndex_2 <= max);
    }

    @Test
    void getValuesIndex3Check() {
        int[] values = shaker.getValues();
        int valueIndex_3 = values[3];
        assertTrue(min <= valueIndex_3 && valueIndex_3 <= max);
    }

    @Test
    void getValuesIndex4Check() {
        int[] values = shaker.getValues();
        int valueIndex_4 = values[4];
        assertTrue(min <= valueIndex_4 && valueIndex_4 <= max);
    }

    @Test
    void setAllFree() {
        shaker.setAllFree();
    }

    @Test
    void toggleLock() {
        shaker.toggleLock(3);
        assertTrue(shaker.isLocked(3));
    }

    @Test
    void isLocked() {
        shaker.isLocked(2);

    }
}