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
    AuthViewModel authViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_layout);

        //modalità schermo intero
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide(); // Nasconde l'ActionBar

        authViewModel= new ViewModelProvider(this).get(AuthViewModel.class);

        if (savedInstanceState == null) {navigateToFragment(new LoginFragment());}
        else
        {
            authViewModel.setCurrentFragment(savedInstanceState.getString("current_fragment");
            if ("RegisterFragment".equals(currentFragment))
            {
                navigateToFragment(new RegisterFragment());
            }
            else
            {
                navigateToFragment(new LoginFragment());
            }
        }

        View btnLogin = findViewById(R.id.btnLogin);
        View btnRegister = findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(v -> navigateToFragment(new LoginFragment()));
        btnRegister.setOnClickListener(v -> navigateToFragment(new RegisterFragment()));
    }

    private void navigateToFragment(Fragment fragment)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.auth_fragment_container, fragment)
                .commit();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState)
    {
        super.onSaveInstanceState(outState);
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.auth_fragment_container);
        if (currentFragment != null)
        {
            authViewModel.setCurrentFragment(currentFragment.getClass().getSimpleName());
            outState.putString("current_fragment", currentFragment.getClass().getSimpleName());
        }
    }

}
