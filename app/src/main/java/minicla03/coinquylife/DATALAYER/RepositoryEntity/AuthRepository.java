package minicla03.coinquylife.DATALAYER.RepositoryEntity;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import minicla03.coinquylife.CoinquyLife;
import minicla03.coinquylife.DATALAYER.local.DatabaseManager;
import minicla03.coinquylife.DATALAYER.local.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.local.entity.User;
import minicla03.coinquylife.DATALAYER.remote.AuthAPI.AuthRemoteDataSource;
import minicla03.coinquylife.Auth.DOMAIN.Repository.IAuthRepository;
import minicla03.coinquylife.DATALAYER.remote.AuthAPI.AuthResult;
import retrofit2.Call;

public class AuthRepository implements IAuthRepository
{
    private DatabaseManager db;
    private final AuthRemoteDataSource remoteDataSource;

    public AuthRepository(Context context)
    {
        db= CoinquyLife.getDatabase();
        remoteDataSource = new AuthRemoteDataSource();
    }

    @Override
    public User getUserByEmail(String email)
    {
        try
        {
            return db.userDao().getUserByEmail(email);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Call<AuthResult> getUserByEmailRemote(String email, String password)
    {
        return remoteDataSource.getUserByEmail(email, password);
    }

    @Override
    public Call<AuthResult> registerRemote(User user)
    {
        return remoteDataSource.register(user);
    }

    @Override
    public CoinquyHouse getHouseUser(String id_house)
    {
        try
        {
            return db.coinquyHouseDao().getCoinquyHouseById(id_house);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertUser(User user) {
        try
        {
            db.userDao().insertUser(user);
        }
        catch (SQLiteConstraintException sqlce)
        {
            throw new RuntimeException("User already exists: " + sqlce.getMessage());
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
