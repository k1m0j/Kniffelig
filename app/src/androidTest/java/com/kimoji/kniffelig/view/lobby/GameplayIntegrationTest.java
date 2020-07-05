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
                        childAtPosition(
                                withParent(withId(R.id.viewPager)),
                                0),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.player_one_name),
                        childAtPosition(
                                withParent(withId(R.id.viewPager)),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("a"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.player_two_name),
                        childAtPosition(
                                withParent(withId(R.id.viewPager)),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("b"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.player_three_name),
                        childAtPosition(
                                withParent(withId(R.id.viewPager)),
                                2),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("c"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.player_four_name),
                        childAtPosition(
                                withParent(withId(R.id.viewPager)),
                                3),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("d"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btn_2players), withText("Start Game"),
                        childAtPosition(
                                withParent(withId(R.id.viewPager)),
                                4),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.shake_Button),
                        childAtPosition(
                                allOf(withId(R.id.shaker_fragment),
                                        withParent(withId(R.id.view_pager))),
                                8),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction tabView = onView(
                allOf(withContentDescription("Score Board"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                1),
                        isDisplayed()));
        tabView.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.btn_aces), withText("Aces"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        1),
                                0)));
        appCompatButton3.perform(scrollTo(), click());

        ViewInteraction tabView2 = onView(
                allOf(withContentDescription("Shaker"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                0),
                        isDisplayed()));
        tabView2.perform(click());

        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.imageViewDice2),
                        childAtPosition(
                                allOf(withId(R.id.shaker_fragment),
                                        withParent(withId(R.id.view_pager))),
                                4),
                        isDisplayed()));
        appCompatImageView.perform(click());

        ViewInteraction appCompatImageView2 = onView(
                allOf(withId(R.id.imageViewDice5),
                        childAtPosition(
                                allOf(withId(R.id.shaker_fragment),
                                        withParent(withId(R.id.view_pager))),
                                7),
                        isDisplayed()));
        appCompatImageView2.perform(click());

        ViewInteraction appCompatImageView3 = onView(
                allOf(withId(R.id.imageViewDice3),
                        childAtPosition(
                                allOf(withId(R.id.shaker_fragment),
                                        withParent(withId(R.id.view_pager))),
                                5),
                        isDisplayed()));
        appCompatImageView3.perform(click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withId(R.id.shake_Button),
                        childAtPosition(
                                allOf(withId(R.id.shaker_fragment),
                                        withParent(withId(R.id.view_pager))),
                                8),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction tabView3 = onView(
                allOf(withContentDescription("Score Board"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                1),
                        isDisplayed()));
        tabView3.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.btn_fives), withText("Fives"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        5),
                                0)));
        appCompatButton4.perform(scrollTo(), click());

        ViewInteraction tabView4 = onView(
                allOf(withContentDescription("Shaker"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                0),
                        isDisplayed()));
        tabView4.perform(click());

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withId(R.id.shake_Button),
                        childAtPosition(
                                allOf(withId(R.id.shaker_fragment),
                                        withParent(withId(R.id.view_pager))),
                                8),
                        isDisplayed()));
        appCompatImageButton3.perform(click());

        ViewInteraction appCompatImageView4 = onView(
                allOf(withId(R.id.imageViewDice5),
                        childAtPosition(
                                allOf(withId(R.id.shaker_fragment),
                                        withParent(withId(R.id.view_pager))),
                                7),
                        isDisplayed()));
        appCompatImageView4.perform(click());

        ViewInteraction appCompatImageView5 = onView(
                allOf(withId(R.id.imageViewDice1),
                        childAtPosition(
                                allOf(withId(R.id.shaker_fragment),
                                        withParent(withId(R.id.view_pager))),
                                3),
                        isDisplayed()));
        appCompatImageView5.perform(click());

        ViewInteraction appCompatImageView6 = onView(
                allOf(withId(R.id.imageViewDice2),
                        childAtPosition(
                                allOf(withId(R.id.shaker_fragment),
                                        withParent(withId(R.id.view_pager))),
                                4),
                        isDisplayed()));
        appCompatImageView6.perform(click());

        ViewInteraction appCompatImageView7 = onView(
                allOf(withId(R.id.imageViewDice3),
                        childAtPosition(
                                allOf(withId(R.id.shaker_fragment),
                                        withParent(withId(R.id.view_pager))),
                                5),
                        isDisplayed()));
        appCompatImageView7.perform(click());

        ViewInteraction tabView5 = onView(
                allOf(withContentDescription("Score Board"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                1),
                        isDisplayed()));
        tabView5.perform(click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.btn_smallStraight), withText("Small S"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        13),
                                0)));
        appCompatButton5.perform(scrollTo(), click());

        ViewInteraction tabView6 = onView(
                allOf(withContentDescription("Shaker"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                0),
                        isDisplayed()));
        tabView6.perform(click());

        ViewInteraction appCompatImageButton4 = onView(
                allOf(withId(R.id.shake_Button),
                        childAtPosition(
                                allOf(withId(R.id.shaker_fragment),
                                        withParent(withId(R.id.view_pager))),
                                8),
                        isDisplayed()));
        appCompatImageButton4.perform(click());
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
