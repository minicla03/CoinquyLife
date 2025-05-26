package minicla03.coinquylife;

import android.app.Application;


import minicla03.coinquylife.DATALAYER.local.DatabaseManager;
import minicla03.coinquylife.DATALAYER.remote.ApiClient;

public class CoinquyLife extends Application
{
    private static DatabaseManager db;
    private static ApiClient endpoints;
    private static TokenManager tokenManager;

    @Override
    public void onCreate()
    {
        super.onCreate();
        db= DatabaseManager.getInstance(this);
        endpoints = ApiClient.getInstance();
        tokenManager= TokenManager.getInstance(this);
    }

    public static DatabaseManager getDatabase()
    {
        return db;
    }

    public static ApiClient getEndpoints()
    {
        return endpoints;
    }

    public static TokenManager getTokenManager() {return tokenManager;}
}
