package minicla03.coinquylife.setting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import minicla03.coinquylife.PERSISTANCE.database.entity.CoinquyHouse;
import minicla03.coinquylife.PERSISTANCE.database.entity.User;
import minicla03.coinquylife.R;

public class ProfileActivity extends AppCompatActivity
{
    private User user;
    private CoinquyHouse coiquyHouse;
    private ImageView imgProfile;
    private TextView tvName, tvRole, tvBio;
    private MaterialButton btnSettings;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);

        if (getIntent().hasExtra("user"))
        {
            user = getIntent().getParcelableExtra("user");
        }

        if (getIntent().hasExtra("coiquyHouse"))
        {
            coiquyHouse = getIntent().getParcelableExtra("coiquyHouse");
        }

        initializeUI();
        setupListeners();
    }

    private void initializeUI()
    {
        imgProfile = findViewById(R.id.imgProfile);
        tvName = findViewById(R.id.tvName);
        tvRole = findViewById(R.id.tvRole);
        tvBio = findViewById(R.id.tvBio);
        btnSettings = findViewById(R.id.btnSettings);

        // Popola l'interfaccia con i dati dell'utente
        if (user != null)
        {
            tvName.setText(user.getName());
            //tvBio.setText(user.getBio());

            if (user.getProfilePicture() != null)
            {
                imgProfile.setImageDrawable(user.getProfilePicture());
            }

            // Costruisci il testo del ruolo
            /*String roleText = user.getRole();
            if (coiquyHouse != null) {
                roleText += " - " + coiquyHouse.getName();
            }
            tvRole.setText(roleText);*/
        }
    }

    private void setupListeners()
    {
        btnSettings.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(this, btnSettings);
            popupMenu.getMenuInflater().inflate(R.menu.setting_menu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(item ->
            {
                if (item.getTitle().equals(getString(R.string.edit_profile)))
                {
                    Intent intent = new Intent(this, EditProfileActivity.class);
                    startActivity(intent);
                }
                else if (item.getTitle().equals(getString(R.string.setting)))
                {
                    Intent intent = new Intent(this, SettingActivity.class);
                    startActivity(intent);
                }
                return true;
            });
            popupMenu.show();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        // Gestisce il risultato dell'EditProfileActivity
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            user = data.getParcelableExtra("user");

            // Aggiorna l'interfaccia con i nuovi dati
            if (user != null) {
                tvName.setText(user.getName());
                tvBio.setText(user.getBio());

                if (user.getProfilePicture() != null) {
                    imgProfile.setImageDrawable(user.getProfilePicture());
                }
            }
        }
    }
}