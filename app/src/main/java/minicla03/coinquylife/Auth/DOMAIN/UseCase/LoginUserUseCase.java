package minicla03.coinquylife.Auth.DOMAIN.UseCase;

import java.util.concurrent.Executor;
import java.util.function.Consumer;

import minicla03.coinquylife.CoinquyLife;
import minicla03.coinquylife.DATALAYER.local.entity.CoinquyHouse;
import minicla03.coinquylife.Auth.DOMAIN.Repository.IAuthRepository;
import minicla03.coinquylife.Auth.Utility.AuthResult;
import minicla03.coinquylife.Auth.Utility.AuthStatus;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        Call<minicla03.coinquylife.DATALAYER.remote.AuthAPI.AuthResult> remoteCall =
                repository.getUserByEmailRemote(email, password);

        remoteCall.enqueue(new Callback<>()
        {
            @Override
            public void onResponse(Call<minicla03.coinquylife.DATALAYER.remote.AuthAPI.AuthResult> call,
                                   Response<minicla03.coinquylife.DATALAYER.remote.AuthAPI.AuthResult> response)
            {
                if (response.isSuccessful() && response.body() != null)
                {
                    var authResult = response.body();
                    // Se login corretto
                    if (authResult.getStatusAuth() == AuthStatus.SUCCESS)
                    {
                        String token = authResult.getToken();
                        CoinquyLife.getTokenManager().saveToken(token);

                        callback.accept(new AuthResult(AuthStatus.SUCCESS, token, null));

                        executor.execute(()->{
                            CoinquyHouse house= repository.getHouseUser(user.getHouseUser());

                            if (house != null)
                            {
                                callback.accept(new AuthResult(AuthStatus.HAS_COINQUYHOUSE, user, house));
                            }
                            else
                            {
                                callback.accept(new AuthResult(AuthStatus.NO_COINQUYHOUSE, user, null));
                            }
                        });
                    }
                    else
                    {
                        callback.accept(new AuthResult(AuthStatus.WRONG_PASSWORD, null, null));
                    }
                }
                else
                {
                    callback.accept(new AuthResult(AuthStatus.ERROR, null, null));
                }
            }

            @Override
            public void onFailure(Call<minicla03.coinquylife.DATALAYER.remote.AuthAPI.AuthResult> call, Throwable t)
            {
                t.printStackTrace();
                callback.accept(new AuthResult(AuthStatus.ERROR, null, null));
            }
        });
    }
}
