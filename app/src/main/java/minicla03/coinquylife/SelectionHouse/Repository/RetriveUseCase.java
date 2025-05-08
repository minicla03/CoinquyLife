package minicla03.coinquylife.SelectionHouse.Repository;

import minicla03.coinquylife.PERSISTANCE.database.entity.User;

public class RetriveUseCase
{
    private final ISelectHouseRepository repository;

    public RetriveUseCase(ISelectHouseRepository repo)
    {
        this.repository = repo;
    }

    public User retriveUser(String id_user)
    {
        return repository.retriveUser(id_user);
    }
}
