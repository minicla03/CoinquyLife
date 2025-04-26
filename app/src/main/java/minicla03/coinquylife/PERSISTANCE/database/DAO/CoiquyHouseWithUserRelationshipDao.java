package minicla03.coinquylife.PERSISTANCE.database.DAO;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import minicla03.coinquylife.PERSISTANCE.database.relationship.CoiquyHouseWithUserRelationship;

@Dao
public interface CoiquyHouseWithUserRelationshipDao {

    @Transaction
    @Query("SELECT * FROM CoinquyHouse WHERE id_house = :houseId")
    CoiquyHouseWithUserRelationship getHouseWithUsers(String houseId);

    @Transaction
    @Query("SELECT * FROM CoinquyHouse")
    List<CoiquyHouseWithUserRelationship> getAllHousesWithUsers();
}