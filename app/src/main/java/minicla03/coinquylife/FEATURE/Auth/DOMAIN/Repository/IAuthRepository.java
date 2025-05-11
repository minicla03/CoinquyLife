package minicla03.coinquylife.FEATURE.Auth.DOMAIN.Repository;

import java.util.function.Consumer;

import minicla03.coinquylife.FEATURE.Auth.Utility.AuthResult;
import minicla03.coinquylife.DATALAYER.database.entity.User;

public interface IAuthRepository
{
    void login(String email, String password, Consumer<AuthResult> callback);

    void register(User user, Consumer<AuthResult> callback);

}
