package minicla03.coinquylife.DATALAYER.local.DAO;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import minicla03.coinquylife.DATALAYER.local.relationship.HouseWithTasksRelationship;

@Dao
public interface HouseWithTasksRelationshipDao {

    @Transaction
    @Query("SELECT * FROM CoinquyHouse WHERE id_house = :houseId")
    HouseWithTasksRelationship getHouseWithTasks(String houseId);

    @Transaction
    @Query("SELECT * FROM CoinquyHouse")
    List<HouseWithTasksRelationship> getAllHousesWithTasks();
}