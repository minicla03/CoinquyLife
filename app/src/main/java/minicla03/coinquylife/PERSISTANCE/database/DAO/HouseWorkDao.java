package minicla03.coinquylife.PERSISTANCE.database.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import minicla03.coinquylife.PERSISTANCE.database.entity.HouseWork;

@Dao
public interface HouseWorkDao {

    @Insert
    void insertHouseWork(HouseWork houseWork);

    @Update
    void updateHouseWork(HouseWork houseWork);

    @Delete
    void deleteHouseWork(HouseWork houseWork);

    @Query("SELECT * FROM HouseWork WHERE id_housework = :idHouseWork")
    HouseWork getHouseWorkById(String idHouseWork);

    @Query("SELECT * FROM HouseWork")
    List<HouseWork> getAllHouseWorks();
}