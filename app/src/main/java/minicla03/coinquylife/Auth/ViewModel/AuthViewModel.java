package minicla03.coinquylife.Auth.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import minicla03.coinquylife.Auth.Repository.LoginUserUseCase;
import minicla03.coinquylife.Auth.Repository.RegisterUserUseCase;
import minicla03.coinquylife.Auth.Repository.UserRepository;
import minicla03.coinquylife.PERSISTANCE.database.entity.User;

public class AuthViewModel extends AndroidViewModel
{
    private final LoginUserUseCase loginUseCase;
    private final RegisterUserUseCase registerUseCase;

    private final MutableLiveData<User> loginResult = new MutableLiveData<>();
    private final MutableLiveData<Boolean> registerResult = new MutableLiveData<>();

    public AuthViewModel(@NonNull Application application) {
        super(application);
        UserRepository repo = new UserRepository(application);
        loginUseCase = new LoginUserUseCase(repo);
        registerUseCase = new RegisterUserUseCase(repo);
    }

    public LiveData<User> getLoginResult() {
        return loginResult;
    }

    public LiveData<Boolean> getRegisterResult() {
        return registerResult;
    }

    public void login(String email, String password) {
        loginUseCase.execute(email, password, loginResult::postValue);
    }

    public void register(User user) {
        registerUseCase.execute(user, registerResult::postValue);
    }
}
