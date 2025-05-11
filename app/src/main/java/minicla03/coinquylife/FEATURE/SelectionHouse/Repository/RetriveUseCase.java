package minicla03.coinquylife.FEATURE.SelectionHouse.Repository;

import java.util.function.Consumer;

import minicla03.coinquylife.DATALAYER.database.entity.User;

public class RetriveUseCase
{
    private final ISelectHouseRepository repository;

    public RetriveUseCase(ISelectHouseRepository repo)
    {
        this.repository = repo;
    }

    public void retriveUser(String id_user, Consumer<User> callback)
    {
        repository.retriveUser(id_user, callback);
    }
}
