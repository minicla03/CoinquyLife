package minicla03.coinquylife;

import android.app.Application;


import minicla03.coinquylife.DATALAYER.database.DatabaseManager;

public class CoinquyLife extends Application
{
    private static DatabaseManager db;

    @Override
    public void onCreate()
    {
        super.onCreate();
        db= DatabaseManager.getInstance(this);
    }

    public static DatabaseManager getDatabase()
    {
        return db;
    }
}
