package minicla03.coinquylife.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import minicla03.coinquylife.entity.TaskExchange;

@Dao
public interface TaskExchangeDao {

    @Insert
    void insertTaskExchange(TaskExchange taskExchange);

    @Update
    void updateTaskExchange(TaskExchange taskExchange);

    @Delete
    void deleteTaskExchange(TaskExchange taskExchange);

    @Query("SELECT * FROM TaskExchange WHERE id_exchange = :idExchange")
    TaskExchange getTaskExchangeById(String idExchange);

    @Query("SELECT * FROM TaskExchange")
    LiveData<List<TaskExchange>> getAllTaskExchanges();
}