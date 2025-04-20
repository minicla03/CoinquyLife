package minicla03.coinquylife.DAO;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import minicla03.coinquylife.relationship.MessageBoardWithNoteRelationship;

@Dao
public interface MessageBoardWithNoteRelationshipDao {

    @Transaction
    @Query("SELECT * FROM MessageBoard WHERE id_board = :boardId")
    MessageBoardWithNoteRelationship getMessageBoardWithNotes(String boardId);

    @Transaction
    @Query("SELECT * FROM MessageBoard")
    List<MessageBoardWithNoteRelationship> getAllMessageBoardsWithNotes();
}