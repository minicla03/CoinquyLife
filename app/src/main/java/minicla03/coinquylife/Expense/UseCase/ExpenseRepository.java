package minicla03.coinquylife.Expense.UseCase;

import android.app.Application;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import minicla03.coinquylife.CoinquyLife;
import minicla03.coinquylife.DATALAYER.local.DAO.PurchaseDao;
import minicla03.coinquylife.DATALAYER.local.DatabaseManager;
import minicla03.coinquylife.DATALAYER.local.entity.Purchase;

public class ExpenseRepository implements IExpenseRepository
{
    private final Executor executor = Executors.newSingleThreadExecutor();
    private PurchaseDao purchaseDao;

    public ExpenseRepository(@NotNull Application application)
    {
        DatabaseManager db = CoinquyLife.getDatabase();
        purchaseDao=db.purchaseDao();
    }


    @Override
    public void addExpense(Purchase purchase)
    {
        executor.execute(() -> {
            purchaseDao.insertPurchase(purchase);
        });
    }

    @Override
    public void getExpenses(String idUser, String idHouse, Consumer<List<Purchase>> callback)
    {

    }
}
