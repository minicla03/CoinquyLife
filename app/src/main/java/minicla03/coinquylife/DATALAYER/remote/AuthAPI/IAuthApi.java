package minicla03.coinquylife.DATALAYER.remote.AuthAPI;

import minicla03.coinquylife.DATALAYER.local.entity.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IAuthApi
{
    @POST("auth/login")
    Call<AuthResult> login(String email, String password);

    @POST("auth/register")
    Call<AuthResult> register(@Body User user);
}