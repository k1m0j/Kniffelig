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
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
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
public class GameFlowValidation {

    @Rule
    public ActivityTestRule<LobbyActivity> mActivityTestRule = new ActivityTestRule<>(LobbyActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.WRITE_EXTERNAL_STORAGE");

    @Test
    public void mausUndHausMussRaus() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btn_local_lobby), withText("Local game"),
                        childAtPosition(
                                withParent(withId(R.id.viewPager)),
                                0),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.player_one_name),
                        childAtPosition(
                                withParent(withId(R.id.viewPager)),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("a"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.player_two_name),
                        childAtPosition(
                                withParent(withId(R.id.viewPager)),
                                3),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("b"), closeSoftKeyboard());


        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.player_three_name),
                        childAtPosition(
                                withParent(withId(R.id.viewPager)),
                                5),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("ba"), closeSoftKeyboard());


        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.player_four_name),
                        childAtPosition(
                                withParent(withId(R.id.viewPager)),
                                7),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("zu"), closeSoftKeyboard());


        ViewInteraction button = onView(
                allOf(withId(R.id.btn_2players),
                        childAtPosition(
                                withParent(withId(R.id.viewPager)),
                                8),
                        isDisplayed()));
        button.check(matches(isDisplayed()));


        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btn_2players), withText("Start Game"),
                        childAtPosition(
                                withParent(withId(R.id.viewPager)),
                                8),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction imageButton = onView(
                allOf(withId(R.id.shake_Button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.shaker_fragment),
                                        3),
                                1),
                        isDisplayed()));
        imageButton.check(matches(isDisplayed()));

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.shake_Button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.shaker_fragment),
                                        3),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.imageViewDice3),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        1),
                                0),
                        isDisplayed()));
        appCompatImageView.perform(click());

        ViewInteraction appCompatImageView2 = onView(
                allOf(withId(R.id.imageViewDice4),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatImageView2.perform(click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withId(R.id.shake_Button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.shaker_fragment),
                                        3),
                                1),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction tabView = onView(
                allOf(withContentDescription("Score Board"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                1),
                        isDisplayed()));
        tabView.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.btn_aces), withText("Aces"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        1),
                                0)));
        appCompatButton4.perform(scrollTo(), click());

        ViewInteraction tabView2 = onView(
                allOf(withContentDescription("Shaker"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                0),
                        isDisplayed()));
        tabView2.perform(click());
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
