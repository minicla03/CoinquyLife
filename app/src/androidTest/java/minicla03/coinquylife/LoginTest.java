package minicla03.coinquylife;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import androidx.test.espresso.intent.Intents;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import minicla03.coinquylife.Auth.UI.AuthActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;

@RunWith(AndroidJUnit4.class)
public class LoginTest {


    @Before
    public void setUp() {
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void testLoginSuccess() {
        onView(withId(R.id.etUsername)).perform(typeText("utenteDemo"), closeSoftKeyboard());
        onView(withId(R.id.etPassword)).perform(typeText("password123"), closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).perform(click());
        intended(hasComponent("minicla03.coinquylife.SelectionHouse.UI.CoinquyHouseSelectionActivity"));
    }

    @Test
    public void testLoginFailure_ShowsToast() {
        onView(withId(R.id.etUsername)).perform(typeText("utenteSbagliato"), closeSoftKeyboard());
        onView(withId(R.id.etPassword)).perform(typeText("wrongPass"), closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withText("Login Fallito"))
                .inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }

    @Test
    public void testLoginWithEmptyFields_ShowsToast() {
        onView(withId(R.id.etUsername)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.etPassword)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withText("Inserisci username e password"))
                .inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }

    @Test
    public void testLoginWithShortPassword_ShowsToast() {
        onView(withId(R.id.etUsername)).perform(typeText("utenteDemo"), closeSoftKeyboard());
        onView(withId(R.id.etPassword)).perform(typeText("123"), closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withText("Password troppo corta"))
                .inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }

    @Test
    public void testLoginWithNonExistentUser_ShowsToast() {
        onView(withId(R.id.etUsername)).perform(typeText("nessuno"), closeSoftKeyboard());
        onView(withId(R.id.etPassword)).perform(typeText("password123"), closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withText("Utente non trovato"))
                .inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }
}
