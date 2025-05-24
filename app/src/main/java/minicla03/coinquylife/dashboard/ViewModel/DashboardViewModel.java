package minicla03.coinquylife.dashboard.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import minicla03.coinquylife.DATALAYER.RepositoryEntity.CoinquyHouseRepository;
import minicla03.coinquylife.DATALAYER.local.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.local.entity.User;
import minicla03.coinquylife.SelectionHouse.DOMAIN.Repository.ISelectHouseRepository;
import minicla03.coinquylife.SelectionHouse.DOMAIN.UseCase.RetriveUseCase;

public class DashboardViewModel extends AndroidViewModel
{
    private HashMap<String, String> data = new HashMap<>();
    private final MutableLiveData<HashMap<?, ?>> intentData = new MutableLiveData<>();
    private final MutableLiveData<User> retriveUserResult = new MutableLiveData<>();
    private final MutableLiveData<CoinquyHouse> retriveHouseResult = new MutableLiveData<>();

    private final RetriveUseCase retriveUserCase;
    private final RetriveUseCase retriveHouseCase;

    public DashboardViewModel(@NonNull Application application)
    {
        super(application);
        ISelectHouseRepository repo = new CoinquyHouseRepository(application);
        Executor executor = Executors.newSingleThreadExecutor();
        this.retriveUserCase = new RetriveUseCase(repo, executor);
        this.retriveHouseCase = new RetriveUseCase(repo, executor);
    }

    public void putIntentData(String key, String value)
    {
        data.put(key, value);
        intentData.postValue(data);
    }

    public LiveData<HashMap<?, ?>> getIntentData()
    {
        return intentData;
    }

    public void retriveUser(String id_user)
    {
        retriveUserCase.retriveUser(id_user, retriveUserResult::postValue);
    }

    public LiveData<User> getRetriveUserResult()
    {
        return retriveUserResult;
    }

    public void retriveHouse(String id_house)
    {
        retriveHouseCase.retriveHouse(id_house, retriveHouseResult::postValue);
    }

    public LiveData<CoinquyHouse> getRetriveHouseResult()
    {
        return retriveHouseResult;
    }
}



