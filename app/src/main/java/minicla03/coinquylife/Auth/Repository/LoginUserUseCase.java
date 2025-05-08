package minicla03.coinquylife.Auth.Repository;

import java.util.function.Consumer;

import minicla03.coinquylife.Auth.Utility.AuthResult;

public class LoginUserUseCase
{
    private final IAuthRepository repository;

    public LoginUserUseCase(IAuthRepository repository)
    {
        this.repository = repository;
    }

    public void execute(String email, String password, Consumer<AuthResult> callback)
    {
        repository.login(email, password, callback);
    }
}
