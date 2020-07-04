package com.kimoji.kniffelig.view.game;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.kimoji.kniffelig.R;
import com.kimoji.kniffelig.controller.game.Playground;
import com.kimoji.kniffelig.exception.InvalidUserInteractionException;

import java.util.ArrayList;

public class ShakerFragment extends Fragment {

    private ImageButton shakeDices;
    private ImageView imageView1, imageView2, imageView3, imageView4, imageView5;
    private TextView currentPlayer, currentRound, shakesLeft;

    private Playground playground;

    //Log - Hilfe
    private static final String TAG = "PlayingInterface";

    public ShakerFragment(Playground playground) {
        this.playground = playground;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shaker_fragment, container, false);
        shakeDices = view.findViewById(R.id.shake_Button);
        shakeDices.setOnClickListener(this::onShakeButton);

        imageView1 = view.findViewById(R.id.imageViewDice1);
        imageView1.setOnClickListener(this::lockDice1);

        imageView2 = view.findViewById(R.id.imageViewDice2);
        imageView2.setOnClickListener(this::lockDice2);

        imageView3 = view.findViewById(R.id.imageViewDice3);
        imageView3.setOnClickListener(this::lockDice3);

        imageView4 = view.findViewById(R.id.imageViewDice4);
        imageView4.setOnClickListener(this::lockDice4);

        imageView5 = view.findViewById(R.id.imageViewDice5);
        imageView5.setOnClickListener(this::lockDice5);

        currentPlayer = view.findViewById(R.id.current_Player);
        currentRound = view.findViewById(R.id.current_Round);
        shakesLeft = view.findViewById(R.id.shakes_left);

        currentRound.setText(String.valueOf(playground.getCurrentRound()));
        currentPlayer.setText((playground.getActivePlayerName()));
        shakesLeft.setText(String.valueOf(playground.getLeftTries()));

        updateView();

        setAllDicesColorRed();

        return view;
    }

    public void setImagesToDiceValue() {
        ArrayList<Integer> resources = getResourcesOwn(playground.getCurrentDiceValues());
        ImageView[] images = {imageView1, imageView2, imageView3, imageView4, imageView5};
        ArrayList<ImageView> imageViews = new ArrayList<>();
        for (ImageView element : images) {
            imageViews.add(element);
        }
        for (int i = 0; i < imageViews.size(); i++) {
            images[i].setImageResource(resources.get(i));
        }
    }

    public void onShakeButton(View view) {
        try {
            playground.shake();
        } catch (InvalidUserInteractionException e) {
            e.printStackTrace();
        }
        //Konsolenausgabe, um Werte zu überprüfen
        printValues();
        final Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.shake);
        final Animation.AnimationListener animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setImagesToDiceValue();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        };
        anim.setAnimationListener(animationListener);
        ImageView[] images = {imageView1, imageView2, imageView3, imageView4, imageView5};
        //Animationsstart der Images
        for (int i = 0; i < images.length; i++) {
            images[i].startAnimation(anim);
        }
        updateView();
    }


    public void lockDice1(View view) {
        adjustColorToLockStatus(0, imageView1);
    }

    public void lockDice2(View view) {
        adjustColorToLockStatus(1, imageView2);
    }

    public void lockDice3(View view) {
        adjustColorToLockStatus(2, imageView3);
    }

    public void lockDice4(View view) {
        adjustColorToLockStatus(3, imageView4);
    }

    public void lockDice5(View view) {
        adjustColorToLockStatus(4, imageView5);
    }

    public void setAllDicesColorRed() {
        imageView1.setColorFilter(Color.RED);
        imageView2.setColorFilter(Color.RED);
        imageView3.setColorFilter(Color.RED);
        imageView4.setColorFilter(Color.RED);
        imageView5.setColorFilter(Color.RED);
    }

    public void updateView() {
        setImagesToDiceValue();
        shakesLeft.setText(String.valueOf(playground.getLeftTries()));
        currentRound.setText(String.valueOf(playground.getCurrentRound()));
        currentPlayer.setText(playground.getActivePlayerName());
    }


    /**
     * Hilfmethode, um Würfelwerte in Konsole anzuzeigen
     */
    private void printValues() {
        System.out.println("Würfelwert: ");
        int[] values = playground.getCurrentDiceValues();

        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }

    /**
     * Ermittelt Resources/ID für passendes Bild anhand der erwürfelten Werte
     *
     * @param values, zufälligen Werte des Wurfes
     * @return Ressource ID in ArrayList
     */
    private ArrayList<Integer> getResourcesOwn(int[] values) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            temp.add(getResources().getIdentifier(getString(R.string.pictureName) + values[i], "drawable", getString(R.string.defaultPackage)));
        }
        return temp;
    }

    private void adjustColorToLockStatus(int i, ImageView imageView) {
        Log.i(TAG, "onClick: 1 angeklickt!");
        if (playground.isLocked(i) == false) {
            playground.lockDice(i);
            imageView.setColorFilter(Color.GREEN);
        } else {
            playground.unlockDice(i);
            imageView.setColorFilter(Color.RED);
        }
    }
}
