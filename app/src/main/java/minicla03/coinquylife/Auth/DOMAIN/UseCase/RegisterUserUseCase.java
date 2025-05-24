package minicla03.coinquylife.Auth.DOMAIN.UseCase;

import java.util.concurrent.Executor;
import java.util.function.Consumer;

import minicla03.coinquylife.DATALAYER.local.entity.User;
import minicla03.coinquylife.Auth.DOMAIN.Repository.IAuthRepository;
import minicla03.coinquylife.Auth.Utility.AuthResult;
import minicla03.coinquylife.Auth.Utility.AuthStatus;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterUserUseCase implements IRegisterUserUseCase
{
    private final IAuthRepository repository;
    private final Executor executor;

    public RegisterUserUseCase(IAuthRepository repository, Executor executor)
    {
        this.repository = repository;
        this.executor = executor;
    }

    @Override
    public void register(User user, Consumer<AuthResult> callback)
    {
        Call<minicla03.coinquylife.DATALAYER.remote.AuthAPI.AuthResult> remoteCall =
                repository.registerRemote(user);

        remoteCall.enqueue(new Callback<>()
        {
            @Override
            public void onResponse(Call<minicla03.coinquylife.DATALAYER.remote.AuthAPI.AuthResult> call,
                                   Response<minicla03.coinquylife.DATALAYER.remote.AuthAPI.AuthResult> response) {
                if (response.isSuccessful())
                {
                    // Se la registrazione è andata a buon fine nel backend, salviamo localmente
                    executor.execute(() ->
                    {
                        try
                        {
                            repository.insertUser(user);
                            callback.accept(new AuthResult(AuthStatus.SUCCESS, user, null));
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                            callback.accept(new AuthResult(AuthStatus.ERROR, null, null));
                        }
                    });
                }
                else if (response.code() == 409)
                {
                    callback.accept(new AuthResult(AuthStatus.USER_ALREADY_EXISTS, null, null));
                }
                else if (response.code() == 401)
                {
                    callback.accept(new AuthResult(AuthStatus.INVALID_EMAIL, null, null));
                }
                else
                {
                    callback.accept(new AuthResult(AuthStatus.ERROR, null, null));
                }
            }

            @Override
            public void onFailure(Call<minicla03.coinquylife.DATALAYER.remote.AuthAPI.AuthResult> call, Throwable t)
            {
                //t.printStackTrace();
                callback.accept(new AuthResult(AuthStatus.ERROR, null, null));
            }
        });
    }
}
