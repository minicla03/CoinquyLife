package minicla03.coinquylife.PERSISTANCE.database.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

import minicla03.coinquylife.PERSISTANCE.database.entity.MessageBoard;
import minicla03.coinquylife.PERSISTANCE.database.entity.Note;

public class MessageBoardWithNoteRelationship
{
    @Embedded
    public MessageBoard messageBoard;

    @Relation(
            parentColumn = "id_board",
            entityColumn = "boardId"
    )
    public List<Note> notes;
}
