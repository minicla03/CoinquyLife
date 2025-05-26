package minicla03.coinquylife.SelectionHouse.DOMAIN.UseCase;

public interface IJoinHouseUseCase
{
    void execute(String houseCode, minicla03.coinquylife.DATALAYER.local.entity.User user, java.util.function.Consumer<minicla03.coinquylife.DATALAYER.remote.HouseSelectionAPI.SelectHouseResult> callback);
}
