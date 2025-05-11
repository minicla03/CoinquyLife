package minicla03.coinquylife.FEATURE.Expense.UseCase;

import android.app.Application;
import android.content.Context;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import minicla03.coinquylife.CoinquyLife;
import minicla03.coinquylife.DATALAYER.database.DAO.PurchaseDao;
import minicla03.coinquylife.DATALAYER.database.DAO.PurchaseDao_Impl;
import minicla03.coinquylife.DATALAYER.database.DatabaseManager;
import minicla03.coinquylife.DATALAYER.database.entity.Purchase;

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
