package minicla03.coinquylife.SelectionHouse.Repository;

import java.util.function.Consumer;

import minicla03.coinquylife.PERSISTANCE.database.entity.User;
import minicla03.coinquylife.SelectionHouse.Utility.SelectHouseResult;

public class NewHouseUseCase
{
    private final SelectHouseRepository repository;

    public NewHouseUseCase(SelectHouseRepository repository)
    {
        this.repository = repository;
    }

    public void execute(String houseCode, String houseName, User user, Consumer<SelectHouseResult> callback)
    {
        repository.createHouse(houseCode, houseName, user, callback);
    }
}
