package minicla03.coinquylife.DATALAYER.remote.AuthAPI;

import minicla03.coinquylife.DATALAYER.local.entity.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IAuthApi
{
    @POST("rest/auth/login")
    Call<AuthResult> login(String email, String password);

    @POST("rest/auth/register")
    Call<AuthResult> register(@Body User user);
}