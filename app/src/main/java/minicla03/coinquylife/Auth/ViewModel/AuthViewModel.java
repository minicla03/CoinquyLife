package minicla03.coinquylife.Auth.ViewModel;
import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import minicla03.coinquylife.Auth.Repository.UserRepository;
import minicla03.coinquylife.PERSISTANCE.database.entity.User;

public class AuthViewModel extends AndroidViewModel {

    private UserRepository userRepository;
    private MutableLiveData<Boolean> registrationResult;

    public AuthViewModel(Application application) {
        super(application);
        userRepository = new UserRepository(application.getApplicationContext());
        registrationResult = new MutableLiveData<>();
    }

    public LiveData<Boolean> getRegistrationResult() {
        return registrationResult;
    }

    public void registerUser(String email, String password, String name) {
        User user = new User(email, password, name);
        userRepository.insertUser(user);
        registrationResult.postValue(true);
    }
}
