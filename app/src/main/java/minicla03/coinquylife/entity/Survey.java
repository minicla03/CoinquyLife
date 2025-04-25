package minicla03.coinquylife.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.UUID;

@Entity(
        tableName = "Survey",
        foreignKeys = @ForeignKey(
                        entity = User.class,
                        parentColumns = "id_user",
                        childColumns = "id_user",
                        onDelete = ForeignKey.CASCADE),
        indices = {@Index(value = "id_user")}
)
public class Survey extends Note
{
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_survey") private String id_survey;
    @ColumnInfo(name="expired_date") private String expired_date;

    public Survey(String boardId, String author, Date publish_date, String description, String expired_date)
    {
        super(boardId, author, publish_date, description);
        this.expired_date = expired_date;
    }

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
}
