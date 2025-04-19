package minicla03.coinquylife.DAO;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

@Dao
public interface MessageBoardDao {
    @Transaction
    @Query("SELECT * FROM MessageBoard WHERE id_board = :boardId")
    MessageBoardWithNote getMessageBoardWithNote(String houseId);
}
