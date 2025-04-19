package minicla03.coinquylife.DAO;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import minicla03.coinquylife.DAO.CoinquyHouseWithUser;

@Dao
public interface CoinquyHouseDao {
    @Transaction
    @Query("SELECT * FROM CoinquyHouse WHERE id_house = :houseUser")
    CoinquyHouseWithUser getHouseWithUsers(String houseId);
}