package minicla03.coinquylife.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(
    tableName = "Note",
    foreignKeys = @ForeignKey(
        entity = MessageBoard.class,
        parentColumns = "id_board",
        childColumns = "boardId",
        onDelete = ForeignKey.CASCADE
    ),
    indices = {@Index(value = "boardId")}
)
public class Note
{
    @PrimaryKey @ColumnInfo(name = "id_note") private int id_note;
    @ColumnInfo(name = "boardId") private String boardId;
    @ColumnInfo(name = "author") private String author;
    @ColumnInfo(name = "publish_date") private Date publish_date;
    @ColumnInfo(name = "description") private String description;

    public Note(){ }

    @Ignore
    public Note(String boardId, String author, Date publish_date, String description)
    {
        this.boardId = boardId;
        this.author = author;
        this.publish_date = publish_date;
        this.description = description;
    }

    public int getId_note() {
        return id_note;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}