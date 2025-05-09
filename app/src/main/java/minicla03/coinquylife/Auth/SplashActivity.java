package minicla03.coinquylife.Auth;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import minicla03.coinquylife.Auth.UI.AuthActivity;
import minicla03.coinquylife.PERSISTANCE.database.DatabaseManager;
import minicla03.coinquylife.R;
import minicla03.coinquylife.SelectionHouse.UI.CoinquyHouseSelectionActivity;
import minicla03.coinquylife.dashboard.UI.DashboardActivity;

public class SplashActivity extends AppCompatActivity
{
    private DatabaseManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);



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
