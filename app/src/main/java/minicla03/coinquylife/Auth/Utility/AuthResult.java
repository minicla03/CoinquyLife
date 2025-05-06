package minicla03.coinquylife.Auth.Utility;

import minicla03.coinquylife.PERSISTANCE.database.entity.CoinquyHouse;
import minicla03.coinquylife.PERSISTANCE.database.entity.User;

public class AuthResult
{
    public AuthStatus status;
    public User user;
    public CoinquyHouse coinquyHouse;

    public AuthResult(AuthStatus status, User user, CoinquyHouse coinquyHouse)
    {
        this.status = status;
        this.user = user;
        this.coinquyHouse = coinquyHouse;
    }
}
