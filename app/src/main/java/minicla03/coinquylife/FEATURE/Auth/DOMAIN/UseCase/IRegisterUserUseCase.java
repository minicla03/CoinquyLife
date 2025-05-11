package minicla03.coinquylife.FEATURE.Auth.DOMAIN.UseCase;

import java.util.function.Consumer;

import minicla03.coinquylife.FEATURE.Auth.Utility.AuthResult;
import minicla03.coinquylife.DATALAYER.database.entity.User;

public interface IRegisterUserUseCase {
    void execute(User user, Consumer<AuthResult> callback);
}
