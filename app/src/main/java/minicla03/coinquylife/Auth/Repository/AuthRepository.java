package minicla03.coinquylife.Auth.Repository;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import minicla03.coinquylife.Auth.Utility.AuthResult;
import minicla03.coinquylife.Auth.Utility.AuthStatus;
import minicla03.coinquylife.PERSISTANCE.database.DAO.CoiquyHouseWithUserRelationshipDao;
import minicla03.coinquylife.PERSISTANCE.database.DAO.UserDao;
import minicla03.coinquylife.PERSISTANCE.database.DatabaseManager;
import minicla03.coinquylife.PERSISTANCE.database.entity.User;

public class AuthRepository
{
    private final UserDao userDao;
    private final Executor executor = Executors.newSingleThreadExecutor();
    private static AuthRepository instance;
    private final CoiquyHouseWithUserRelationshipDao coiquyHouseWithUserRelationshipDao;
    private SharedPreferences prefs;

    public AuthRepository(Context context)
    {
        DatabaseManager db = DatabaseManager.getInstance(context);
        userDao = db.userDao();
        coiquyHouseWithUserRelationshipDao=db.coiquyHouseWithUserRelationshipDao();
        prefs = context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE);
    }

    public static synchronized AuthRepository getInstance(Context context)
    {
        if (instance == null)
        {
            instance = new AuthRepository(context.getApplicationContext());
        }
        return instance;
    }

    public void login(String email, String password, Consumer<AuthResult> callback)
    {
        executor.execute(() ->
        {
            User user = userDao.getUserByEmail(email);
            SharedPreferences.Editor editor= prefs.edit();
            if (user.getPassword().equals(password))
            {
                if (coiquyHouseWithUserRelationshipDao.getHouseWithUsers(user.getId_user()) == null)
                {
                    editor.putBoolean("is_logged_in", true);
                    editor.putString(user.getId_user(),user.getHouseUser());
                    editor.apply();
                    callback.accept(new AuthResult(AuthStatus.NO_COINQUYHOUSE, user));
                }
                else
                {
                    editor.putBoolean("is_logged_with_house", true);
                    editor.putString(user.getId_user(),user.getHouseUser());
                    editor.apply();
                    callback.accept(new AuthResult(AuthStatus.HAS_COINQUYHOUSE, user));
                }
            }
            else
            {
                callback.accept(new AuthResult(AuthStatus.WRONG_PASSWORD, user));
            }
        });
    }

    public void register(User user, Consumer<AuthResult> callback)
    {
        executor.execute(() ->
        {
            if (userDao.getUserByEmail(user.getEmail()) == null)
            {
                userDao.insertUser(user);
                callback.accept(new AuthResult(AuthStatus.SUCCESS, user));
            }
            else if (userDao.getUserByEmail(user.getEmail()) != null)
            {
                callback.accept(new AuthResult(AuthStatus.AlREADY_REGISTERED, null));
            }
            else
            {
                callback.accept(new AuthResult(AuthStatus.ERROR, null));
            }
        });
    }
}