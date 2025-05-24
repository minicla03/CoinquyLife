package minicla03.coinquylife;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import minicla03.coinquylife.Auth.PRESENTATION.UI.AuthActivity;
import minicla03.coinquylife.DATALAYER.local.DatabaseManager;

public class SplashActivity extends AppCompatActivity
{
    private DatabaseManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        new android.os.Handler().postDelayed(() -> {
            SharedPreferences prefs = getSharedPreferences("auth_prefs", MODE_PRIVATE);
            boolean isLoggedIn = prefs.getBoolean("is_logged_in", false);
            boolean isLoggedWithHouse = prefs.getBoolean("is_logged_with_house", false);

        /*if (isLoggedWithHouse)
        {
            startActivity(new Intent(SplashActivity.this, DashboardActivity.class));
        } else if (isLoggedIn) {
            startActivity(new Intent(SplashActivity.this, CoinquyHouseSelectionActivity.class));
        } else {*/
            startActivity(new Intent(SplashActivity.this, AuthActivity.class));
            // }

            finish();
        }, 2500); // ⏳ 2.5 secondi di ritardo (2500 ms)
    }
}
