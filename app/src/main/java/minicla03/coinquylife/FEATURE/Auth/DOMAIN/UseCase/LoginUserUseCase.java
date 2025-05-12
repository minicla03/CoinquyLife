package minicla03.coinquylife.FEATURE.Auth.DOMAIN.UseCase;

import java.util.function.Consumer;

import minicla03.coinquylife.DATALAYER.database.entity.User;
import minicla03.coinquylife.FEATURE.Auth.DOMAIN.Repository.IAuthRepository;
import minicla03.coinquylife.FEATURE.Auth.Utility.AuthResult;
import minicla03.coinquylife.FEATURE.Auth.Utility.AuthStatus;

public class LoginUserUseCase implements ILoginUserUseCase
{
    private final IAuthRepository repository;

    public LoginUserUseCase(IAuthRepository repository)
    {
        this.repository = repository;
    }

    public void login(String email, String password, Consumer<AuthResult> callback)
    {
        User user = repository.getUserByEmail(email);
        if (user != null)
        {
            if (user.getPassword().equals(password))
            {
                if (repository.getHouseWithUsers(user.getId_user()) == null)
                {
                    callback.accept(new AuthResult(AuthStatus.NO_COINQUYHOUSE, user, null));
                }
                else
                {
                    callback.accept(new AuthResult(AuthStatus.SUCCESS, user, null));
                }
            }
            else
            {
                callback.accept(new AuthResult(AuthStatus.WRONG_PASSWORD, null, null));
            }
        }
        else
        {
            callback.accept(new AuthResult(AuthStatus.USER_NOT_FOUND, null, null));
        }
    }

    /*private void modifyPreference(String key, boolean value, User user)
    {
        editor.putBoolean(key, value);
        editor.putString(user.getId_user(),user.getHouseUser());
        editor.apply();
    }*/
}
