package minicla03.coinquylife.FEATURE.SelectionHouse.Repository;

import java.util.function.Consumer;

import minicla03.coinquylife.DATALAYER.database.entity.User;
import minicla03.coinquylife.FEATURE.SelectionHouse.Utility.SelectHouseResult;

public class NewHouseUseCase
{
    private final ISelectHouseRepository repository;

    public NewHouseUseCase(ISelectHouseRepository repository)
    {
        this.repository = repository;
    }

    public void execute(String houseCode, String houseName, User user, Consumer<SelectHouseResult> callback)
    {
        repository.createHouse(houseCode, houseName, user, callback);
    }
}
