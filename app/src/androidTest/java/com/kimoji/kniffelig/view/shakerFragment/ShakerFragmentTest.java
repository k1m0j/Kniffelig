package com.kimoji.kniffelig.view.shakerFragment;

import android.view.View;

import androidx.fragment.app.FragmentTransaction;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;

import androidx.test.rule.ActivityTestRule;

import com.kimoji.kniffelig.R;
import com.kimoji.kniffelig.controller.game.Playground;
import com.kimoji.kniffelig.controller.game.PlaygroundImp;

import com.kimoji.kniffelig.view.game.GameActivity;
import com.kimoji.kniffelig.view.game.ShakerFragment;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

public class ShakerFragmentTest {

    private String[] playerNames = {"Zuboff", "Lanier", "Wright", "Graeber"};


    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(
            GameActivity.class);

    @Test
    public void shakerFragmentInit() {
        Playground playground = new PlaygroundImp(playerNames);
        activityRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ShakerFragment shakerFragment = startShakerFragment(playground);
            }
        });
        //Fragment itself
        onView(withId(R.id.shaker_fragment)).check(matches(isDisplayed()));

        //load and save
        onView(withId(R.id.load)).check(matches(isDisplayed()));
        onView(withId(R.id.load)).check(matches(isClickable()));
        onView(withId(R.id.save)).check(matches(isDisplayed()));
        onView(withId(R.id.save)).check(matches(isClickable()));

        //currentPlayer and description
        //  onView(withId(R.id.current_Player)).check(matches(isDisplayed()));
        onView(withId(R.id.current_Player_description)).check(matches(isDisplayed()));

        //currentRound and description
        onView(withId(R.id.current_Round)).check(matches(isDisplayed()));
        onView(withId(R.id.current_Round_description)).check(matches(isDisplayed()));

        //leftShakes and description
        onView(withId(R.id.shakes_left)).check(matches(isDisplayed()));
        onView(withId(R.id.shakes_left_description)).check(matches(isDisplayed()));

        //shakeButton
        onView(withId(R.id.shake_Button)).check(matches(isDisplayed()));
        onView(withId(R.id.shake_Button)).check(matches(isClickable()));


        //Dices
        onView(withId(R.id.imageViewDice1)).check(matches(isDisplayed()));
        onView(withId(R.id.imageViewDice2)).check(matches(isDisplayed()));
        onView(withId(R.id.imageViewDice3)).check(matches(isDisplayed()));
        onView(withId(R.id.imageViewDice4)).check(matches(isDisplayed()));
        onView(withId(R.id.imageViewDice5)).check(matches(isDisplayed()));


        onView(withId(R.id.imageViewDice1)).check(matches(isClickable()));
        onView(withId(R.id.imageViewDice2)).check(matches(isClickable()));
        onView(withId(R.id.imageViewDice3)).check(matches(isClickable()));
        onView(withId(R.id.imageViewDice4)).check(matches(isClickable()));
        onView(withId(R.id.imageViewDice5)).check(matches(isClickable()));


    }

    //view - gamelogik - model //in progress //
    @Test
    public void integrationTest() {

        Playground playground = new PlaygroundImp(playerNames);
        activityRule.getActivity().runOnUiThread(() -> {
            startShakerFragment(playground);
        });

        //shake
        onView(withId(R.id.shake_Button)).perform(click());

        //verify first player / leftTries / view
        assertEquals("Zuboff", playground.getActivePlayerName());
        assertEquals(0, playground.getActivePlayer());
        assertEquals(2, playground.getLeftTries());

        //onView(isRoot()).perform(waitFor(5000));
        //shake  -> lessTries..
        onView(withId(R.id.shake_Button)).perform(click());

        // onView(isRoot()).perform(waitFor(5000));


        assertEquals("Zuboff", playground.getActivePlayerName());
        assertEquals(0, playground.getActivePlayer());


        onView(withId(R.id.current_Round)).check(matches(withText("0")));
        assertEquals("Zuboff", playground.getActivePlayerName());

        System.out.println("playground = " + playground.getActivePlayerName() + " " + playground.getLeftTries());

    }


    private ShakerFragment startShakerFragment(Playground playground) {
        GameActivity activity = (GameActivity) activityRule.getActivity();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        ShakerFragment shakerFragment = new ShakerFragment(playground);
        transaction.add(shakerFragment, "shakerFragment");
        transaction.commit();
        return shakerFragment;
    }

    /**
     * Perform action of waiting for a specific time.
     */
    public static ViewAction waitFor(final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "Wait for " + millis + " milliseconds.";
            }

            @Override
            public void perform(UiController uiController, final View view) {
                uiController.loopMainThreadForAtLeast(millis);
            }
        };
    }
}
