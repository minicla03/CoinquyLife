package minicla03.coinquylife.Auth.DOMAIN.UseCase;

import java.util.concurrent.Executor;
import java.util.function.Consumer;

import minicla03.coinquylife.CoinquyLife;
import minicla03.coinquylife.Auth.DOMAIN.Repository.IAuthRepository;
import minicla03.coinquylife.DATALAYER.remote.AuthAPI.AuthResult;
import minicla03.coinquylife.DATALAYER.remote.AuthAPI.AuthStatus;
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
        Call<AuthResult> remoteCall = repository.getUserByEmailRemote(email, password);

        remoteCall.enqueue(new Callback<>()
        {
            @Override
            public void onResponse(Call<AuthResult> call, Response<AuthResult> response)
            {
                if (response.isSuccessful() && response.body() != null)
                {
                    var authResult = response.body();

                    if (authResult.getStatusAuth() == AuthStatus.SUCCESS)
                    {
                        String token = authResult.getToken();
                        CoinquyLife.getTokenManager().saveToken(token);

                        callback.accept(new AuthResult(AuthStatus.SUCCESS, token));
                    }
                    else
                    {
                        callback.accept(new AuthResult(AuthStatus.WRONG_PASSWORD, null));
                    }
                }
                else
                {
                    callback.accept(new AuthResult(AuthStatus.ERROR, null));
                }
            }

            @Override
            public void onFailure(Call<minicla03.coinquylife.DATALAYER.remote.AuthAPI.AuthResult> call, Throwable t)
            {
                t.printStackTrace();
                callback.accept(new AuthResult(AuthStatus.ERROR, null));
            }
        });
    }
}
