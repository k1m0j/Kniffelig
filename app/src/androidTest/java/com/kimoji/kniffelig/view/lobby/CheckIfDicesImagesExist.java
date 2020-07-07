package com.kimoji.kniffelig.view.lobby;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;
import androidx.test.runner.AndroidJUnit4;

import com.kimoji.kniffelig.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CheckIfDicesImagesExist {

    @Rule
    public ActivityTestRule<LobbyActivity> mActivityTestRule = new ActivityTestRule<>(LobbyActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.WRITE_EXTERNAL_STORAGE");


    //checks if images exists in shakerFragment, also checks setting playernames in activity before
    @Test
    public void checkIfDicesImagesExist() {
        ViewInteraction appCompatButton = onView(allOf(withId(R.id.btn_local_lobby), withText("Local game"), isDisplayed()));
        appCompatButton.perform(click());

        //Input names
        ViewInteraction inputPlayerOneName = onView(allOf(withId(R.id.player_one_name), isDisplayed()));
        inputPlayerOneName.perform(replaceText("a"), closeSoftKeyboard());

        ViewInteraction inputPlayerTwoName = onView(allOf(withId(R.id.player_two_name), isDisplayed()));
        inputPlayerTwoName.perform(replaceText("b"), closeSoftKeyboard());

        ViewInteraction inputPlayerThreeName = onView(allOf(withId(R.id.player_three_name), isDisplayed()));
        inputPlayerThreeName.perform(replaceText("c"), closeSoftKeyboard());

        ViewInteraction inputPlayerFourName = onView(allOf(withId(R.id.player_four_name), isDisplayed()));
        inputPlayerFourName.perform(replaceText("d"), closeSoftKeyboard());

        ViewInteraction startGame = onView(allOf(withId(R.id.btn_2players), withText("Start Game"), isDisplayed()));
        startGame.perform(click());

        ViewInteraction appCompatImageButton = onView(allOf(withId(R.id.shake_Button), isDisplayed()));

        //shake interaction
        appCompatImageButton.perform(click());


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


}
