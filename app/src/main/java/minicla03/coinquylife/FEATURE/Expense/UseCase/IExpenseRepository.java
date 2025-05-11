package minicla03.coinquylife.FEATURE.Expense.UseCase;

import java.util.List;
import java.util.function.Consumer;

import minicla03.coinquylife.DATALAYER.database.entity.Purchase;

public interface IExpenseRepository
{
    void addExpense(Purchase purchase);

    void getExpenses(String idUser, String idHouse, Consumer<List<Purchase>> callback);
}
