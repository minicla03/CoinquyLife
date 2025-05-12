package minicla03.coinquylife.FEATURE.Auth.Utility;

import minicla03.coinquylife.DATALAYER.database.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.database.entity.User;

public class AuthResult
{
    public static AuthStatus status;
    public User user;
    public CoinquyHouse coinquyHouse;

    public AuthResult(AuthStatus status, User user, CoinquyHouse coinquyHouse)
    {
        this.status = status;
        this.user = user;
        this.coinquyHouse = coinquyHouse;
    }
}
