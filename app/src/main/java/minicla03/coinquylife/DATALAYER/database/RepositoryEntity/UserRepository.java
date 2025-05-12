package minicla03.coinquylife.DATALAYER.database.RepositoryEntity;

import android.content.Context;

import minicla03.coinquylife.DATALAYER.database.DatabaseManager;
import minicla03.coinquylife.DATALAYER.database.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.database.entity.User;
import minicla03.coinquylife.FEATURE.Auth.DOMAIN.Repository.IAuthRepository;

public class UserRepository implements IAuthRepository
{
    private DatabaseManager db;

    public UserRepository(Context context)
    {
        db=DatabaseManager.getInstance(context);
    }

    @Override
    public User getUserByEmail(String email)
    {
       return db.userDao().getUserByEmail(email);
    }

    @Override
    public CoinquyHouse getHouseWithUsers(String id_user) {
        return db.coiquyHouseWithUserRelationshipDao().getCoinquyHouseById(id_user);
    }

    @Override
    public void insertUser(User user) {
        try {
            db.userDao().insertUser(user);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
