package minicla03.coinquylife.Auth.Utility;

import minicla03.coinquylife.DATALAYER.local.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.local.entity.User;

public class AuthResult
{
    public static AuthStatus status;
    public User user;
    public CoinquyHouse coinquyHouse;

    public AuthResult(AuthStatus status, User user, CoinquyHouse coinquyHouse)
    {
        AuthResult.status = status;
        this.user = user;
        this.coinquyHouse = coinquyHouse;
    }
}
