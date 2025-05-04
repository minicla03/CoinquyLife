package minicla03.coinquylife.PERSISTANCE.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

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

    @PrimaryKey @ColumnInfo(name = "id_choice") @NotNull private UUID id_choice;
    @ColumnInfo(name = "id_survey") private String id_survey;
    @ColumnInfo(name = "choice_description") private String choice_description;

    public Choice() { }

    @Ignore
    public Choice(String id_survey, String choice_description)
    {
        this.id_choice= UUID.randomUUID();
        this.id_survey = id_survey;
        this.choice_description = choice_description;
    }

    public UUID getIdChoice() {
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