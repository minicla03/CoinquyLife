package minicla03.coinquylife.FEATURE.SelectionHouse.DOMAIN.UseCase;

import java.util.function.Consumer;

import minicla03.coinquylife.DATALAYER.database.entity.User;
import minicla03.coinquylife.FEATURE.SelectionHouse.DOMAIN.Repository.ISelectHouseRepository;
import minicla03.coinquylife.FEATURE.SelectionHouse.Utility.SelectHouseResult;

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
