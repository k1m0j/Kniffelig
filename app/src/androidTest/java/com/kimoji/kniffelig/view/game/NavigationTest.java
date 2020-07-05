package com.kimoji.kniffelig.view.game;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.ViewAction;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.kimoji.kniffelig.R;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4ClassRunner.class)
public class NavigationTest {

    @Test
    public void testFragmentNavigation() {

        //SETUP
        ActivityScenario<GameActivity> scenario = ActivityScenario.launch(GameActivity.class);

        //NAV TO FRAGMENT -> automatisch bei uns?

        //Verify
        onView(withId(R.id.shaker_fragment)).check(matches(isDisplayed()));


        //NAV

        pressBack();

        //Verify


    }
}
