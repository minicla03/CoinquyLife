package minicla03.coinquylife.FEATURE.Auth.PRESENTATION.UI;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.Objects;

import minicla03.coinquylife.R;

public class AuthActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_layout);

        //modalità schermo intero
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide(); // Nasconde l'ActionBar

        TextView registerText = findViewById(R.id.textViewRegister);
        if(savedInstanceState==null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.auth_fragment_container, new LoginFragment())
                    .commit();
        }

        registerText.setOnClickListener(v -> {navigateToFragment(new RegisterFragment());});
    }

    private void navigateToFragment(Fragment fragment)
    {
        String tag = fragment.getClass().getSimpleName();
        Fragment existingFragment = getSupportFragmentManager().findFragmentByTag(tag);

        getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.auth_fragment_container, Objects.requireNonNullElse(existingFragment, fragment), tag)
                .commit();
    }
}
