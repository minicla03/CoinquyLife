package minicla03.coinquylife.SelectionHouse.DOMAIN.UseCase;

import java.util.concurrent.Executor;
import java.util.function.Consumer;

import minicla03.coinquylife.DATALAYER.local.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.local.entity.User;
import minicla03.coinquylife.SelectionHouse.DOMAIN.Repository.ISelectHouseRepository;
import minicla03.coinquylife.SelectionHouse.Utility.SelectHouseResult;
import minicla03.coinquylife.SelectionHouse.Utility.SelectHouseStatus;

public class JoinHouseUseCase
{
    private final ISelectHouseRepository repository;
    private final Executor executor;

    public JoinHouseUseCase(ISelectHouseRepository repo, Executor executor)
    {
        this.executor = executor;
        this.repository = repo;
    }

    public void execute(String houseCode, User user, Consumer<SelectHouseResult> callback) {
        executor.execute(() ->
        {
            if (user.getHouseUser() == null) {
                callback.accept(new SelectHouseResult(SelectHouseStatus.NOT_IN_HOUSE, null, user));
                return;
            }
            CoinquyHouse coinquyHouse = repository.joinHouse(houseCode, user);
            if (coinquyHouse == null) {
                callback.accept(new SelectHouseResult(SelectHouseStatus.HOUSE_NOT_FOUND, null, user));
            } else {
                callback.accept(new SelectHouseResult(SelectHouseStatus.SUCCESS, coinquyHouse, user));
            }
        });
    }
}
