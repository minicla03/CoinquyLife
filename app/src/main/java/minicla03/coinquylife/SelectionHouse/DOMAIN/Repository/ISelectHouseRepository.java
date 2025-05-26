package minicla03.coinquylife.SelectionHouse.DOMAIN.Repository;

import minicla03.coinquylife.DATALAYER.local.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.local.entity.User;
import minicla03.coinquylife.DATALAYER.remote.HouseSelectionAPI.SelectHouseResult;
import retrofit2.Call;

public interface ISelectHouseRepository
{
    CoinquyHouse createHouse(String houseName, String address, User user);

    CoinquyHouse joinHouse(String houseCode, User user);

    User retriveUser(String idUser);

    CoinquyHouse retriveHouse(String idHouse);

    Call<SelectHouseResult> createHouseRemote(String houseName, String address, String token);
}
