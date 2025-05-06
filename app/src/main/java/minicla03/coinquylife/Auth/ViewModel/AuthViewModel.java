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
import minicla03.coinquylife.Auth.Utility.AuthStatus;
import minicla03.coinquylife.PERSISTANCE.database.entity.User;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class AuthViewModel extends AndroidViewModel
{
    private final LoginUserUseCase loginUseCase;
    private final RegisterUserUseCase registerUseCase;

    private final MutableLiveData<AuthResult> loginResult = new MutableLiveData<>();
    private final MutableLiveData<AuthResult> registerResult = new MutableLiveData<>();

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

    public void login(String email, String password)
    {
        if(isValidEmail(email))
        {
            loginResult.postValue(new AuthResult(AuthStatus.INVALID_EMAIL, null, null));
            return;
        }
        loginUseCase.execute(email, password, loginResult::postValue);
    }

    public void register(User user)
    {
        if(isValidEmail(user.getEmail()))
        {
            loginResult.postValue(new AuthResult(AuthStatus.INVALID_EMAIL, null, null));
            return;
        }
        registerUseCase.execute(user, registerResult::postValue);
    }

    public boolean isValidEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (email == null) {
            return true;
        }
        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
    }
}
