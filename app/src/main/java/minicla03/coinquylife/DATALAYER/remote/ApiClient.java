package minicla03.coinquylife.DATALAYER.remote;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import minicla03.coinquylife.DATALAYER.remote.AuthAPI.IAuthApi;
import minicla03.coinquylife.DATALAYER.remote.HouseSelectionAPI.IHouseSelectionAPI;
import minicla03.coinquylife.TokenManager;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient
{
    private static ApiClient instance;
    private Retrofit retrofit;

    private ApiClient() { }

    public static synchronized ApiClient getInstance()
    {
        if (instance == null) {
            instance = new ApiClient();
        }
        return instance;
    }

    private OkHttpClient getClientWithAuth(Context context)
    {
        return new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    String token = TokenManager.getInstance(context).getToken();

                    Request request = chain.request().newBuilder()
                            .header("Authorization", token != null ? "Bearer " + token : "")
                            .build();
                    return chain.proceed(request);
                })
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .build();
    }

    private Retrofit getRetrofit(Context context)
    {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://localhost:8080/")
                    .client(getClientWithAuth(context))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public IAuthApi getApiAuth(Context context)
    {
        return getRetrofit(context).create(IAuthApi.class);
    }

    public IHouseSelectionAPI getApiHouseSelection(Context context)
    {
        return getRetrofit(context).create(IHouseSelectionAPI.class);
    }

    public void clearInstance()
    {
        retrofit = null;
    }
}

