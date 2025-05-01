package minicla03.coinquylife.Auth.Repository;

import java.util.function.Consumer;

import minicla03.coinquylife.PERSISTANCE.database.entity.User;

public class RegisterUserUseCase
{
    private final UserRepository repository;

    public RegisterUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(User user, Consumer<Boolean> callback) {
        repository.register(user, callback);
    }
}
