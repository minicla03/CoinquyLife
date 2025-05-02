package minicla03.coinquylife.Auth.Repository;

import java.util.function.Consumer;

import minicla03.coinquylife.Auth.Utility.AuthResult;
import minicla03.coinquylife.PERSISTANCE.database.entity.User;

public class RegisterUserUseCase
{
    private final AuthRepository repository;

    public RegisterUserUseCase(AuthRepository repository) {
        this.repository = repository;
    }

    public void execute(User user, Consumer<AuthResult> callback)
    {
        repository.register(user, callback);
    }
}
