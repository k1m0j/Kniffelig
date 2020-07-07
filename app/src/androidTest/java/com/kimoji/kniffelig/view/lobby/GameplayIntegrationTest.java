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
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class GameplayIntegrationTest {

    @Rule
    public ActivityTestRule<LobbyActivity> mActivityTestRule = new ActivityTestRule<>(LobbyActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.WRITE_EXTERNAL_STORAGE");

    @Test
    public void gamePlayIntegrationTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btn_local_lobby), withText("Local game"),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.player_one_name)));
        appCompatEditText.perform(replaceText("a"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.player_two_name)));
        appCompatEditText2.perform(replaceText("b"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.player_three_name)));
        appCompatEditText3.perform(replaceText("c"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.player_four_name)));
        appCompatEditText4.perform(replaceText("d"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btn_2players), withText("Start Game")));
        appCompatButton2.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.shake_Button)));
        appCompatImageButton.perform(click());

        ViewInteraction tabView = onView(
                allOf(withContentDescription("Score Board")));
        tabView.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.btn_aces), withText("Aces")));
        appCompatButton3.perform(scrollTo(), click());

        ViewInteraction tabView2 = onView(
                allOf(withContentDescription("Shaker")));
        tabView2.perform(click());

        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.imageViewDice2)));
        appCompatImageView.perform(click());

        ViewInteraction appCompatImageView2 = onView(
                allOf(withId(R.id.imageViewDice5)));
        appCompatImageView2.perform(click());

        ViewInteraction appCompatImageView3 = onView(
                allOf(withId(R.id.imageViewDice3)));
        appCompatImageView3.perform(click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withId(R.id.shake_Button)));
        appCompatImageButton2.perform(click());

        ViewInteraction tabView3 = onView(
                allOf(withContentDescription("Score Board")));
        tabView3.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.btn_fives), withText("Fives")));
        appCompatButton4.perform(scrollTo(), click());

        ViewInteraction tabView4 = onView(
                allOf(withContentDescription("Shaker")
                ));
        tabView4.perform(click());

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withId(R.id.shake_Button),

                        isDisplayed()));
        appCompatImageButton3.perform(click());

        ViewInteraction appCompatImageView4 = onView(
                allOf(withId(R.id.imageViewDice5),

                        isDisplayed()));
        appCompatImageView4.perform(click());

        ViewInteraction appCompatImageView5 = onView(
                allOf(withId(R.id.imageViewDice1),
                        isDisplayed()));
        appCompatImageView5.perform(click());

        ViewInteraction appCompatImageView6 = onView(
                allOf(withId(R.id.imageViewDice2),
                        isDisplayed()));
        appCompatImageView6.perform(click());

        ViewInteraction appCompatImageView7 = onView(
                allOf(withId(R.id.imageViewDice3),
                        isDisplayed()));
        appCompatImageView7.perform(click());

        ViewInteraction tabView5 = onView(
                allOf(withContentDescription("Score Board"),
                        isDisplayed()));
        tabView5.perform(click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.btn_smallStraight), withText("Small S")));
        appCompatButton5.perform(scrollTo(), click());

        ViewInteraction tabView6 = onView(
                allOf(withContentDescription("Shaker"),
                        isDisplayed()));
        tabView6.perform(click());

        ViewInteraction appCompatImageButton4 = onView(
                allOf(withId(R.id.shake_Button),

                        isDisplayed()));
        appCompatImageButton4.perform(click());
    }
}
