package minicla03.coinquylife.DATALAYER.remote.HouseSelectionAPI;

import minicla03.coinquylife.DATALAYER.local.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.local.entity.User;

public class SelectHouseResult
{
    private SelectHouseStatus status;
    private String mex;

    public SelectHouseResult(SelectHouseStatus status, String mex, User user)
    {
        this.status = status;
        this.coinquyHouse = coinquyHouse;
        this.user = user;
    }

    public SelectHouseStatus getStatus() {
        return this.status;
    }

    public void setStatus(SelectHouseStatus status) {this.status = status;}

    public User getUser() {
        return this.user;
    }

    public CoinquyHouse getCoinquyHouse() {
        return this.coinquyHouse;
    }
}
