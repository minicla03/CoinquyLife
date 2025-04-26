package minicla03.coinquylife.Auth.Repository;

import android.content.Context;
import androidx.room.Room;

import minicla03.coinquylife.PERSISTANCE.database.DatabaseManager;
import minicla03.coinquylife.PERSISTANCE.database.entity.User;

public class UserRepository {

    private DatabaseManager db;

    //TODO: singleton
    public UserRepository(Context context) {
        db = Room.databaseBuilder(context, DatabaseManager.class, "user-database").build();
    }

    public void insertUser(User user) {
        new Thread(() -> db.userDao().insertUser(user)).start();
    }
}
