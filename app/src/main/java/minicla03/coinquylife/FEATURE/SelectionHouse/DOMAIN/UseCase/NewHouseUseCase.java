package minicla03.coinquylife.FEATURE.SelectionHouse.DOMAIN.UseCase;

import java.util.concurrent.Executor;
import java.util.function.Consumer;

import minicla03.coinquylife.DATALAYER.database.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.database.entity.User;
import minicla03.coinquylife.FEATURE.SelectionHouse.DOMAIN.Repository.ISelectHouseRepository;
import minicla03.coinquylife.FEATURE.SelectionHouse.Utility.SelectHouseResult;
import minicla03.coinquylife.FEATURE.SelectionHouse.Utility.SelectHouseStatus;

public class NewHouseUseCase
{
    private final ISelectHouseRepository repository;
    private final Executor executor;

    public NewHouseUseCase(ISelectHouseRepository repository, Executor executor)
    {
        this.executor = executor;
        this.repository = repository;
    }

    public void execute(String houseCode, String houseName, User user, Consumer<SelectHouseResult> callback)
    {
        executor.execute(() ->
        {
            if (houseName == null)
            {
                callback.accept(new SelectHouseResult(SelectHouseStatus.HOUSE_NAME_EMPTY, null, user));
                return;
            }

            if(user.getHouseUser()!=null)
            {
                callback.accept(new SelectHouseResult(SelectHouseStatus.ALREADY_IN_HOUSE, null, user));
                return;
            }

            try
            {
                repository.createHouse(houseCode, houseName, user);
                callback.accept(new SelectHouseResult(SelectHouseStatus.SUCCESS, null, user));
            }
            catch (Exception e)
            {
                callback.accept(new SelectHouseResult(SelectHouseStatus.FAILURE, null, user));
            }
        });

    }
}
