package minicla03.coinquylife.SelectionHouse.DOMAIN.Repository;

import minicla03.coinquylife.DATALAYER.local.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.local.entity.User;

public interface ISelectHouseRepository
{
    CoinquyHouse createHouse(String houseCode, String houseName, User user);

    CoinquyHouse joinHouse(String houseCode, User user);

    User retriveUser(String idUser);

    CoinquyHouse retriveHouse(String idHouse);
}
