package minicla03.coinquylife.FEATURE.dashboard.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import minicla03.coinquylife.FEATURE.Board.UI.BoardActivity;
import minicla03.coinquylife.FEATURE.Expense.UI.ExpenseActivity;
import minicla03.coinquylife.R;
import minicla03.coinquylife.FEATURE.ProfileSetting.UI.ProfileActivity;

public class DashboardActivity extends AppCompatActivity
{
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

        imgProfile = findViewById(R.id.imgProfile);
        tvHouseName = findViewById(R.id.tvHouseName);
        btnExpenses = findViewById(R.id.btnExpenses);
        btnRank = findViewById(R.id.btnRank);
        btnBoard = findViewById(R.id.btnBoard);
        btnShifts = findViewById(R.id.btnShifts);

        String houseName = intent.getStringExtra("house_name");
        if (houseName != null) {
            tvHouseName.setText(houseName);
        }

        tvHouseName.setOnClickListener(v-> {
            Toast.makeText(DashboardActivity.this, "HouseActivity name not implemented yet", Toast.LENGTH_SHORT).show();
            //Intent intent0 = new Intent(DashboardActivity.this, ProfileActivity.class);
            //intent0.putExtra("user", user_id);
            //intent0.putExtra("coinquy", coinquy_id);
            //startActivity(intent1);
        });

        btnExpenses.setOnClickListener(v -> {
            Intent intent1 = new Intent(DashboardActivity.this, ExpenseActivity.class);
            //intent.putExtra("user", user_id);
            //intent.putExtra("coinquy", coinquy_id);
            startActivity(intent1);
        });

        btnRank.setOnClickListener(v -> {
            Toast.makeText(DashboardActivity.this, "Rank not implemented yet", Toast.LENGTH_SHORT).show();
            //Intent intent2 = new Intent(DashboardActivity.this, RankActivity.class);
            //intent2.putExtra("user", user_id);
            //intent2.putExtra("coinquy", coinquy_id);
            //startActivity(intent2);
        });

        btnBoard.setOnClickListener(v -> {
            Intent intent3 = new Intent(DashboardActivity.this, BoardActivity.class);
            //intent3.putExtra("user", user_id);
            //intent3.putExtra("coinquy", coinquy_id);
            startActivity(intent3);
        });

        btnShifts.setOnClickListener(v -> {
            Toast.makeText(DashboardActivity.this, "Shifts not implemented yet", Toast.LENGTH_SHORT).show();
            //Intent intent4 = new Intent(DashboardActivity.this, ShiftActivity.class);
            //intent4.putExtra("user", user_id);
            //intent4.putExtra("coinquy", coinquy_id);
            //startActivity(intent);
        });

        imgProfile.setOnClickListener(v -> {
            Intent intent5 = new Intent(DashboardActivity.this, ProfileActivity.class);
            //intent5.putExtra("user", user_id);
            //intent5.putExtra("coinquy", coinquy_id);
            startActivity(intent5);
        });
    }
}
