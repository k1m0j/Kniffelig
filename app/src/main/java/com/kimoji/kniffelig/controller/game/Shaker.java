package com.kimoji.kniffelig.controller.game;


import com.kimoji.kniffelig.model.game.DiceImp;
import com.kimoji.kniffelig.model.game.Dice;

import java.io.Serializable;
import java.util.Random;

public class Shaker implements Serializable {
    private static final String TAG = "Shaker";

    Random random = new Random();

    private final Dice[] dices = {new DiceImp(), new DiceImp(), new DiceImp(), new DiceImp(), new DiceImp()};

    public Shaker() {
        for (Dice dice : dices) {
            dice.setValue(getNewDiceValue());
        }
        System.out.println(dices[0].getValue() + "lol" + dices[1].getValue() + "" + dices[2].getValue() + "" + dices[3].getValue() + "" + dices[4]
                .getValue() + "");
    }

    public int getDiceArrayLength() {
        return dices.length;
    }


    public void shake() {
        for (Dice dice : dices) {
            if (!dice.isLocked())
                dice.setValue(getNewDiceValue());
        }
    }

    public void lockDice(int index) {
        dices[index].lock();
    }

    public void freeDice(int index) {
        dices[index].unlock();
    }

    public int[] getValues() {
        return new int[]{dices[0].getValue(), dices[1].getValue(), dices[2].getValue(), dices[3].getValue(),
                dices[4].getValue()};
    }

    public void setAllFree() {
        for (Dice dice : dices)
            dice.unlock();
    }

    public void toggleLock(int index) {
        dices[index].toggleLock();
    }

    public boolean isLocked(int index) {
        return dices[index].isLocked();
    }

    private int getNewDiceValue() {
        return random.nextInt(5) + 1;
    }

}
