package minicla03.coinquylife.PERSISTANCE.database.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import minicla03.coinquylife.PERSISTANCE.database.entity.MessageBoard;

@Dao
public interface MessageBoardDao {
    @Insert
    void insertBoard(MessageBoard board);

    @Update
    void updateBoard(MessageBoard board);

    @Delete
    void deleteBoard(MessageBoard board);

    @Query("SELECT * FROM MessageBoard WHERE id_board = :idBoard")
    LiveData<MessageBoard> getBoardById(String idBoard);

    @Query("SELECT * FROM MessageBoard")
    LiveData<List<MessageBoard>> getAllBoards();
}