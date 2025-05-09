package minicla03.coinquylife;

import android.content.Intent;
import android.os.Bundle;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import minicla03.coinquylife.R;
import minicla03.coinquylife.SelectionHouse.UI.CoinquyHouseSelectionActivity;

import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

@RunWith(AndroidJUnit4.class)
public class CoinquyHouseSelectionActivityTest {

    @Before
    public void setUp() {
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void testActivityReceivesIntentWithUser_extra() {
        // Create intent with "user" extra
        Intent intent = new Intent();
        intent.putExtra("user", "test_user_id");

        // Launch activity with the intent
        try (ActivityScenario<CoinquyHouseSelectionActivity> scenario = ActivityScenario.launch(intent)) {
            scenario.onActivity(activity -> {
                // Verify that intent extras contain the user string
                Intent receivedIntent = activity.getIntent();
                Bundle extras = receivedIntent.getExtras();
                assert extras != null;
                String userId = extras.getString("user");
                assert userId != null && userId.equals("test_user_id");
            });
        }
    }

    @Test
    public void testActivityHandlesMissingUser_extra_ShowsToast() {


        Intent intent = new Intent();

        try (ActivityScenario<CoinquyHouseSelectionActivity> scenario = ActivityScenario.launch(intent)) {

            scenario.onActivity(activity -> {
                Espresso.onView(withText("User data is missing ACTIVITY"))
                        .inRoot(RootMatchers.withDecorView(CoreMatchers.not(activity.getWindow().getDecorView())))
                        .check(matches(ViewMatchers.isDisplayed()));
            });
        }
    }
}

