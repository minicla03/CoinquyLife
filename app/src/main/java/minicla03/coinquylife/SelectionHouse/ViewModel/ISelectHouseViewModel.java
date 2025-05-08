package minicla03.coinquylife.SelectionHouse.ViewModel;

import androidx.lifecycle.LiveData;

import minicla03.coinquylife.PERSISTANCE.database.entity.User;
import minicla03.coinquylife.SelectionHouse.Utility.SelectHouseResult;

public interface ISelectHouseViewModel
{
    String generateHouseCode();

    void createHouse(String nameHouse, User user);

    void joinHouse(String houseCode, User user);

    User retriveUser(String id_user);

    LiveData<SelectHouseResult> getHouseCreationResult();

    LiveData<SelectHouseResult> getJoinHouseResult();
}
