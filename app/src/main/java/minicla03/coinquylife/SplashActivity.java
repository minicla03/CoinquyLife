package minicla03.coinquylife;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity
{
    private String screenRotation;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        if (savedInstanceState != null)
        {
            screenRotation = savedInstanceState.getString("chiave", "");
        }
        // Usa un Handler per lanciare una nuova activity dopo un breve periodo (3 secondi)
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Chiudi la SplashActivity
            }
        }, 3000);  // Durata della splash screen in millisecondi (ad esempio 3000ms = 3 secondi)
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putString("chiave", screenRotation); // Salva un valore prima della rotazione
    }

}
