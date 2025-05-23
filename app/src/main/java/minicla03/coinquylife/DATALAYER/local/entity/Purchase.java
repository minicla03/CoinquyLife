package minicla03.coinquylife.DATALAYER.local.entity;

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
        tableName = "Purchase",
        foreignKeys = {
                @ForeignKey(
                    entity = User.class,
                    parentColumns = "id_user",
                    childColumns = "id_user",
                    onDelete = ForeignKey.CASCADE,
                    onUpdate = ForeignKey.CASCADE),
                @ForeignKey(
                    entity = CoinquyHouse.class,
                    parentColumns = "id_house",
                    childColumns = "id_house",
                    onDelete = ForeignKey.CASCADE,
                    onUpdate = ForeignKey.CASCADE)
        },
        indices = {
                @Index(value = "id_user"),
                @Index(value = "id_house")
        }
)
public class Purchase
{
    @ColumnInfo(name = "id_purchase") @NotNull @PrimaryKey private String id_purchase;
    @ColumnInfo(name = "id_user") private String id_user;
    @ColumnInfo(name = "id_house") private String id_house;
    @ColumnInfo(name = "amount") private Double amount;
    @ColumnInfo(name = "descr_purchase") private String descr_purchase;
    @ColumnInfo(name = "purchase_date") private Date purchase_date;
    @ColumnInfo(name = "done") private boolean done;
    @ColumnInfo(name = "paid") private boolean paied;

    public Purchase() { }

    @Ignore
    public Purchase(String id_user, String id_house, Double amount, String descr_purchase, Date purchase_date, boolean done, boolean paied) {
        this.id_purchase= UUID.randomUUID().toString();
        this.id_user = id_user;
        this.id_house = id_house;
        this.amount=amount;
        this.descr_purchase = descr_purchase;
        this.purchase_date = purchase_date;
        this.done = done;
        this.paied = paied;
    }

    public String getId_purchase() {
        return id_purchase;
    }

    public void setId_purchase(String id_purchase) {
        this.id_purchase = id_purchase;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getId_house() {
        return id_house;
    }

    public void setId_house(String id_house) {
        this.id_house = id_house;
    }

    public String getDescr_purchase() {
        return descr_purchase;
    }

    public void setDescr_purchase(String descr_purchase) {
        this.descr_purchase = descr_purchase;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isPaied() {
        return paied;
    }

    public void setPaied(boolean paied) {
        this.paied = paied;
    }

    public Double getAmount() {return amount;}

    public void setAmount(Double amount) {this.amount = amount;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(id_purchase, purchase.id_purchase) && Objects.equals(id_user, purchase.id_user) && Objects.equals(id_house, purchase.id_house);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_purchase, id_user, id_house);
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id_purchase='" + id_purchase + '\'' +
                ", id_user='" + id_user + '\'' +
                ", id_house='" + id_house + '\'' +
                ", descr_purchase='" + descr_purchase + '\'' +
                ", purchase_date=" + purchase_date +
                ", done=" + done +
                ", paied=" + paied +
                '}';
    }
}
