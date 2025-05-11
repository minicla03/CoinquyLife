package minicla03.coinquylife.FEATURE.Expense.UseCase;

import minicla03.coinquylife.DATALAYER.database.entity.Purchase;

public interface IAddExpenseUseCase
{
    void execute(Purchase purchase);
}
