package minicla03.coinquylife.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import minicla03.coinquylife.PERSISTANCE.database.DAO.UserDao;
import minicla03.coinquylife.PERSISTANCE.database.DatabaseManager;
import minicla03.coinquylife.PERSISTANCE.database.entity.User;

@RunWith(AndroidJUnit4.class)
public class UserEntityTest
{
    private DatabaseManager db;
    private UserDao userDao;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, DatabaseManager.class)
                 .allowMainThreadQueries()
                 .build();
        userDao = db.userDao();
    }

    @After
    public void closeDb() {
        db.close();
    }

    @Test
    public void testInsertAndGetUser() {
        User user = new User("testUser", "Mario", "pass123", "Rossi", "test@example.com", null);
        userDao.insertUser(user);

        User fetched = userDao.getUserById(user.getId_user());
        assertNotNull(fetched);
        assertEquals("testUser", fetched.getUsername());
    }

    @Test
    public void testUpdateUser() {
        User user = new User("testUser", "Mario", "pass123", "Rossi", "test@example.com", null);
        userDao.insertUser(user);

        user.setUsername("newUsername");
        userDao.updateUser(user);

        User updated = userDao.getUserById(user.getId_user());
        assertEquals("newUsername", updated.getUsername());
    }

    @Test
    public void testDeleteUser() {
        User user = new User("testUser", "Mario", "pass123", "Rossi", "test@example.com", null);
        userDao.insertUser(user);

        userDao.deleteUser(user);

        User deleted = userDao.getUserById(user.getId_user());
        assertNull(deleted);
    }

    @Test
    public void testGetAllUsers() {
        User user1 = new User("user1", "Luca", "pass123", "Bianchi", "luca@example.com", null);
        User user2 = new User("user2", "Sara", "pass456", "Verdi", "sara@example.com", null);

        userDao.insertUser(user1);
        userDao.insertUser(user2);

        List<User> allUsers = userDao.getAllUsers();
        assertEquals(2, allUsers.size());
    }
}
