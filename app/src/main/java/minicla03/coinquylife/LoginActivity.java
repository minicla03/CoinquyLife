package minicla03.coinquylife;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity
{
    private String screenRotation;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Collega il layout di questa activity

        if (savedInstanceState != null)
        {
            screenRotation = savedInstanceState.getString("chiave", "");
        }

        EditText usernameET=findViewById(R.id.editTextText);
        EditText passwordET=findViewById(R.id.editTextTextPassword);
        Button loginB=findViewById(R.id.button);
        Button signinB=findViewById(R.id.button2);


        loginB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Recupera i valori inseriti nelle EditText
                String username = usernameET.getText().toString().trim();
                String password = passwordET.getText().toString().trim();

                // Controlla se i campi sono vuoti
                if (username.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "Username non può essere vuoto", Toast.LENGTH_SHORT).show();
                    return; // Ferma l'esecuzione se lo username è vuoto
                }

                if (password.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "Password non può essere vuota", Toast.LENGTH_SHORT).show();
                    return; // Ferma l'esecuzione se la password è vuota
                }

                // Verifica la password (per esempio, una password hardcoded)
                if (password.equals("password123"))
                {
                    // Se la password è corretta
                    Toast.makeText(LoginActivity.this, "Accesso riuscito!", Toast.LENGTH_SHORT).show();
                } else
                {
                    // Se la password è errata
                    Toast.makeText(LoginActivity.this, "Password errata", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putString("chiave", screenRotation); // Salva un valore prima della rotazione
    }
}
