package minicla03.coinquylife.FEATURE.Expense.UseCase;

import java.util.List;
import java.util.function.Consumer;

import minicla03.coinquylife.DATALAYER.database.entity.Purchase;

public class GetExpensesUseCase implements IGetExpensesUseCase {
    private final IExpenseRepository repository;

    public GetExpensesUseCase(IExpenseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(String id_user, String id_house, Consumer<List<Purchase>> callback) {
        repository.getExpenses(id_user, id_house, callback);
    }
}
