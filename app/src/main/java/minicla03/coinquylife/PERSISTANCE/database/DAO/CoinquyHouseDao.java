package minicla03.coinquylife.PERSISTANCE.database.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import minicla03.coinquylife.PERSISTANCE.database.entity.CoinquyHouse;


@Dao
public interface CoinquyHouseDao
{
    @Insert void insertCoinquyHouse(CoinquyHouse coinquyHouse);

    @Update void updateCoinquyHouse(CoinquyHouse coinquyHouse);

    @Delete void deleteCoinquyHouse(CoinquyHouse coinquyHouse);

    @Query("SELECT * FROM CoinquyHouse") List<CoinquyHouse> getAllCoinquyHouses();

    @Query("SELECT * FROM CoinquyHouse WHERE id_house = :houseId")
    CoinquyHouse getCoinquyHouseById(String houseId);
}