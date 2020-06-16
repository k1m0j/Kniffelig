package com.kimoji.kniffelig.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    private Dice testDice;

    @BeforeEach
    void setUp() {
        testDice = new DiceImp();
    }

    @Test
    void getValue() {
        testDice.setValue(3);
        assertEquals(3, testDice.getValue());
    }

    @Test
    void setValue_1() {
        testDice.setValue(1);
        assertEquals(1, testDice.getValue());
    }

    @Test
    void setValue_2() {
        testDice.setValue(2);
        assertEquals(2, testDice.getValue());
    }

    @Test
    void setValue_3() {
        testDice.setValue(3);
        assertEquals(3, testDice.getValue());
    }

    @Test
    void setValue_4() {
        testDice.setValue(4);
        assertEquals(4, testDice.getValue());
    }

    @Test
    void setValue_5() {
        testDice.setValue(5);
        assertEquals(5, testDice.getValue());
    }

    @Test
    void setValue_6() {
        testDice.setValue(6);
        assertEquals(6, testDice.getValue());
    }

    @Test
    void setWrongValue() {
        assertThrows(IllegalArgumentException.class, () ->
                testDice.setValue(1000));
    }

    @Test
    void setWrongValue_0() {
        assertThrows(IllegalArgumentException.class, () ->
                testDice.setValue(0));
    }


    @Test
    void isLockedAfterInitTest() {
        assertEquals(false, testDice.isLocked());
    }

    @Test
    void lockTest() {
        testDice.lock();
        assertEquals(true, testDice.isLocked());
    }

    @Test
    void unlockTest() {
        testDice.unlock();
        assertEquals(false, testDice.isLocked());
    }

    @Test
    void toggleLockTest() {
        testDice.toggleLock();
        assertEquals(true, testDice.isLocked());
    }

}