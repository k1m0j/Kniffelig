package com.kimoji.kniffelig.view.lobby;


import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;
import androidx.test.runner.AndroidJUnit4;

import com.kimoji.kniffelig.R;


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
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LobbyTestInputNames {

    @Rule
    public ActivityTestRule<LobbyActivity> mActivityTestRule = new ActivityTestRule<>(LobbyActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.WRITE_EXTERNAL_STORAGE");


    //User wants to start app and insert names for different players
    @Test
    public void lobbyActivityNamingTest() {
        ViewInteraction appCompatButton = onView(allOf(withId(R.id.btn_local_lobby), withText("Local game"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatEditText = onView(allOf(withId(R.id.player_one_name), isDisplayed()));
        appCompatEditText.perform(replaceText("a"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(allOf(withId(R.id.player_two_name), isDisplayed()));
        appCompatEditText2.perform(replaceText("b"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(allOf(withId(R.id.player_two_name), withText("b"), isDisplayed()));
        appCompatEditText3.perform(click());

        ViewInteraction appCompatEditText4 = onView(allOf(withId(R.id.player_two_name), withText("b"), isDisplayed()));
        appCompatEditText4.perform(click());

        ViewInteraction appCompatEditText5 = onView(allOf(withId(R.id.player_three_name),
                isDisplayed()));
        appCompatEditText5.perform(replaceText("c"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.player_four_name),

                        isDisplayed()));
        appCompatEditText6.perform(replaceText("d"), closeSoftKeyboard());

        ViewInteraction editText = onView(
                allOf(withId(R.id.editTextTextPersonName1), withText("Player 1: "),

                        isDisplayed()));
        editText.check(matches(withText("Player 1: ")));

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.editTextTextPersonName1), withText("Player 1: "),

                        isDisplayed()));
        editText2.check(matches(isDisplayed()));

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.player_one_name), withText("a"),

                        isDisplayed()));
        editText3.check(matches(isDisplayed()));

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.player_one_name), withText("a"),

                        isDisplayed()));
        editText4.check(matches(withText("a")));

        ViewInteraction button = onView(
                allOf(withId(R.id.btn_2players),

                        isDisplayed()));
        button.check(matches(isDisplayed()));
    }


}
