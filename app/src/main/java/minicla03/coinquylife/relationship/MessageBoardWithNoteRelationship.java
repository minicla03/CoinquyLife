package minicla03.coinquylife.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

import minicla03.coinquylife.entity.MessageBoard;
import minicla03.coinquylife.entity.Note;

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
