package minicla03.coinquylife.FEATURE.Auth.DOMAIN.UseCase;

import java.util.function.Consumer;

import minicla03.coinquylife.DATALAYER.database.entity.User;
import minicla03.coinquylife.FEATURE.Auth.Utility.AuthResult;

public interface ILoginUserUseCase
{
    User execute(String email, String password, Consumer<AuthResult> callback);
}
