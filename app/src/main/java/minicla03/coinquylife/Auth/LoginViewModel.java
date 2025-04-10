package minicla03.coinquylife.Auth;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel
{
    private AuthRepository authRepository = new AuthRepository();
    private final MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();

    public LoginViewModel(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void login(String email, String password)
    {
        if (email == null || email.isEmpty() || !email.contains("@")) {
            loginResult.postValue(new LoginResult(false));
            return;
        }
        if (password == null || password.isEmpty()) {
            loginResult.postValue(new LoginResult(false));
            return;
        }
        authRepository.login(email, password, result -> loginResult.postValue(result));
    }
}