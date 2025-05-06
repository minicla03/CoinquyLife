package minicla03.coinquylife;

import android.os.IBinder;
import android.view.WindowManager;
import androidx.test.espresso.Root;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class ToastMatcher extends TypeSafeMatcher<Root> {
    @Override
    public void describeTo(Description description) {
        description.appendText("is toast");
    }

    @Override
    public boolean matchesSafely(Root root) {
        if (root.getWindowLayoutParams().isPresent())
        {
            int type = root.getWindowLayoutParams().get().type;
            if (type == WindowManager.LayoutParams.TYPE_TOAST) {
                if (root.getDecorView() != null) {
                    IBinder windowToken = root.getDecorView().getWindowToken();
                    IBinder appToken = root.getDecorView().getApplicationWindowToken();
                    return windowToken == appToken;
                }
            }
        }
        return false;
    }
}
