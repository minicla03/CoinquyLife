package minicla03.coinquylife.FEATURE.SelectionHouse.Utility;

import minicla03.coinquylife.DATALAYER.database.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.database.entity.User;

public class SelectHouseResult
{
    private SelectHouseStatus status;
    private CoinquyHouse coinquyHouse;
    private User user;

    public SelectHouseResult(SelectHouseStatus status, CoinquyHouse coinquyHouse, User user)
    {
        this.status = status;
        this.coinquyHouse = coinquyHouse;
        this.user = user;
    }

    public SelectHouseStatus getStatus() {
        return this.status;
    }

    public User getUser() {
        return this.user;
    }

    public CoinquyHouse getCoinquyHouse() {
        return this.coinquyHouse;
    }
}
