package minicla03.coinquylife.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity(
        tableName = "HouseWork",
        foreignKeys = {
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "id_user",
                        childColumns = "coinquy",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = CoinquyHouse.class,
                        parentColumns = "id_house",
                        childColumns = "id_house",
                        onDelete = ForeignKey.CASCADE
                )
        }
)
public class HouseWork {

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_housework") private String idHouseWork;
    @ColumnInfo(name = "coiquy") private String coiquy;
    @ColumnInfo(name = "id_house") private String idHouse;
    @ColumnInfo(name = "description") private String description;
    @ColumnInfo(name = "date_involvement") private Date dateInvolvement;
    @ColumnInfo(name = "earned_point") private int earned_point;
    @ColumnInfo(name = "penality")  private int penality;
    @ColumnInfo(name = "done_hw") private boolean done_hw;

    public HouseWork(String coiquy, String idHouse, String description, Date dateInvolvement, int earned_point, int penality, boolean done_hw) {
        this.idHouseWork = UUID.randomUUID().toString();
        this.coiquy = coiquy;
        this.idHouse = idHouse;
        this.description = description;
        this.dateInvolvement = dateInvolvement;
        this.earned_point = earned_point;
        this.penality = penality;
        this.done_hw = done_hw;
    }

    public String getIdHouseWork() {
        return idHouseWork;
    }

    public String getCoiquy() {
        return coiquy;
    }

    public void setCoiquy(String coiquy) {
        this.coiquy = coiquy;
    }

    public String getIdHouse() {
        return idHouse;
    }

    public void setIdHouse(String idHouse) {
        this.idHouse = idHouse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateInvolvement() {
        return dateInvolvement;
    }

    public void setDataSvolgimento(Date dataSvolgimento) {
        this.dateInvolvement = dataSvolgimento;
    }

    public int getEarned_point() {
        return earned_point;
    }

    public void setEarned_point(int earned_point) {
        this.earned_point = earned_point;
    }

    public int getPenality() {
        return penality;
    }

    public void setPenality(int penality) {
        this.penality = penality;
    }

    public boolean isDone_hw() {
        return done_hw;
    }

    public void setDone_hw(boolean done_hw) {
        this.done_hw = done_hw;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        HouseWork houseWork = (HouseWork) o;
        return Objects.equals(idHouseWork, houseWork.idHouseWork) && Objects.equals(description, houseWork.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHouseWork, description);
    }
}