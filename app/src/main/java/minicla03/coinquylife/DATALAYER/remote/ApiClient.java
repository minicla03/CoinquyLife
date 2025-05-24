package minicla03.coinquylife.DATALAYER.remote;

import minicla03.coinquylife.DATALAYER.remote.AuthAPI.IAuthApi;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient
{
    private static final String AUTH_URL = "http://localhost:8080/";
    private static Retrofit retrofit = null;

    public static IAuthApi getApiAuth()
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(AUTH_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient())
                    .build();
        }
        return retrofit.create(IAuthApi.class);
    }
}