package minicla03.coinquylife.Auth.UI;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.Objects;

import minicla03.coinquylife.R;

public class CoinquyHouseSelectionActivity extends AppCompatActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coinquy_house_selection);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        View btnCreateGroup = findViewById(R.id.btnCreateGroup);
        View btnJoinGroup = findViewById(R.id.btnJoinGroup);

        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.fragmentContainerView, new NewCoinquyHouseIDFragment())
                .commit();

        btnCreateGroup.setOnClickListener(v -> navigateToFragment(new NewCoinquyHouseIDFragment()));
        btnJoinGroup.setOnClickListener(v -> navigateToFragment(new JoinCoinquyHouseFragment()));
    }

    private void navigateToFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.auth_fragment_container, fragment)
                .commit();
    }
}
