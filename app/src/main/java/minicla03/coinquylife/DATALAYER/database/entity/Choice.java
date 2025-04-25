package minicla03.coinquylife.DATALAYER.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(
        tableName = "Choice",
        foreignKeys = @ForeignKey(
                entity = Survey.class,
                parentColumns = "id_survey",
                childColumns = "id_survey",
                onDelete = ForeignKey.CASCADE
        ),
        indices = {@Index(value = "id_survey")}
)
public class Choice {

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_choice") private String id_choice;
    @ColumnInfo(name = "id_survey") private String id_survey;
    @ColumnInfo(name = "choice_description") private String choice_description;


    public Choice(String id_survey, String choice_description)
    {
        this.id_choice= UUID.randomUUID().toString();
        this.id_survey = id_survey;
        this.choice_description = choice_description;
    }

    public String getIdChoice() {
        return this.id_choice;
    }

    public String getIdSurvey() {
        return this.id_survey;
    }

    public void setIdSurvey(String id_survey) {
        this.id_survey = id_survey;
    }

    public String getChoiceDescription() {
        return this.choice_description;
    }

    public void setChoiceDescription(String choice_description) {
        this.choice_description = choice_description;
    }
}