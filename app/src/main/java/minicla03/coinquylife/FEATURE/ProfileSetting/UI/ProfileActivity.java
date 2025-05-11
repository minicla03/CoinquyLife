package minicla03.coinquylife.FEATURE.ProfileSetting.UI;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import minicla03.coinquylife.DATALAYER.database.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.database.entity.User;
import minicla03.coinquylife.R;

public class ProfileActivity extends AppCompatActivity
{
    private User user;
    private CoinquyHouse coiquyHouse;
    private ImageView imgProfile;
    private TextView tvName, tvRole;
    private EditText etBio;
    private MaterialButton btnSettings;

    private static final int REQUEST_GALLERY = 1;
    private static final int REQUEST_CAMERA = 2;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
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
        etBio = findViewById(R.id.etBio);
        btnSettings = findViewById(R.id.btnSettings);

        // Popola l'interfaccia con i dati dell'utente
        if (user != null)
        {
            tvName.setText(user.getName());
            //tvBio.setText(user.getBio());

            if (user.getProfileImage() != null)
            {
                //imgProfile.setImageDrawable(Converters.toDrawable(user.getProfileImage()));
            }

            // Costruisci il testo del ruolo
            /*String roleText = user.getRole();
            if (coiquyHouse != null) {
                roleText += " - " + coiquyHouse.getName();
            }
            tvRole.setText(roleText);*/
        }


    }

    private void showBioEditDialog() {
        EditText input = new EditText(this);
        input.setText(etBio.getText().toString());

        new AlertDialog.Builder(this)
                .setTitle("Modifica Bio")
                .setView(input)
                .setPositiveButton("Salva", (dialog, which) -> {
                    etBio.setText(input.getText().toString());
                })
                .setNegativeButton("Annulla", null)
                .show();
    }

    private void showImagePickerDialog()
    {
        String[] options = {"Galleria", "Fotocamera"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scegli immagine profilo")
                .setItems(options, (dialog, which) -> {
                    if (which == 0) {
                        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(galleryIntent, REQUEST_GALLERY);
                    } else {
                        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(cameraIntent, REQUEST_CAMERA);
                    }
                }).show();
    }

    private void setupListeners()
    {
        btnSettings.setOnClickListener(v -> {
                Intent intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
        });

        imgProfile.setOnClickListener(v -> {
            showImagePickerDialog();
        });

        etBio.setOnClickListener(v->{
            showBioEditDialog();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK || data == null)
            return;

        // 2. Risultato da selezione galleria
        if (requestCode == REQUEST_GALLERY) {
            Uri selectedImage = data.getData();
            if (selectedImage != null) {
                imgProfile.setImageURI(selectedImage);

                // salva l'immagine nell'oggetto utente, se necessario
                if (user != null) {
                    user.setProfilePictureUri(selectedImage.toString());
                }
            }
        }

        // 3. Risultato da fotocamera
        else if (requestCode == REQUEST_CAMERA) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            if (photo != null) {
                imgProfile.setImageBitmap(photo);

                // salva immagine se necessario
                if (user != null) {
                    // devi prima salvare l'immagine su file e poi ottenere l'URI
                    Uri photoUri = saveBitmapToFile(photo);
                    user.setProfilePictureUri(photoUri.toString());
                }
            }
        }
    }

}