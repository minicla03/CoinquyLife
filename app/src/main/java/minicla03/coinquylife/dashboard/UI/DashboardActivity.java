package minicla03.coinquylife.dashboard.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.CalendarView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

import minicla03.coinquylife.PERSISTANCE.database.entity.CoinquyHouse;
import minicla03.coinquylife.PERSISTANCE.database.entity.User;
import minicla03.coinquylife.R;
import minicla03.coinquylife.setting.ProfileActivity;

public class DashboardActivity extends AppCompatActivity {

    private MaterialToolbar topAppBar;
    private BottomNavigationView bottomNavigationView;
    private RecyclerView rvBacheca;
    private CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        handleIntent(getIntent());

        topAppBar = findViewById(R.id.topAppBar);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        rvBacheca = findViewById(R.id.rvBacheca);
        calendarView = findViewById(R.id.calendarView);

        topAppBar.findViewById(R.id.tvHouseName).setText(CoiquyHouse.getName());
        if(user.getProfilePicture() != null)
        {
            topAppBar.setNavigationIcon(user.getProfilePicture());
        }
        else
        {
            topAppBar.setNavigationIcon(R.drawable.ic_profile);
        }

        topAppBar.findViewById(R.id.imgProfile).setOnClickListener(view -> {
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("user", user);
            intent.putExtra("coinquyHouse", coinquyHouse);
            startActivity(intent);
        });

        topAppBar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.menu_profile)
            {
                // Azione per il menu "Profilo"
                return true;
            }
            return false;
        });

        // Collega NavController
        NavHostFragment navHostFragment = (NavHostFragment)
                getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_dashboard);
        navController = navHostFragment.getNavController();

        // Se usi BottomNavigationView
        bottomNavigationView = findViewById(R.id.navigation_bottom_bar);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);


        // Configura il calendario
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            // Azione per la selezione di una data
        });
    }

    @Override
    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent); // Aggiorna l'Intent corrente
        handleIntent(intent); // Gestisci il nuovo Intent
    }

    private void handleIntent(Intent intent)
    {
        private void handleIntent(Intent intent)
        {
        if (intent.hasExtra("user"))
        {
            User user = intent.getParcelableExtra("user");
        }

        if (intent.hasExtra("coinquyHouse")) {
            CoinquyHouse coinquyHouse = intent.getParcelableExtra("coinquyHouse");
        }

        // Aggiungi altre verifiche per gestire intent specifici
        if (intent.getAction() != null)
        {
            switch (intent.getAction())
            {
                case "ACTION_FROM_LOGIN":
                    // Azione specifica per LoginActivity
                    break;
                case "ACTION_FROM_SELECTION":
                    // Azione specifica per JoinCoinquyHouseFragment
                    break;
                default:
                    // Azione di default
                    break;
            }
        }
    }
    }
}