package minicla03.coinquylife.FEATURE.Auth.DOMAIN.UseCase;

import java.util.concurrent.Executor;
import java.util.function.Consumer;

import minicla03.coinquylife.DATALAYER.database.entity.User;
import minicla03.coinquylife.FEATURE.Auth.DOMAIN.Repository.IAuthRepository;
import minicla03.coinquylife.FEATURE.Auth.Utility.AuthResult;
import minicla03.coinquylife.FEATURE.Auth.Utility.AuthStatus;

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
        executor.execute(() -> {
            try
            {
                User existingUser = repository.getUserByEmail(user.getEmail());
                if (existingUser == null)
                {
                    repository.insertUser(user);
                    callback.accept(new AuthResult(AuthStatus.SUCCESS, user, null));
                }
                else
                {
                    callback.accept(new AuthResult(AuthStatus.AlREADY_REGISTERED, null, null));
                }
            }
            catch (Exception e)
            {
                callback.accept(new AuthResult(AuthStatus.ERROR, null, null));
            }
        });
    }
}
