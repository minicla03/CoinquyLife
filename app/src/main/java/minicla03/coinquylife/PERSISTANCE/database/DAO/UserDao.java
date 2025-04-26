package minicla03.coinquylife.PERSISTANCE.database.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import minicla03.coinquylife.PERSISTANCE.database.entity.User;

@Dao
public interface UserDao {

    @Insert
    void insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("SELECT * FROM User WHERE id_user = :idUser")
    User getUserById(String idUser);

    @Query("SELECT * FROM User")
    List<User> getAllUsers();
}