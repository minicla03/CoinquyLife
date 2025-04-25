package minicla03.coinquylife.DATALAYER.database.DAO;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import minicla03.coinquylife.DATALAYER.database.relationship.UserWithTasksRelationship;

@Dao
public interface UserWithTasksDao {

    @Transaction
    @Query("SELECT * FROM User WHERE id_user = :userId")
    UserWithTasksRelationship getUserWithTasks(String userId);

    @Transaction
    @Query("SELECT * FROM User")
    List<UserWithTasksRelationship> getAllUsersWithTasks();
}
