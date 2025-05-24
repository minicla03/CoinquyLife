package minicla03.coinquylife.Expense.UI;

import java.util.Date;

public interface OnExpenseAddedListener
{
    void onExpenseAdded(String amount, String description, boolean daFare, boolean saldata, Date data);
}
