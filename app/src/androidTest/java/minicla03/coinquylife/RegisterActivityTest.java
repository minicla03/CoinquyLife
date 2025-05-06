package minicla03.coinquylife;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import minicla03.coinquylife.Auth.UI.RegisterFragment;

@RunWith(AndroidJUnit4.class)
public class RegisterActivityTest {


    @Rule
    public FragmentScenario<RegisterFragment> fragmentScenario =
            FragmentScenario.launchInContainer(RegisterFragment.class);

    @Test
    public void userCanRegister()
    {
        onView(withId(R.id.etName))
                .perform(typeText("Mario Rossi"), closeSoftKeyboard());

        onView(withId(R.id.etEmail))
                .perform(typeText("mario@example.com"), closeSoftKeyboard());

        onView(withId(R.id.btnSave)).perform(click());
    }
}
