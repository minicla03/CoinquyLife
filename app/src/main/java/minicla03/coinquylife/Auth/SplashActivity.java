package minicla03.coinquylife.Auth;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import minicla03.coinquylife.Auth.UI.AuthActivity;
import minicla03.coinquylife.R;
import minicla03.coinquylife.SelectionHouse.UI.CoinquyHouseSelectionActivity;
import minicla03.coinquylife.dashboard.UI.DashboardActivity;

public class SplashActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);

        new Thread(() -> {
            SharedPreferences prefs = getSharedPreferences("auth_prefs", MODE_PRIVATE);
            boolean isLoggedIn = prefs.getBoolean("is_logged_in", false);
            boolean isLoggedWithHouse = prefs.getBoolean("is_logged_with_house", false);

            if (isLoggedWithHouse)
            {
                startActivity(new Intent(SplashActivity.this, DashboardActivity.class));
            } else if (isLoggedIn) {
                startActivity(new Intent(SplashActivity.this, CoinquyHouseSelectionActivity.class));
            } else {
                startActivity(new Intent(SplashActivity.this, AuthActivity.class));
            }

            finish();
        }).start();
    }
}
