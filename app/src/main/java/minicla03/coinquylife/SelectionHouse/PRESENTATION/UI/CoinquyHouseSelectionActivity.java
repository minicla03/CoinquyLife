package minicla03.coinquylife.SelectionHouse.PRESENTATION.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.Objects;

import minicla03.coinquylife.SelectionHouse.PRESENTATION.ViewModel.SelectHouseViewModel;
import minicla03.coinquylife.R;

public class CoinquyHouseSelectionActivity extends AppCompatActivity
{
    private SelectHouseViewModel selectHouseViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actiivity_coinquyhouse_selection);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Intent intent = getIntent();
        selectHouseViewModel = new ViewModelProvider(this).get(SelectHouseViewModel.class);
        //selectHouseViewModel.putIntentData("USER_TOKEN", intent.getStringExtra("user_token"));

        View btnCreateGroup = findViewById(R.id.btnCreateGroup);
        View btnJoinGroup = findViewById(R.id.btnJoinGroup);

        btnCreateGroup.setOnClickListener(v -> {navigateToFragment(new NewCoinquyHouseIDFragment());});
        btnJoinGroup.setOnClickListener(v -> {navigateToFragment(new JoinCoinquyHouseFragment());});

        if (savedInstanceState == null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.new_coinquy_house_fragment_container, new NewCoinquyHouseIDFragment())
                    .commit();
        }
    }

    private void navigateToFragment(Fragment fragment)
    {
        String tag = fragment.getClass().getSimpleName();
        Fragment existingFragment = getSupportFragmentManager().findFragmentByTag(tag);

        getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.new_coinquy_house_fragment_container, Objects.requireNonNullElse(existingFragment, fragment), tag)
                .commit();
    }
}