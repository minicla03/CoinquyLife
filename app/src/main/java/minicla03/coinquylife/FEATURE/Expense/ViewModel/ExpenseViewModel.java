package minicla03.coinquylife.FEATURE.Expense.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import minicla03.coinquylife.FEATURE.Expense.UseCase.AddExpenseUseCase;
import minicla03.coinquylife.FEATURE.Expense.UseCase.ExpenseRepository;
import minicla03.coinquylife.FEATURE.Expense.UseCase.GetExpensesUseCase;
import minicla03.coinquylife.DATALAYER.database.entity.Purchase;
import minicla03.coinquylife.FEATURE.Expense.UseCase.IAddExpenseUseCase;
import minicla03.coinquylife.FEATURE.Expense.UseCase.IExpenseRepository;
import minicla03.coinquylife.FEATURE.Expense.UseCase.IGetExpensesUseCase;

public class ExpenseViewModel extends AndroidViewModel
{
    private final IAddExpenseUseCase addExpenseUseCase;
    private final IGetExpensesUseCase getExpensesUseCase;

    private final MutableLiveData<List<Purchase>> expensesLiveData = new MutableLiveData<>();
    private final MutableLiveData<Double> balanceLiveData = new MutableLiveData<>();

    public ExpenseViewModel(@NotNull Application application)
    {
        super(application);
        IExpenseRepository repository = new ExpenseRepository(application);
        addExpenseUseCase= new AddExpenseUseCase(repository);
        getExpensesUseCase = new GetExpensesUseCase(repository);
    }

    public void fetchExpenses()
    {
        /*getExpensesUseCase.execute().observeForever(expenses -> {
            expensesLiveData.setValue(null);
            updateBalance(null);
        });*/
    }

    public void addExpense() {
        addExpenseUseCase.execute(null);
        fetchExpenses();
    }

    public void updateBalance(List<Purchase> expenses)
    {
        double total = 0;
        for (Purchase expense : expenses) {
            total += Double.parseDouble(expense.getAmount().toString());
        }
        balanceLiveData.setValue(total);
    }

    public LiveData<List<Purchase>> getExpenses() {
        return expensesLiveData;
    }

    public LiveData<Double> getBalance() {
        return balanceLiveData;
    }
}
