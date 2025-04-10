package minicla03.coinquylife.Auth;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.Objects;

import minicla03.coinquylife.R;

public class AuthActivity extends AppCompatActivity
{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState)
    {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.auth_layout);

        // Impostiamo la modalità schermo intero
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide(); // Nascondiamo l'ActionBar

        View btnLogin = findViewById(R.id.btnLogin);
        View btnRegister = findViewById(R.id.btnRegister);

        // Mostra il fragment di Login inizialmente
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.auth_fragment_container, new LoginFragment())
                .commit();

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
}
