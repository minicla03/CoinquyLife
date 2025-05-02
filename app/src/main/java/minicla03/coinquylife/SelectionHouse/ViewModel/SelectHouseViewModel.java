package minicla03.coinquylife.SelectionHouse.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.UUID;

import minicla03.coinquylife.PERSISTANCE.database.entity.User;
import minicla03.coinquylife.SelectionHouse.Repository.JoinHouseUseCase;
import minicla03.coinquylife.SelectionHouse.Repository.NewHouseUseCase;
import minicla03.coinquylife.SelectionHouse.Repository.SelectHouseRepository;
import minicla03.coinquylife.SelectionHouse.Utility.SelectHouseResult;

public class SelectHouseViewModel extends AndroidViewModel
{
    private final NewHouseUseCase newHouseUseCase;
    private final JoinHouseUseCase joinHouseUseCase;
    private final UUID houseID;

    private final MutableLiveData<SelectHouseResult> houseCreationResult = new MutableLiveData<>();
    private final MutableLiveData<SelectHouseResult> joinHouseResult = new MutableLiveData<>();

    public SelectHouseViewModel(@NonNull Application application)
    {
        super(application);
        houseID = UUID.randomUUID();
        SelectHouseRepository repo = new SelectHouseRepository(application);
        this.newHouseUseCase = new NewHouseUseCase(repo);
        this.joinHouseUseCase = new JoinHouseUseCase(repo);
    }

    public String generateHouseCode()
    {
        return houseID.toString();
    }

    public void createHouse(String nameHouse, User user)
    {
        newHouseUseCase.execute(houseID.toString(),nameHouse, user, houseCreationResult::postValue);
    }

    public void joinHouse(String houseCode, User user)
    {
        joinHouseUseCase.execute(houseCode, user, joinHouseResult::postValue);
    }

    public LiveData<SelectHouseResult> getHouseCreationResult()
    {
        return houseCreationResult;
    }

    public LiveData<SelectHouseResult> getJoinHouseResult()
    {
        return joinHouseResult;
    }
}
