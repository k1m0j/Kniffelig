package com.kimoji.kniffelig.view.mainActivity;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;
import androidx.test.runner.AndroidJUnit4;

import com.kimoji.kniffelig.R;
import com.kimoji.kniffelig.view.lobby.LobbyActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<LobbyActivity> mActivityTestRule = new ActivityTestRule<>(LobbyActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.WRITE_EXTERNAL_STORAGE");

    @Test
    public void startApp() {
        ViewInteraction localGameButton = onView(
                allOf(withId(R.id.btn_local_lobby), childAtPosition(withParent(withId(R.id.viewPager)), 0), isDisplayed()));
        localGameButton.check(matches(isDisplayed()));

        ViewInteraction bluetoothLobbyButton = onView(allOf(withId(R.id.btn_bluetooth_lobby),
                childAtPosition(withParent(withId(R.id.viewPager)), 1), isDisplayed()));
        bluetoothLobbyButton.check(matches(isDisplayed()));

        onView(withId(R.id.btn_local_lobby)).check(matches(isClickable()));
        onView(withId(R.id.btn_bluetooth_lobby)).check(matches(isClickable()));
    }

    @Test
    public void startLocalGame() {

        onView(withId(R.id.btn_local_lobby)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_local_lobby)).check(matches(isClickable()));


        onView(withId(R.id.btn_local_lobby)).perform(click());


    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
