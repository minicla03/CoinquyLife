package minicla03.coinquylife.FEATURE.SelectionHouse.Repository;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import minicla03.coinquylife.CoinquyLife;
import minicla03.coinquylife.DATALAYER.database.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.database.DAO.CoinquyHouseDao;
import minicla03.coinquylife.DATALAYER.database.DAO.UserDao;
import minicla03.coinquylife.DATALAYER.database.DatabaseManager;
import minicla03.coinquylife.DATALAYER.database.entity.User;
import minicla03.coinquylife.FEATURE.SelectionHouse.DOMAIN.Repository.ISelectHouseRepository;
import minicla03.coinquylife.FEATURE.SelectionHouse.Utility.SelectHouseResult;
import minicla03.coinquylife.FEATURE.SelectionHouse.Utility.SelectHouseStatus;

public class SelectHouseRepository implements ISelectHouseRepository
{
    private final UserDao userDao;
    private final CoinquyHouseDao coinquyHouseDao;
    private final Executor executor = Executors.newSingleThreadExecutor();
    private static SelectHouseRepository instance;

    public SelectHouseRepository(Context context)
    {
        DatabaseManager db = CoinquyLife.getDatabase();
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
        if(user.getHouseUser()!=null)
        {
            callback.accept(new SelectHouseResult(SelectHouseStatus.ALREADY_IN_HOUSE, null, user));
            return;
        }
        if (houseName == null)
        {
            callback.accept(new SelectHouseResult(SelectHouseStatus.HOUSE_NAME_EMPTY, null, user));
            return;
        }
        CoinquyHouse newHouse = new CoinquyHouse(houseCode, houseName);
        executor.execute(() ->
        {
            coinquyHouseDao.insertCoinquyHouse(newHouse);
            userDao.updateUserHouse(houseCode, user.getId_user());
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
                callback.accept(new SelectHouseResult(SelectHouseStatus.SUCCESS, existingHouse, user));
            }
            else
            {
                callback.accept(new SelectHouseResult(SelectHouseStatus.FAILURE, null, null));
            }
        });
    }

    public void retriveUser(String id_user, Consumer<User> callback)
    {
        executor.execute(() ->
        {
            User user = userDao.getUserById(id_user);
            if (user == null)
            {
                callback.accept(null);
            }
            callback.accept(user);
        });
    }

    public void retriveHouse(String id_house, Consumer<CoinquyHouse> callback)
    {
        executor.execute(() ->
        {
            CoinquyHouse house = coinquyHouseDao.getCoinquyHouseById(id_house);
            if (house == null) {
                callback.accept(null);
            }
            callback.accept(house);
        });
    }
}
