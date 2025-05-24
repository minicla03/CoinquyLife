package minicla03.coinquylife.Expense.UI;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;

import minicla03.coinquylife.Expense.ViewModel.ExpenseViewModel;
import minicla03.coinquylife.R;

public class ExpenseActivity extends AppCompatActivity implements OnExpenseAddedListener
{
    private ExpenseViewModel expenseViewModel;

    private TextView tvBalanceSummary;
    private RecyclerView rvExpenses;
    private Button btnAddExpense;
    private ExpenseAdapter expenseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expense_layout);

        tvBalanceSummary = findViewById(R.id.tv_balance_summary);
        rvExpenses = findViewById(R.id.rv_expenses);
        btnAddExpense = findViewById(R.id.btn_add_expense);

        expenseViewModel= new ViewModelProvider(this).get(ExpenseViewModel.class);

        btnAddExpense.setOnClickListener(v -> {
            AddExpenseBottomSheetFragment bottomSheet = new AddExpenseBottomSheetFragment();
            bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
        });

        expenseAdapter = new ExpenseAdapter();
        rvExpenses.setLayoutManager(new LinearLayoutManager(this));
        rvExpenses.setAdapter(expenseAdapter);
    }

    @Override
    public void onExpenseAdded(String amount, String description, boolean daFare, boolean saldata, Date data)
    {
        //expenseAdapter.addExpense(id_user, id_house, amount, description, daFare, saldata, data);
        //expenseViewModel.
        //tvBalanceSummary.setText("Saldo: " +expenseViewModel.getBalance().toString() + "€");
    }
}


