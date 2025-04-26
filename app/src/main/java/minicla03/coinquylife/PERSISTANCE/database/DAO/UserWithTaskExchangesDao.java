package minicla03.coinquylife.PERSISTANCE.database.DAO;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import minicla03.coinquylife.PERSISTANCE.database.relationship.UserWithTaskExchangesRelationship;

@Dao
public interface UserWithTaskExchangesDao {

    @Transaction
    @Query("SELECT * FROM User WHERE id_user = :userId")
    UserWithTaskExchangesRelationship getUserWithTaskExchanges(String userId);

    @Transaction
    @Query("SELECT * FROM User")
    List<UserWithTaskExchangesRelationship> getAllUsersWithTaskExchanges();
}