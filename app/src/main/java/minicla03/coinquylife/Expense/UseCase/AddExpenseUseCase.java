package minicla03.coinquylife.Expense.UseCase;

import minicla03.coinquylife.DATALAYER.local.entity.Purchase;

public class AddExpenseUseCase implements IAddExpenseUseCase
{
    private final IExpenseRepository repository;

    public AddExpenseUseCase(IExpenseRepository repository)
    {
        this.repository = repository;
    }

    public void execute(Purchase purchase) {
        repository.addExpense(purchase);
    }
}
