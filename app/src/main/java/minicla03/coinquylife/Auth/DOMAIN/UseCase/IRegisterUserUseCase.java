package minicla03.coinquylife.Auth.DOMAIN.UseCase;

import java.util.function.Consumer;

import minicla03.coinquylife.DATALAYER.remote.AuthAPI.AuthResult;
import minicla03.coinquylife.DATALAYER.local.entity.User;

public interface IRegisterUserUseCase
{
    void register(User user, Consumer<AuthResult> callback);
}
