package minicla03.coinquylife.Expense.UseCase;

import java.util.List;
import java.util.function.Consumer;
import minicla03.coinquylife.DATALAYER.local.entity.Purchase;

public interface IGetExpensesUseCase {
    void execute(String id_user, String id_house, Consumer<List<Purchase>> callback);
}
