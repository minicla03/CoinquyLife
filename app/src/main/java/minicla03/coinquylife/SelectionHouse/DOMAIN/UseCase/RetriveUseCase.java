package minicla03.coinquylife.SelectionHouse.DOMAIN.UseCase;

import java.util.concurrent.Executor;
import java.util.function.Consumer;

import minicla03.coinquylife.DATALAYER.local.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.local.entity.User;
import minicla03.coinquylife.SelectionHouse.DOMAIN.Repository.ISelectHouseRepository;

public class RetriveUseCase
{
    private final ISelectHouseRepository repository;
    private final Executor executor;

    public RetriveUseCase(ISelectHouseRepository repo, Executor executor)
    {
        this.executor = executor;
        this.repository = repo;
    }

    public void retriveUser(String id_user, Consumer<User> callback)
    {
        executor.execute(() ->
        {
            User user = repository.retriveUser(id_user);
            callback.accept(user);
        });
    }

    public void retriveHouse(String id_house, Consumer<CoinquyHouse> callback)
    {
        executor.execute(() ->
        {
            CoinquyHouse coinquyHouse = repository.retriveHouse(id_house);
            callback.accept(coinquyHouse);
        });
    }
}
