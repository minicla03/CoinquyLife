package minicla03.coinquylife.DAO;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

import minicla03.coinquylife.entity.CoinquyHouse;
import minicla03.coinquylife.entity.MessageBoard;
import minicla03.coinquylife.entity.Note;
import minicla03.coinquylife.entity.User;

public class MessageBoardWithNote
{
    @Embedded
    public MessageBoard messageBoard;

    @Relation(
            parentColumn = "id_board",
            entityColumn = "boardId"
    )
    public List<Note> notes;
}
