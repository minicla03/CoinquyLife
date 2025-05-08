package minicla03.coinquylife.Auth.ViewModel;

import androidx.lifecycle.LiveData;

import minicla03.coinquylife.Auth.Utility.AuthResult;
import minicla03.coinquylife.PERSISTANCE.database.entity.User;

public interface IAuthViewModel
{
    void login(String email, String password);

    void register(User user);

    LiveData<AuthResult> getLoginResult();

    LiveData<AuthResult> getRegisterResult();
}
