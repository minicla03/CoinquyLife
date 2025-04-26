package minicla03.coinquylife.Auth.Repository;

import minicla03.coinquylife.Auth.Data.LoginResult;

public class AuthRepository
{
    public interface LoginCallback
    {
        void onResult(LoginResult result);
    }

    public void login(String email, String password, LoginCallback callback)
    {
        // Simulazione backend
        if (email.equals("test@coinquy.it") && password.equals("1234")) {
            callback.onResult(new LoginResult(true));
        } else {
            callback.onResult(new LoginResult(false));
        }
    }
}
