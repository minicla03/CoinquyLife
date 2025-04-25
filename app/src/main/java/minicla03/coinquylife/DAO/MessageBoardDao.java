package minicla03.coinquylife.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import minicla03.coinquylife.entity.MessageBoard;
import minicla03.coinquylife.relationship.MessageBoardWithNoteRelationship;

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