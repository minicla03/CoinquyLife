package minicla03.coinquylife.Auth;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import minicla03.coinquylife.Auth.UI.AuthActivity;
import minicla03.coinquylife.Auth.UI.DashboardActivity;

public class SplashActivity extends AppCompatActivity
{
    private static final int SPLASH_DURATION = 1500; // in ms

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(() -> {
            SharedPreferences prefs = getSharedPreferences("auth_prefs", MODE_PRIVATE);
            boolean isLoggedIn = prefs.getBoolean("is_logged_in", false);

            if (isLoggedIn) {
                // Utente già loggato, vai alla dashboard
                startActivity(new Intent(SplashActivity.this, DashboardActivity.class));
            } else {
                // Utente non loggato, vai al login
                startActivity(new Intent(SplashActivity.this, AuthActivity.class));
            }

            finish(); // Chiude SplashActivity
        }, SPLASH_DURATION);
    }
}
