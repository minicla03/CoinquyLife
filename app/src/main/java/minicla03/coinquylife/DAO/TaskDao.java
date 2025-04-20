package minicla03.coinquylife.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

import java.util.List;

import minicla03.coinquylife.entity.Task;

@Dao
public interface TaskDao {

    @Insert
    void insertTask(Task task);

    @Update
    void updateTask(Task task);

    @Delete
    void deleteTask(Task task);

    @Query("SELECT * FROM Task")
    List<Task> getAllTasks();

    @Query("SELECT * FROM Task WHERE id_user = :tenantId")
    List<Task> getTasksByTenant(String tenantId);

    @Query("SELECT * FROM Task WHERE id_house = :houseId")
    List<Task> getTasksByHouse(String houseId);
}