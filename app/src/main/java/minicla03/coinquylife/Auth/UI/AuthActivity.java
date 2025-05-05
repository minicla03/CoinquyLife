package minicla03.coinquylife.Auth.UI;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.Objects;

import minicla03.coinquylife.Auth.ViewModel.AuthViewModel;
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

        View btnLogin = findViewById(R.id.btnLogin);
        View btnRegister = findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(v -> navigateToFragment(new LoginFragment()));
        btnRegister.setOnClickListener(v -> navigateToFragment(new RegisterFragment()));

        if(savedInstanceState==null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.auth_fragment_container, new LoginFragment())
                    .commit();
        }
    }

    private void navigateToFragment(Fragment fragment)
    {
        String tag = fragment.getClass().getSimpleName();
        Fragment existingFragment = getSupportFragmentManager().findFragmentByTag(tag);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.auth_fragment_container, Objects.requireNonNullElse(existingFragment, fragment), tag)
                .commit();
    }
}
