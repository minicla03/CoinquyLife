package minicla03.coinquylife.SelectionHouse.Repository;

import java.util.function.Consumer;

import minicla03.coinquylife.PERSISTANCE.database.entity.CoinquyHouse;
import minicla03.coinquylife.PERSISTANCE.database.entity.User;
import minicla03.coinquylife.SelectionHouse.Utility.SelectHouseResult;

public interface ISelectHouseRepository
{
    void createHouse(String houseCode, String houseName, User user, Consumer<SelectHouseResult> callback);

    void joinHouse(String houseCode, User user, Consumer<SelectHouseResult> callback);

    void retriveUser(String idUser, Consumer<User> callback);

    void retriveHouse(String idHouse, Consumer<CoinquyHouse> callback);
}
