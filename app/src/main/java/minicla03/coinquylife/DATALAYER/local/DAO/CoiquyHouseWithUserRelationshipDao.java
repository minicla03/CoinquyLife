package minicla03.coinquylife.DATALAYER.local.DAO;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import minicla03.coinquylife.DATALAYER.local.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.local.relationship.CoinquyHouseWithUserRelationship;

@Dao
public interface CoiquyHouseWithUserRelationshipDao {

    @Transaction
    @Query("SELECT * FROM CoinquyHouse WHERE id_house = :houseId")
    CoinquyHouseWithUserRelationship getHouseWithUsers(String houseId);

    @Transaction
    @Query("SELECT * FROM CoinquyHouse")
    List<CoinquyHouseWithUserRelationship> getAllHousesWithUsers();

    @Transaction
    @Query("SELECT * FROM CoinquyHouse WHERE id_house = :houseId")
    CoinquyHouse getCoinquyHouseById(@NotNull String houseId);
}