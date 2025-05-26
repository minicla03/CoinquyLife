package minicla03.coinquylife.DATALAYER.remote.HouseSelectionAPI;

import minicla03.coinquylife.DATALAYER.local.entity.CoinquyHouse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface IHouseSelectionAPI
{
    @POST("/house/create")
    Call<SelectHouseResult> createHouse(@Header("Authorization") String auth, @Body String houseName, @Body String address);

    @POST("/house/loginHouse")
    Call<SelectHouseResult> loginHouse(@Header("Authorization") String auth, @Body CoinquyHouse house);
}
