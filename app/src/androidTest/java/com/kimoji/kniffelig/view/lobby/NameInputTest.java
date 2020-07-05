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
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NameInputTest {

    @Rule
    public ActivityTestRule<LobbyActivity> mActivityTestRule = new ActivityTestRule<>(LobbyActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.WRITE_EXTERNAL_STORAGE");

    @Test
    public void insertNanmesAndCheckFirstPlayer() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btn_local_lobby), withText("Local game"),

                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.player_one_name),

                        isDisplayed()));
        appCompatEditText.perform(replaceText("hans"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.player_two_name),

                        isDisplayed()));
        appCompatEditText2.perform(replaceText("beate"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.player_three_name),

                        isDisplayed()));
        appCompatEditText3.perform(replaceText("dieter"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.player_four_name),

                        isDisplayed()));
        appCompatEditText4.perform(replaceText("inge"), closeSoftKeyboard());

        ViewInteraction editText = onView(
                allOf(withId(R.id.player_one_name), withText("hans"),

                        isDisplayed()));
        editText.check(matches(withText("hans")));

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.player_two_name), withText("beate"),

                        isDisplayed()));
        editText2.check(matches(withText("beate")));

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.player_three_name), withText("dieter"),

                        isDisplayed()));
        editText3.check(matches(withText("dieter")));

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.player_four_name), withText("inge"),

                        isDisplayed()));
        editText4.check(matches(withText("inge")));

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btn_2players), withText("Start Game"),
                        isDisplayed()));
        appCompatButton2.perform(click());
    /*
        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.btn_2players), withText("Start Game"),
                        childAtPosition(
                                withParent(withId(R.id.viewPager)),
                                4),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.current_Player), withText("hans"),
                        childAtPosition(
                                allOf(withId(R.id.shaker_fragment),
                                        withParent(withId(R.id.view_pager))),
                                3),
                        isDisplayed()));
        textView.check(matches(withText("hans")));

     */
    }


}
