package minicla03.coinquylife.dashboard.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.CalendarView;
import android.widget.TextView;

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
    private User user;
    private CoinquyHouse coinquyHouse;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        user = getIntent().getParcelableExtra("user");
        coinquyHouse =getIntent().getParcelableExtra("coinquyHouse");

        topAppBar = findViewById(R.id.topAppBar);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        ((TextView) topAppBar.findViewById(R.id.tvHouseName)).setText(coinquyHouse.getHouse_name());
        if(user.getProfileImage() != null)
        {
            //topAppBar.setNavigationIcon(user.getProfileImage());
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
                Intent intent = new Intent(this, ProfileActivity.class);
                intent.putExtra("user", user);
                intent.putExtra("coinquyHouse", coinquyHouse);
                startActivity(intent);
                return true;
            }
            return false;
        });

        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.fragmetDashboard, new DashboardRecapFragment())
                .commit();
    }
        /*// Collega NavController
        NavHostFragment navHostFragment = (NavHostFragment)
                getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_dashboard);
        navController = navHostFragment.getNavController();

        // Se usi BottomNavigationView
        bottomNavigationView = findViewById(R.id.navigation_bottom_bar);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);


        // Configura il calendario
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            // Azione per la selezione di una data
        });*/
}