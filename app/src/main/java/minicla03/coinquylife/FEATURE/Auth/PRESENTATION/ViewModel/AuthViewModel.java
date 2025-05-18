package minicla03.coinquylife.FEATURE.Auth.PRESENTATION.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import minicla03.coinquylife.DATALAYER.database.RepositoryEntity.UserRepository;
import minicla03.coinquylife.DATALAYER.database.entity.User;
import minicla03.coinquylife.FEATURE.Auth.DOMAIN.Repository.IAuthRepository;
import minicla03.coinquylife.FEATURE.Auth.DOMAIN.UseCase.LoginUserUseCase;
import minicla03.coinquylife.FEATURE.Auth.DOMAIN.UseCase.RegisterUserUseCase;
import minicla03.coinquylife.FEATURE.Auth.Utility.AuthResult;
import minicla03.coinquylife.FEATURE.Auth.Utility.AuthStatus;

public class AuthViewModel extends AndroidViewModel
{
    private final LoginUserUseCase loginUseCase;
    private final RegisterUserUseCase registerUseCase;

    private final MutableLiveData<AuthResult> loginResult = new MutableLiveData<>();
    private final MutableLiveData<AuthResult> registerResult = new MutableLiveData<>();

    public AuthViewModel(@NonNull Application application)
    {
        super(application);
        IAuthRepository repo = new UserRepository(application);
        Executor executor = Executors.newSingleThreadExecutor();
        loginUseCase = new LoginUserUseCase(repo, executor);
        registerUseCase = new RegisterUserUseCase(repo, executor);
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
        if (isValidEmail(email)) {
            loginResult.postValue(new AuthResult(AuthStatus.INVALID_EMAIL, null, null));
            return;
        }
        loginUseCase.login(email, password, loginResult::postValue);
    }

    public void register(User user)
    {
        if (isValidEmail(user.getEmail()))
        {
            registerResult.postValue(new AuthResult(AuthStatus.INVALID_EMAIL, null, null));
            return;
        }
        registerUseCase.register(user, registerResult::postValue);
    }

    private boolean isValidEmail(String email)
    {
        if (email == null) return true;

        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
    }
}
