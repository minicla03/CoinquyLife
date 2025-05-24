package minicla03.coinquylife.DATALAYER.local;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import minicla03.coinquylife.DATALAYER.local.DAO.ChoiceDao;
import minicla03.coinquylife.DATALAYER.local.DAO.CoinquyHouseDao;
import minicla03.coinquylife.DATALAYER.local.DAO.CoiquyHouseWithUserRelationshipDao;
import minicla03.coinquylife.DATALAYER.local.DAO.HouseWithTasksRelationshipDao;
import minicla03.coinquylife.DATALAYER.local.DAO.HouseWorkDao;
import minicla03.coinquylife.DATALAYER.local.DAO.MessageBoardDao;
import minicla03.coinquylife.DATALAYER.local.DAO.MessageBoardWithNoteRelationshipDao;
import minicla03.coinquylife.DATALAYER.local.DAO.NoteDao;
import minicla03.coinquylife.DATALAYER.local.DAO.PurchaseDao;
import minicla03.coinquylife.DATALAYER.local.DAO.PurchaseRelationshipDao;
import minicla03.coinquylife.DATALAYER.local.DAO.SurveyDao;
import minicla03.coinquylife.DATALAYER.local.DAO.TaskDao;
import minicla03.coinquylife.DATALAYER.local.DAO.TaskExchangeDao;
import minicla03.coinquylife.DATALAYER.local.DAO.TaskExchangeWithTaskDao;
import minicla03.coinquylife.DATALAYER.local.DAO.UserDao;
import minicla03.coinquylife.DATALAYER.local.DAO.UserWithTaskExchangesDao;
import minicla03.coinquylife.DATALAYER.local.DAO.UserWithTasksDao;
import minicla03.coinquylife.DATALAYER.local.entity.Choice;
import minicla03.coinquylife.DATALAYER.local.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.local.entity.HouseWork;
import minicla03.coinquylife.DATALAYER.local.entity.MessageBoard;
import minicla03.coinquylife.DATALAYER.local.entity.Note;
import minicla03.coinquylife.DATALAYER.local.entity.Purchase;
import minicla03.coinquylife.DATALAYER.local.entity.Survey;
import minicla03.coinquylife.DATALAYER.local.entity.Task;
import minicla03.coinquylife.DATALAYER.local.entity.TaskExchange;
import minicla03.coinquylife.DATALAYER.local.entity.User;

@Database(entities = {Choice.class, Purchase.class, Task.class, TaskExchange.class, User.class,
                        CoinquyHouse.class, HouseWork.class, MessageBoard.class, Note.class, Survey.class},
        version = 3,
        exportSchema = false)
@TypeConverters(Converters.class)
public abstract class DatabaseManager extends RoomDatabase
{
    private static volatile DatabaseManager INSTANCE;

    public abstract ChoiceDao choiceDao();
    public abstract PurchaseDao purchaseDao();
    public abstract TaskDao taskDao();
    public abstract TaskExchangeDao taskExchangeDao();
    public abstract UserDao userDao();
    public abstract CoinquyHouseDao coinquyHouseDao();
    public abstract HouseWorkDao houseWorkDao();
    public abstract MessageBoardDao messageBoardDao();
    public abstract NoteDao noteDao();
    public abstract SurveyDao surveyDao();

    public abstract CoiquyHouseWithUserRelationshipDao coiquyHouseWithUserRelationshipDao();
    public abstract HouseWithTasksRelationshipDao houseWithTasksRelationshipDao();
    public abstract MessageBoardWithNoteRelationshipDao messageBoardWithNoteRelationshipDao();
    public abstract PurchaseRelationshipDao purchaseRelationshipDao();
    public abstract TaskExchangeWithTaskDao taskExchangeWithTaskDao();
    public abstract UserWithTaskExchangesDao userWithTaskExchangesDao();
    public abstract UserWithTasksDao userWithTasksDao();

    public synchronized static DatabaseManager getInstance(Context context)
    {
        if (INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DatabaseManager.class, "coinquylife_database")
                    .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                    .build();
        }
        return INSTANCE;
    }

    static final Migration MIGRATION_1_2 = new Migration(1, 2)
    {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database)
        {
            database.execSQL("CREATE INDEX IF NOT EXISTS index_User_houseUser ON User(houseUser)");
        }
    };

    static final Migration MIGRATION_2_3 = new Migration(2, 3)
    {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database)
        {
            database.execSQL("ALTER TABLE Purchase ADD COLUMN amount DOUBLE");
        }
    };

}