package minicla03.coinquylife.PERSISTANCE.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

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
        },
        indices = {
                @Index(value = "coinquy"),
                @Index(value = "id_house")
        }
)
public class HouseWork
{
    @PrimaryKey @ColumnInfo(name = "id_housework") @NotNull private String idHouseWork;
    @ColumnInfo(name = "coinquy") private String coinquy;
    @ColumnInfo(name = "id_house") private String idHouse;
    @ColumnInfo(name = "description") private String description;
    @ColumnInfo(name = "date_involvement") private Date dateInvolvement;
    @ColumnInfo(name = "earned_point") private int earned_point;
    @ColumnInfo(name = "penalty")  private int penality;
    @ColumnInfo(name = "done_hw") private boolean done_hw;

    public HouseWork(){ }

    @Ignore
    public HouseWork(String coinquy, String idHouse, String description, Date dateInvolvement, int earned_point, int penality, boolean done_hw) {
        this.idHouseWork = UUID.randomUUID().toString();
        this.coinquy = coinquy;
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

    public void setIdHouseWork(String idHouseWork) {
        this.idHouseWork = idHouseWork;
    }

    public String getCoinquy() {
        return coinquy;
    }

    public void setCoinquy(String coinquy) {
        this.coinquy = coinquy;
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

    public void setDateInvolvement(Date dateInvolvement) {
        this.dateInvolvement = dateInvolvement;
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
        return Objects.equals(idHouseWork, houseWork.idHouseWork) && Objects.equals(coinquy, houseWork.coinquy) && Objects.equals(idHouse, houseWork.idHouse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHouseWork, coinquy, idHouse);
    }

    @Override
    public String toString() {
        return "HouseWork{" +
                "idHouseWork='" + idHouseWork + '\'' +
                ", coinquy='" + coinquy + '\'' +
                ", idHouse='" + idHouse + '\'' +
                ", description='" + description + '\'' +
                ", dateInvolvement=" + dateInvolvement +
                ", earned_point=" + earned_point +
                ", penality=" + penality +
                ", done_hw=" + done_hw +
                '}';
    }

}