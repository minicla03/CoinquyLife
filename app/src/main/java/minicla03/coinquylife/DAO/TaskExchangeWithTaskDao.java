package minicla03.coinquylife.DAO;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import minicla03.coinquylife.relationship.TaskExchangeWithTaskRelationship;

@Dao
public interface TaskExchangeWithTaskDao {

    @Transaction
    @Query("SELECT * FROM TaskExchange WHERE id_exchange = :exchangeId")
    TaskExchangeWithTaskRelationship getTaskExchangeWithTask(String exchangeId);

    @Transaction
    @Query("SELECT * FROM TaskExchange")
    List<TaskExchangeWithTaskRelationship> getAllTaskExchangesWithTasks();
}