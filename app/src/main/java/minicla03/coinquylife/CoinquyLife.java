package minicla03.coinquylife;

import android.app.Application;


import minicla03.coinquylife.DATALAYER.local.DatabaseManager;
import minicla03.coinquylife.DATALAYER.remote.ApiClient;
import minicla03.coinquylife.DATALAYER.remote.AuthAPI.IAuthApi;

public class CoinquyLife extends Application
{
    private static DatabaseManager db;
    private static IAuthApi endpointsAuth;
    private static TokenManager tokenManager;

    @Override
    public void onCreate()
    {
        super.onCreate();
        db= DatabaseManager.getInstance(this);
        endpointsAuth = ApiClient.getApiAuth();
        tokenManager= TokenManager.getInstance(this);
    }

    public static DatabaseManager getDatabase()
    {
        return db;
    }

    public static IAuthApi getEndpoints()
    {
        return endpointsAuth;
    }

    public static TokenManager getTokenManager() {return tokenManager;}
}
