package minicla03.coinquylife.DATALAYER.RepositoryEntity;

import android.content.Context;

import minicla03.coinquylife.CoinquyLife;
import minicla03.coinquylife.DATALAYER.local.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.local.DatabaseManager;
import minicla03.coinquylife.DATALAYER.local.entity.User;
import minicla03.coinquylife.DATALAYER.remote.HouseSelectionAPI.HouseSelectionRemoteDataSource;
import minicla03.coinquylife.DATALAYER.remote.HouseSelectionAPI.SelectHouseResult;
import minicla03.coinquylife.SelectionHouse.DOMAIN.Repository.ISelectHouseRepository;
import retrofit2.Call;

public class HouseSelectionRepository implements ISelectHouseRepository
{
    private final DatabaseManager db;
    private final HouseSelectionRemoteDataSource remoteDataSource;

    public HouseSelectionRepository(Context context)
    {
        db= CoinquyLife.getDatabase();
        remoteDataSource = new HouseSelectionRemoteDataSource();
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

    public Call<SelectHouseResult> createHouseRemote(String houseName, String address, String token)
    {
        return remoteDataSource.createHouse(houseName, address, token);
    }

    public Call<SelectHouseResult> joinHouseRemote(String houseCode, String houseName, User user)
    {
        return remoteDataSource.joinHouse(houseCode, houseName, user);
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
