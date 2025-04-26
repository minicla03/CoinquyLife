package minicla03.coinquylife.entity;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.UUID;

@Entity(
        tableName = "Survey",
        foreignKeys = @ForeignKey(
                entity = MessageBoard.class,
                parentColumns = "id_board",
                childColumns = "boardId",
                onDelete = ForeignKey.CASCADE
        ),
        indices = {@Index(value = "boardId")}
)
public class Survey
{
    @PrimaryKey @ColumnInfo(name = "id_survey") @NotNull private String id_survey;
    @ColumnInfo(name="expired_date") private String expired_date;
    @Embedded Note note;

    public Survey(){ }

    public String getId_survey() {
        return this.id_survey;
    }

    public void setId_survey(String id_survey) {
        this.id_survey = id_survey;
    }

    public String getExpired_date() {
        return this.expired_date;
    }

    public void setExpired_date(String expired_date) {
        this.expired_date = expired_date;
    }

    public Note getNote() {return note;}

    public void setNote(Note note) {this.note = note;}
}
