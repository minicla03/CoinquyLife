package minicla03.coinquylife.SelectionHouse.PRESENTATION.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import minicla03.coinquylife.DATALAYER.local.entity.User;
import minicla03.coinquylife.SelectionHouse.DOMAIN.Repository.ISelectHouseRepository;
import minicla03.coinquylife.SelectionHouse.DOMAIN.UseCase.IJoinHouseUseCase;
import minicla03.coinquylife.SelectionHouse.DOMAIN.UseCase.INewHouseUseCase;
import minicla03.coinquylife.SelectionHouse.DOMAIN.UseCase.JoinHouseUseCase;
import minicla03.coinquylife.SelectionHouse.DOMAIN.UseCase.NewHouseUseCase;
import minicla03.coinquylife.SelectionHouse.DOMAIN.UseCase.RetriveUseCase;
import minicla03.coinquylife.DATALAYER.RepositoryEntity.HouseSelectionRepository;
import minicla03.coinquylife.DATALAYER.remote.HouseSelectionAPI.SelectHouseResult;

public class SelectHouseViewModel extends AndroidViewModel
{
    private final INewHouseUseCase newHouseUseCase;
    private final IJoinHouseUseCase joinHouseUseCase;
    private final RetriveUseCase retriveUserCase;
    // private HashMap<String, String> data = new HashMap<>();

    //private final MutableLiveData<HashMap<?,?>> intentData = new MutableLiveData<>();
    private final MutableLiveData<SelectHouseResult> houseCreationResult = new MutableLiveData<>();
    private final MutableLiveData<SelectHouseResult> joinHouseResult = new MutableLiveData<>();
    private final MutableLiveData<String> houseID=new MutableLiveData<>();
    private final MutableLiveData<User> retriveUserResult = new MutableLiveData<>();

    public SelectHouseViewModel(@NonNull Application application)
    {
        super(application);
        ISelectHouseRepository repo = new HouseSelectionRepository(application);
        Executor executor= Executors.newSingleThreadExecutor();
        this.retriveUserCase = new RetriveUseCase(repo, executor);
        this.newHouseUseCase = new NewHouseUseCase(repo,executor);
        this.joinHouseUseCase = new JoinHouseUseCase(repo, executor);
    }

    public void createHouse(String houseName, String address, String token)
    {
        newHouseUseCase.execute(houseName, address, token, houseCreationResult::postValue);
    }

    public void joinHouse()
    {
        joinHouseUseCase.execute();
    }

    public void retriveUser(String id_user)
    {
        retriveUserCase.retriveUser(id_user, retriveUserResult::postValue);
    }

    public LiveData<SelectHouseResult> getHouseCreationResult()
    {
        return houseCreationResult;
    }

    /*public void putIntentData(String k, String value)
    {
        data.put(k, value);
        intentData.postValue(data);
    }*/

    public LiveData<SelectHouseResult> getJoinHouseResult()
    {
        return joinHouseResult;
    }

    public LiveData<User> getRetriveUserResult()
    {
        return retriveUserResult;
    }

    public LiveData<String> getHouseCode()
    {
        return houseID;
    }

    //public LiveData<HashMap<?,?>> getIntentData(){ return intentData;}
}
