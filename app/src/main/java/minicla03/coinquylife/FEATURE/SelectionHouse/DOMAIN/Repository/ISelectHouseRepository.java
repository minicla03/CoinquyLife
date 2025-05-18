package minicla03.coinquylife.FEATURE.SelectionHouse.DOMAIN.Repository;

import java.util.function.Consumer;

import minicla03.coinquylife.DATALAYER.database.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.database.entity.User;
import minicla03.coinquylife.FEATURE.SelectionHouse.Utility.SelectHouseResult;

public interface ISelectHouseRepository
{
    CoinquyHouse createHouse(String houseCode, String houseName, User user);

    CoinquyHouse joinHouse(String houseCode, User user);

    User retriveUser(String idUser);
}
