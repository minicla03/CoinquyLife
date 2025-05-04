package minicla03.coinquylife.Auth.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import minicla03.coinquylife.Auth.Utility.AuthResult;
import minicla03.coinquylife.Auth.Repository.LoginUserUseCase;
import minicla03.coinquylife.Auth.Repository.RegisterUserUseCase;
import minicla03.coinquylife.Auth.Repository.AuthRepository;
import minicla03.coinquylife.PERSISTANCE.database.entity.User;

public class AuthViewModel extends AndroidViewModel
{
    private final LoginUserUseCase loginUseCase;
    private final RegisterUserUseCase registerUseCase;

    private final MutableLiveData<AuthResult> loginResult = new MutableLiveData<>();
    private final MutableLiveData<AuthResult> registerResult = new MutableLiveData<>();
    private final MutableLiveData<String> currentFragment = new MutableLiveData<>();

    public AuthViewModel(@NonNull Application application)
    {
        super(application);
        AuthRepository repo = new AuthRepository(application);
        loginUseCase = new LoginUserUseCase(repo);
        registerUseCase = new RegisterUserUseCase(repo);
    }

    public LiveData<AuthResult> getLoginResult()
    {
        return loginResult;
    }

    public LiveData<AuthResult> getRegisterResult()
    {
        return registerResult;
    }

    public LiveData<String> getCurrentFragment() {
        return currentFragment;
    }

    public void setCurrentFragment(String fragmentTag) {
        currentFragment.setValue(fragmentTag);
    }

    public void login(String email, String password)
    {
        loginUseCase.execute(email, password, loginResult::postValue);
    }

    public void register(User user)
    {
        registerUseCase.execute(user, registerResult::postValue);
    }
}
