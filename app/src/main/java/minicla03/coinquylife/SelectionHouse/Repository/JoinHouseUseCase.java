package minicla03.coinquylife.SelectionHouse.Repository;

import java.util.function.Consumer;

import minicla03.coinquylife.PERSISTANCE.database.entity.User;
import minicla03.coinquylife.SelectionHouse.Utility.SelectHouseResult;

public class JoinHouseUseCase
{
    private final ISelectHouseRepository repository;

    public JoinHouseUseCase(ISelectHouseRepository repo)
    {
        this.repository = repo;
    }

    public void execute(String houseCode, User user, Consumer<SelectHouseResult> callback)
    {
        repository.joinHouse(houseCode, user, callback);
    }
}
