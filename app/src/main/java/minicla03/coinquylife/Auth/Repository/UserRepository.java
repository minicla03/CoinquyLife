package minicla03.coinquylife.Auth.Repository;

import android.content.Context;
import androidx.room.Room;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import minicla03.coinquylife.PERSISTANCE.database.DAO.UserDao;
import minicla03.coinquylife.PERSISTANCE.database.DatabaseManager;
import minicla03.coinquylife.PERSISTANCE.database.entity.User;

public class UserRepository
{
    private final UserDao userDao;
    private final Executor executor = Executors.newSingleThreadExecutor();
    private static UserRepository instance;

    public UserRepository(Context context)
    {
        DatabaseManager db = DatabaseManager.getInstance(context);
        userDao = db.userDao();
    }

    public static synchronized UserRepository getInstance(Context context)
    {
        if (instance == null)
        {
            instance = new UserRepository(context.getApplicationContext());
        }
        return instance;
    }

    public void login(String email, String password, Consumer<User> callback)
    {
        executor.execute(() ->
        {
            User user = userDao.getUserByEmail(email);
            if (user != null && user.getPassword().equals(password))
            {
                callback.accept(user);
            }
            else
            {
                callback.accept(null);
            }
        });
    }

    public void register(User user, Consumer<Boolean> callback)
    {
        executor.execute(() ->
        {
            if (userDao.getUserByEmail(user.getEmail()) == null)
            {
                userDao.insertUser(user);
                callback.accept(true);
            }
            else
            {
                callback.accept(false);
            }
        });
    }
}