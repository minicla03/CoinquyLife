package minicla03.coinquylife.dashboard.UI;

import android.content.Intent;
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

import minicla03.coinquylife.R;
import minicla03.coinquylife.setting.ProfileActivity;

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

        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null)
        {
            String user_id = intent.getStringExtra("user");
            if (user_id == null)
            {
                Toast.makeText(this, "User data is missing ACTIVITY", Toast.LENGTH_SHORT).show();
            }
            String coinquy_id = intent.getStringExtra("coinquy");
            if (coinquy_id == null)
            {
                Toast.makeText(this, "Coinquy data is missing ACTIVITY", Toast.LENGTH_SHORT).show();
            }
        }

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
            public void onClick(View v)
            {
                Intent intent = new Intent(DashboardActivity.this, ProfileActivity.class);
                //intent.putExtra("user", user_id);
                //intent.putExtra("coinquy", coinquy_id);
                startActivity(intent);
            }
        });
    }
}
