package minicla03.coinquylife.Auth.Repository;

import minicla03.coinquylife.PERSISTANCE.database.entity.User;

public class AuthResult
{
    public AuthStatus status;
    public User user;

    public AuthResult(AuthStatus status, User user)
    {
        this.status = status;
        this.user = user;
    }
}
