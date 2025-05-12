package minicla03.coinquylife.FEATURE.Auth.DOMAIN.Repository;

import minicla03.coinquylife.DATALAYER.database.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.database.entity.User;

public interface IAuthRepository
{
    User getUserByEmail(String email);

    CoinquyHouse getHouseWithUsers(String id_user);

    void insertUser(User user);
}
