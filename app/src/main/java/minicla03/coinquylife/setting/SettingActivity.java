package minicla03.coinquylife.setting;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import minicla03.coinquylife.R;

public class SettingActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.settings_layout);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.settings_container, new SettingOptionFragment())
                .commit();

    }
}
