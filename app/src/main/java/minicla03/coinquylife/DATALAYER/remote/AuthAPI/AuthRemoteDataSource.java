package minicla03.coinquylife.DATALAYER.remote.AuthAPI;

import minicla03.coinquylife.CoinquyLife;
import minicla03.coinquylife.DATALAYER.local.entity.User;
import retrofit2.Call;

public class AuthRemoteDataSource
{
    private final IAuthApi apiEndpoints;

    public AuthRemoteDataSource()
    {
        this.apiEndpoints = CoinquyLife.getEndpoints().getApiAuth();
    }

    public Call<AuthResult> getUserByEmail(String email, String password)
    {
        return apiEndpoints.login(email, password);
    }

    public Call<AuthResult> register(User user)
    {
        return apiEndpoints.register(user);
    }

}