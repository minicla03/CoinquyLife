package minicla03.coinquylife.DATALAYER.remote.HouseSelectionAPI;

import minicla03.coinquylife.CoinquyLife;
import minicla03.coinquylife.DATALAYER.local.entity.User;
import minicla03.coinquylife.DATALAYER.remote.AuthAPI.AuthResult;
import retrofit2.Call;

public class HouseSelectionRemoteDataSource
{
    private final IHouseSelectionAPI apiEndpoints;

    public HouseSelectionRemoteDataSource()
    {
        this.apiEndpoints = CoinquyLife.getEndpoints().getApiHouseSelection();
    }

    public Call<SelectHouseResult> createHouse(String houseName, String address, String token)
    {
        return apiEndpoints.createHouse(token, houseName, address);
    }

    public Call<SelectHouseResult> joinHouse(String houseCode, String houseName, User user)
    {
        //return apiEndpoints.joinHouse(user.getToken(), new CoinquyHouse(houseCode, houseName));
    }
}