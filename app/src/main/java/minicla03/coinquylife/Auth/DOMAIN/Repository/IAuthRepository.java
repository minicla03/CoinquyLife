package minicla03.coinquylife.Auth.DOMAIN.Repository;

import minicla03.coinquylife.DATALAYER.local.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.local.entity.User;
import minicla03.coinquylife.DATALAYER.remote.AuthAPI.AuthResult;
import retrofit2.Call;

public interface IAuthRepository
{
    User getUserByEmail(String email);

    Call<AuthResult> getUserByEmailRemote(String email, String password);

    Call<AuthResult> registerRemote(User user);

    CoinquyHouse getHouseUser(String id_house);

    void insertUser(User user);

}
