package minicla03.coinquylife.dashboard.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.Objects;

import minicla03.coinquylife.DATALAYER.local.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.local.entity.User;
import minicla03.coinquylife.Board.UI.BoardActivity;
import minicla03.coinquylife.Expense.UI.ExpenseActivity;
import minicla03.coinquylife.dashboard.ViewModel.DashboardViewModel;
import minicla03.coinquylife.R;
import minicla03.coinquylife.ProfileSetting.UI.ProfileActivity;

public class DashboardActivity extends AppCompatActivity
{
    private ImageView imgProfile;
    private TextView tvHouseName;
    private ImageButton btnExpenses, btnRank, btnBoard, btnShifts;
    private DashboardViewModel dashboardViewModel;

    private User user;
    private CoinquyHouse house;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Intent intent = getIntent();
        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        dashboardViewModel.putIntentData("USER", intent.getStringExtra("user"));
        dashboardViewModel.putIntentData("COINQUYHOUSE", intent.getStringExtra("coinquyhouse"));

        imgProfile = findViewById(R.id.imgProfile);
        tvHouseName = findViewById(R.id.tvHouseName);
        btnExpenses = findViewById(R.id.btnExpenses);
        btnRank = findViewById(R.id.btnRank);
        btnBoard = findViewById(R.id.btnBoard);
        btnShifts = findViewById(R.id.btnShifts);

        dashboardViewModel.getIntentData().observe(this, data -> {
            if (data != null)
            {
                String idUser = (String) data.get("USER");
                if (idUser == null)
                {
                    Toast.makeText(this, "User data is missing", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    dashboardViewModel.retriveUser(idUser);
                }

                String idHouse = (String) data.get("COINQUYHOUSE");
                if (idHouse == null)
                {
                    Toast.makeText(this, "House data is missing", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    dashboardViewModel.retriveHouse(idHouse);
                }
            }
        });

        dashboardViewModel.getRetriveUserResult().observe(this, user -> {
            this.user = user;
        });

        dashboardViewModel.getRetriveHouseResult().observe(this, house -> {
            this.house = house;
            if(house != null)
            {
                tvHouseName.setText(house.getHouse_name()+house.getId_house());
            }
        });

        tvHouseName.setOnClickListener(v-> {
            Toast.makeText(DashboardActivity.this, "HouseActivity name not implemented yet", Toast.LENGTH_SHORT).show();
            //Intent intent0 = new Intent(DashboardActivity.this, ProfileActivity.class);
            //intent0.putExtra("user", user_id);
            //intent0.putExtra("coinquy", coinquy_id);
            //startActivity(intent1);
        });

        btnExpenses.setOnClickListener(v -> {
            Intent intent1 = new Intent(DashboardActivity.this, ExpenseActivity.class);
            intent1.putExtra("user", this.user);
            intent1.putExtra("coinquyhouse", this.house);
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
            intent3.putExtra("user", this.user);
            intent3.putExtra("coinquyhouse", this.house);
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
            intent5.putExtra("user", this.user);
            intent5.putExtra("coinquyhouse", this.house);
            startActivity(intent5);
        });
    }
}
