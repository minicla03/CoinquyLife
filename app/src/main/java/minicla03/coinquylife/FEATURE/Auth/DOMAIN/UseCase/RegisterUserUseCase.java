package minicla03.coinquylife.FEATURE.Auth.DOMAIN.UseCase;

import java.util.function.Consumer;

import minicla03.coinquylife.FEATURE.Auth.DOMAIN.Repository.IAuthRepository;
import minicla03.coinquylife.FEATURE.Auth.Utility.AuthResult;
import minicla03.coinquylife.DATALAYER.database.entity.User;

public class RegisterUserUseCase implements IRegisterUserUseCase
{
    private final IAuthRepository repository;

    public RegisterUserUseCase(IAuthRepository repository) {
        this.repository = repository;
    }

    public void execute(User user, Consumer<AuthResult> callback)
    {
        repository.register(user, callback);
    }
}
