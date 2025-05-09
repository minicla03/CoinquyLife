package minicla03.coinquylife.dashboard.UI;

import static android.os.Build.VERSION_CODES.R;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.Objects;

public class DashboardActivity extends AppCompatActivity
{
    private MaterialToolbar toolbar;
    private ImageView imgProfile;
    private TextView tvHouseName;
    private ImageButton btnExpenses, btnRank, btnBoard, btnShifts;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        toolbar = findViewById(R.id.topAppBar);
        imgProfile = findViewById(R.id.imgProfile);
        tvHouseName = findViewById(R.id.tvHouseName);
        btnExpenses = findViewById(R.id.btnExpenses);
        btnRank = findViewById(R.id.btnRank);
        btnBoard = findViewById(R.id.btnBoard);
        btnShifts = findViewById(R.id.btnShifts);

        btnExpenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Vai a Spese", Toast.LENGTH_SHORT).show();
                // startActivity(new Intent(MainActivity.this, ExpensesActivity.class));
            }
        });

        btnRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Vai a Classifica", Toast.LENGTH_SHORT).show();
            }
        });

        btnBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Vai alla Bacheca", Toast.LENGTH_SHORT).show();
            }
        });

        btnShifts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Vai ai Turni", Toast.LENGTH_SHORT).show();
            }
        });

        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Profilo utente", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
