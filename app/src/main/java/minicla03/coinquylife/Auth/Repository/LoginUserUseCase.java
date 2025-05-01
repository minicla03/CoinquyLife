package minicla03.coinquylife.Auth.Repository;

import minicla03.coinquylife.PERSISTANCE.database.entity.User;
import java.util.function.Consumer;

public class LoginUserUseCase
{
    private final UserRepository repository;

    public LoginUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(String email, String password, Consumer<User> callback)
    {
        repository.login(email, password, callback);
    }
}
