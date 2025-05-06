package minicla03.coinquylife.SelectionHouse.Repository;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import minicla03.coinquylife.PERSISTANCE.database.entity.CoinquyHouse;
import minicla03.coinquylife.PERSISTANCE.database.DAO.CoinquyHouseDao;
import minicla03.coinquylife.PERSISTANCE.database.DAO.UserDao;
import minicla03.coinquylife.PERSISTANCE.database.DatabaseManager;
import minicla03.coinquylife.PERSISTANCE.database.entity.User;
import minicla03.coinquylife.SelectionHouse.Utility.SelectHouseResult;
import minicla03.coinquylife.SelectionHouse.Utility.SelectHouseStatus;

public class SelectHouseRepository
{
    private final UserDao userDao;
    private final CoinquyHouseDao coinquyHouseDao;
    private final Executor executor = Executors.newSingleThreadExecutor();
    private static SelectHouseRepository instance;

    public SelectHouseRepository(Context context)
    {
        DatabaseManager db = DatabaseManager.getInstance(context);
        userDao = db.userDao();
        coinquyHouseDao=db.coinquyHouseDao();
    }

    public static synchronized SelectHouseRepository getInstance(Context context)
    {
        if (instance == null)
        {
            instance = new SelectHouseRepository(context.getApplicationContext());
        }
        return instance;
    }

    public void createHouse(String houseCode, String houseName, User user, Consumer<SelectHouseResult> callback)
    {
        CoinquyHouse newHouse = new CoinquyHouse(houseCode, houseName);
        executor.execute(() ->
        {
            coinquyHouseDao.insertCoinquyHouse(newHouse);
            user.setHouseUser(houseCode);
            userDao.updateUser(user);
            callback.accept(new SelectHouseResult(SelectHouseStatus.SUCCESS, newHouse, user));
        });

    }

    public void joinHouse(String houseCode, User user, Consumer<SelectHouseResult> callback)
    {
        executor.execute(() ->
        {
            CoinquyHouse existingHouse = coinquyHouseDao.getCoinquyHouseById(houseCode);
            if (existingHouse != null)
            {
                user.setHouseUser(houseCode);
                userDao.updateUser(user);
                callback.accept(new SelectHouseResult(SelectHouseStatus.SUCCESS, existingHouse, user));
            }
            else
            {
                callback.accept(new SelectHouseResult(SelectHouseStatus.FAILURE, null, null));
            }
        });
    }
}
