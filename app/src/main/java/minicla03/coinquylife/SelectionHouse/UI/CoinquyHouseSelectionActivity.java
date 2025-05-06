package minicla03.coinquylife.SelectionHouse.UI;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.Objects;

import minicla03.coinquylife.PERSISTANCE.database.entity.User;
import minicla03.coinquylife.R;

public class CoinquyHouseSelectionActivity extends AppCompatActivity
{
    private Bundle extrasFromPreviousActivity;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coinquy_house_selection);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null)
        {
            User user = intent.getParcelableExtra("user");
            if (user == null)
            {
                Toast.makeText(this, "User data is missing ACTIVITY", Toast.LENGTH_SHORT).show();
            }
            Bundle extrasFromPreviousActivity = new Bundle();
            extrasFromPreviousActivity.putParcelable("user", user);
        } else {
            extrasFromPreviousActivity = new Bundle();
        }

        View btnCreateGroup = findViewById(R.id.btnCreateGroup);
        View btnJoinGroup = findViewById(R.id.btnJoinGroup);

        btnCreateGroup.setOnClickListener(v -> {
            NewCoinquyHouseIDFragment fragment = new NewCoinquyHouseIDFragment();
            navigateToFragment(fragment);
        });

        btnJoinGroup.setOnClickListener(v -> {
            JoinCoinquyHouseFragment fragment = new JoinCoinquyHouseFragment();
            navigateToFragment(fragment);
        });

        if (savedInstanceState == null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.new_coinquy_house_fragment_container, new NewCoinquyHouseIDFragment())
                    .commit();
        }
    }

    private void navigateToFragment(Fragment fragment)
    {
        fragment.setArguments(extrasFromPreviousActivity);
        String tag = fragment.getClass().getSimpleName();
        Fragment existingFragment = getSupportFragmentManager().findFragmentByTag(tag);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.new_coinquy_house_fragment_container, Objects.requireNonNullElse(existingFragment, fragment), tag)
                .commit();
    }
}