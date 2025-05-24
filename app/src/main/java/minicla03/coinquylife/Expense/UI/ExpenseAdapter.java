package minicla03.coinquylife.Expense.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import minicla03.coinquylife.DATALAYER.local.entity.Purchase;
import minicla03.coinquylife.R;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>
{
    private List<Purchase> expenseList = new ArrayList<>();

    @NonNull
    @Override
    public ExpenseViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_expense, parent, false);
        return new ExpenseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExpenseViewHolder holder, int position) {
        Purchase expense = expenseList.get(position);
        holder.tvAmount.setText(String.format("%.2f€", expense.getAmount()));
        holder.tvDescription.setText(expense.getDescr_purchase());
    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }

    public void addExpense(String id_user, String id_house, Double amount, String description, boolean daFare, boolean saldata, Date data) {
        Purchase expense = new Purchase(id_user, id_house, amount, description, data, daFare, saldata);
        expenseList.add(expense);
        notifyItemInserted(expenseList.size() - 1);
    }

    static class ExpenseViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvAmount, tvDescription;

        public ExpenseViewHolder(View itemView)
        {
            super(itemView);
            tvAmount = itemView.findViewById(R.id.tv_amount);
            tvDescription = itemView.findViewById(R.id.tv_description);
        }
    }
}
