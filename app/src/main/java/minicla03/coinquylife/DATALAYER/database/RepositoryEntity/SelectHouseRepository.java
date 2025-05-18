package minicla03.coinquylife.DATALAYER.database.RepositoryEntity;

import android.content.Context;

import java.util.function.Consumer;

import minicla03.coinquylife.DATALAYER.database.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.database.DatabaseManager;
import minicla03.coinquylife.DATALAYER.database.entity.User;
import minicla03.coinquylife.FEATURE.SelectionHouse.DOMAIN.Repository.ISelectHouseRepository;
import minicla03.coinquylife.FEATURE.SelectionHouse.Utility.SelectHouseResult;
import minicla03.coinquylife.FEATURE.SelectionHouse.Utility.SelectHouseStatus;

public class SelectHouseRepository implements ISelectHouseRepository
{
    private final DatabaseManager db;

    public SelectHouseRepository(Context context)
    {
        db=DatabaseManager.getInstance(context);
    }

    public CoinquyHouse createHouse(String houseCode, String houseName, User user)
    {
        CoinquyHouse newHouse = new CoinquyHouse(houseCode, houseName);
        try
        {
            db.coinquyHouseDao().insertCoinquyHouse(newHouse);
            db.userDao().updateUserHouse(houseCode, user.getId_user());
            return newHouse;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public CoinquyHouse joinHouse(String houseCode, User user)
    {
        try
        {
            return db.coinquyHouseDao().getCoinquyHouseById(houseCode);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public User retriveUser(String id_user)
    {
        try
        {
            return db.userDao().getUserById(id_user);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public CoinquyHouse retriveHouse(String id_house)
    {
        try
        {
            return db.coinquyHouseDao().getCoinquyHouseById(id_house);
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
