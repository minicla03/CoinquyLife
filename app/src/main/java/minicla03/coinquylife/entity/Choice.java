package minicla03.coinquylife.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "Choice",
        foreignKeys = @ForeignKey(
                entity = Survey.class,
                parentColumns = "id_sondaggio",
                childColumns = "id_sondaggio",
                onDelete = ForeignKey.CASCADE
        ),
        indices = {@Index(value = "id_sondaggio")}
)
public class Choice {

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_scelta") private String id_scelta;
    @ColumnInfo(name = "id_sondaggio") private String id_sondaggio;
    @ColumnInfo(name = "descrizione_scelta") private String descrizione_scelta;


    public Choice(String id_sondaggio, String descrizione_scelta) {
        this.id_sondaggio = id_sondaggio;
        this.descrizione_scelta = descrizione_scelta;
    }

    public String getIdScelta() {
        return id_scelta;
    }

    public void setIdScelta(String id_scelta) {
        this.id_scelta = id_scelta;
    }

    public String getIdSondaggio() {
        return id_sondaggio;
    }

    public void setIdSondaggio(String id_sondaggio) {
        this.id_sondaggio = id_sondaggio;
    }

    public String getDescrizioneScelta() {
        return descrizione_scelta;
    }

    public void setDescrizioneScelta(String descrizione_scelta) {
        this.descrizione_scelta = descrizione_scelta;
    }
}