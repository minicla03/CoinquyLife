package minicla03.coinquylife.Auth.Repository;

import java.util.function.Consumer;

import minicla03.coinquylife.Auth.Utility.AuthResult;
import minicla03.coinquylife.PERSISTANCE.database.entity.User;

public interface IAuthRepository
{
    void login(String email, String password, Consumer<AuthResult> callback);

    void register(User user, Consumer<AuthResult> callback);

}
