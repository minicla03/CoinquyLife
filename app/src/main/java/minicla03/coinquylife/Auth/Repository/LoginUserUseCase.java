package minicla03.coinquylife.Auth.Repository;

import java.util.function.Consumer;

public class LoginUserUseCase
{
    private final AuthRepository repository;

    public LoginUserUseCase(AuthRepository repository) {
        this.repository = repository;
    }

    public void execute(String email, String password, Consumer<AuthResult> callback)
    {
        repository.login(email, password, callback);
    }
}
