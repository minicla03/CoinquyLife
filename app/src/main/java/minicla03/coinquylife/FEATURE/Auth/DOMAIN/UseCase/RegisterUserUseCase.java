package minicla03.coinquylife.FEATURE.Auth.DOMAIN.UseCase;

import java.util.function.Consumer;

import minicla03.coinquylife.FEATURE.Auth.DOMAIN.Repository.IAuthRepository;
import minicla03.coinquylife.FEATURE.Auth.Utility.AuthResult;
import minicla03.coinquylife.DATALAYER.database.entity.User;
import minicla03.coinquylife.FEATURE.Auth.Utility.AuthStatus;

public class RegisterUserUseCase implements IRegisterUserUseCase
{
    private final IAuthRepository repository;

    public RegisterUserUseCase(IAuthRepository repository) {
        this.repository = repository;
    }

    public void register(User user, Consumer<AuthResult> callback)
    {
        if (repository.getUserByEmail(user.getEmail()) == null)
        {
            repository.insertUser(user);
            callback.accept(new AuthResult(AuthStatus.SUCCESS, user, null));
        }
        else if (repository.getUserByEmail(user.getEmail()) != null)
        {
            callback.accept(new AuthResult(AuthStatus.AlREADY_REGISTERED, null, null));
        }
        else
        {
            callback.accept(new AuthResult(AuthStatus.ERROR, null, null));
        }
    }
}
