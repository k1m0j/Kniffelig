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
public class SetScoreTest {

    @Rule
    public ActivityTestRule<LobbyActivity> mActivityTestRule = new ActivityTestRule<>(LobbyActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule = GrantPermissionRule.grant("android.permission.WRITE_EXTERNAL_STORAGE");

    @Test
    public void setScoreTest() {
        ViewInteraction appCompatButton = onView(allOf(withId(R.id.btn_local_lobby), withText("Local game"),
                isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatEditText = onView(allOf(withId(R.id.player_one_name),
                isDisplayed()));

        appCompatEditText.perform(replaceText("Graeber"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(allOf(withId(R.id.player_two_name),
                isDisplayed()));
        appCompatEditText2.perform(replaceText("Wright"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(allOf(withId(R.id.player_three_name),
                isDisplayed()));

        appCompatEditText3.perform(replaceText("Lanier"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(allOf(withId(R.id.player_four_name),
                isDisplayed()));

        appCompatEditText4.perform(replaceText("Zuboff"), closeSoftKeyboard());


        ViewInteraction appCompatButton2 = onView(allOf(withId(R.id.btn_2players), withText("Start Game"),
                isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatImageButton = onView(allOf(withId(R.id.shake_Button),
                isDisplayed()));
        appCompatImageButton.perform(click());


        //Swipe left and right
        ViewInteraction tabView = onView(allOf(withContentDescription("Score Board"),
                isDisplayed()));
        tabView.perform(click());

        ViewInteraction tabView2 = onView(allOf(withContentDescription("Shaker"),
                isDisplayed()));
        tabView2.perform(click());

        //check score board fragment
        ViewInteraction tabView3 = onView(allOf(withContentDescription("Score Board"),

                isDisplayed()));
        tabView3.perform(click());

        ViewInteraction appCompatButton3 = onView(allOf(withId(R.id.btn_sixes), withText("Sixes")
        ));
        appCompatButton3.perform(scrollTo(), click());

        ViewInteraction tabView4 = onView(allOf(withContentDescription("Shaker"),
                isDisplayed()));
        tabView4.perform(click());

        ViewInteraction appCompatImageButton2 = onView(allOf(withId(R.id.shake_Button),
                isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction appCompatImageButton3 = onView(allOf(withId(R.id.shake_Button),
                isDisplayed()));
        appCompatImageButton3.perform(click());
    }
}
