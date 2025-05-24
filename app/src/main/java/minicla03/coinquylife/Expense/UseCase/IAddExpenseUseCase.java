package minicla03.coinquylife.Expense.UseCase;

import minicla03.coinquylife.DATALAYER.local.entity.Purchase;

public interface IAddExpenseUseCase
{
    void execute(Purchase purchase);
}
