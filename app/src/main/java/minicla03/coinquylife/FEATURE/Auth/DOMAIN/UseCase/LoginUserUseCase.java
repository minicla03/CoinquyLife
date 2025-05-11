package minicla03.coinquylife.FEATURE.Auth.DOMAIN.UseCase;

import java.util.function.Consumer;

import minicla03.coinquylife.DATALAYER.database.entity.User;
import minicla03.coinquylife.FEATURE.Auth.DOMAIN.Repository.IAuthRepository;
import minicla03.coinquylife.FEATURE.Auth.Utility.AuthResult;

public class LoginUserUseCase implements ILoginUserUseCase
{
    private final IAuthRepository repository;

    public LoginUserUseCase(IAuthRepository repository)
    {
        this.repository = repository;
    }

    public User execute(String email, String password, Consumer<AuthResult> callback)
    {
        repository.login(email, password, callback);
        return null;
    }
}
