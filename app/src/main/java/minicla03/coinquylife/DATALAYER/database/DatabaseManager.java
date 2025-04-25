package minicla03.coinquylife.DATALAYER.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import minicla03.coinquylife.DATALAYER.database.DAO.ChoiceDao;
import minicla03.coinquylife.DATALAYER.database.DAO.CoinquyHouseDao;
import minicla03.coinquylife.DATALAYER.database.DAO.CoiquyHouseWithUserRelationshipDao;
import minicla03.coinquylife.DATALAYER.database.DAO.HouseWithTasksRelationshipDao;
import minicla03.coinquylife.DATALAYER.database.DAO.HouseWorkDao;
import minicla03.coinquylife.DATALAYER.database.DAO.MessageBoardDao;
import minicla03.coinquylife.DATALAYER.database.DAO.MessageBoardWithNoteRelationshipDao;
import minicla03.coinquylife.DATALAYER.database.DAO.NoteDao;
import minicla03.coinquylife.DATALAYER.database.DAO.PurchaseDao;
import minicla03.coinquylife.DATALAYER.database.DAO.PurchaseRelationshipDao;
import minicla03.coinquylife.DATALAYER.database.DAO.SurveyDao;
import minicla03.coinquylife.DATALAYER.database.DAO.TaskDao;
import minicla03.coinquylife.DATALAYER.database.DAO.TaskExchangeDao;
import minicla03.coinquylife.DATALAYER.database.DAO.TaskExchangeWithTaskDao;
import minicla03.coinquylife.DATALAYER.database.DAO.UserDao;
import minicla03.coinquylife.DATALAYER.database.DAO.UserWithTaskExchangesDao;
import minicla03.coinquylife.DATALAYER.database.DAO.UserWithTasksDao;
import minicla03.coinquylife.DATALAYER.database.entity.Choice;
import minicla03.coinquylife.DATALAYER.database.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.database.entity.HouseWork;
import minicla03.coinquylife.DATALAYER.database.entity.MessageBoard;
import minicla03.coinquylife.DATALAYER.database.entity.Note;
import minicla03.coinquylife.DATALAYER.database.entity.Purchase;
import minicla03.coinquylife.DATALAYER.database.entity.Survey;
import minicla03.coinquylife.DATALAYER.database.entity.Task;
import minicla03.coinquylife.DATALAYER.database.entity.TaskExchange;
import minicla03.coinquylife.DATALAYER.database.entity.User;

@Database(entities = {Choice.class, Purchase.class, Task.class, TaskExchange.class, User.class,
                        CoinquyHouse.class, HouseWork.class, MessageBoard.class, Note.class, Survey.class},
        version = 1,
        exportSchema = false)
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
                    .addCallback(roomCallback)
                    .build();
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback roomCallback = new RoomDatabase.Callback()
    {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db)
        {
            super.onCreate(db);
            //new PopulateDbAsyncTask(INSTANCE).execute();
        }
    };

    /**private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>
    {
        private PopulateDbAsyncTask(DatabaseManager db) {
            noteDao = db.noteDao();
        }
        @Override
        protected Void doInBackground(Void... voids)
        {
            noteDao.insert(new Note("Note 1", "Description 1", 1,-1,-1));
            noteDao.insert(new Note("Note 2", "Description 2", 2,-1,-1));
            noteDao.insert(new Note("Note 3", "Description 3", 3,-1,-1));
            return null;
        }
    }**/
}