package minicla03.coinquylife.FEATURE.Auth.DOMAIN.UseCase;

import java.util.concurrent.Executor;
import java.util.function.Consumer;

import minicla03.coinquylife.DATALAYER.database.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.database.entity.User;
import minicla03.coinquylife.FEATURE.Auth.DOMAIN.Repository.IAuthRepository;
import minicla03.coinquylife.FEATURE.Auth.Utility.AuthResult;
import minicla03.coinquylife.FEATURE.Auth.Utility.AuthStatus;

public class LoginUserUseCase implements ILoginUserUseCase
{
    private final IAuthRepository repository;
    private final Executor executor;

    public LoginUserUseCase(IAuthRepository repository, Executor executor)
    {
        this.repository = repository;
        this.executor = executor;
    }

    @Override
    public void login(String email, String password, Consumer<AuthResult> callback)
    {
        executor.execute(() -> {

            try
            {
                User user = repository.getUserByEmail(email);
                if (user != null)
                {
                    if (user.getPassword().equals(password))
                    {
                        CoinquyHouse coinquyHouse=repository.getHouseUser(user.getHouseUser());
                        if (coinquyHouse!=null)
                        {
                            callback.accept(new AuthResult(AuthStatus.HAS_COINQUYHOUSE, user, coinquyHouse));
                        }
                        else
                        {
                            callback.accept(new AuthResult(AuthStatus.NO_COINQUYHOUSE, user, null));
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
            catch (Exception e)
            {
                e.printStackTrace();
                callback.accept(new AuthResult(AuthStatus.ERROR, null, null));
            }
        });
    }
}
