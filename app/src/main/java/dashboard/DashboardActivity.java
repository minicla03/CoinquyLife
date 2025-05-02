package dashboard;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

import minicla03.coinquylife.R;

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
        User user= requireActivity().getIntent().getParcelableExtra("user");
        CoiquyHouse = requireActivity().getIntent().getParcelableExtra("coiquyHouse");

        topAppBar = findViewById(R.id.topAppBar);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        rvBacheca = findViewById(R.id.rvBacheca);
        calendarView = findViewById(R.id.calendarView);

        topAppBar.setTitle(coiquyHouse.getName());
        if(user.getProfilePicture() != null)
        {
            topAppBar.setNavigationIcon(user.getProfilePicture());
        }
        else
        {
            topAppBar.setNavigationIcon(R.drawable.ic_profile);
        }

        // Configura la barra superiore
        topAppBar.setNavigationOnClickListener(v -> {
            // Azione per l'icona di navigazione (es. aprire il profilo)
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
}