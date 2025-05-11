package minicla03.coinquylife.DATALAYER.database.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Objects;

@Entity(tableName="CoinquyHouse")
public class CoinquyHouse implements Parcelable
{
    @PrimaryKey @NotNull @ColumnInfo(name = "id_house") private String id_house;
    @NotNull @ColumnInfo(name = "house_name") private String house_name;
    @ColumnInfo(name = "address") private String address;
    @ColumnInfo(name = "creation_date") private Date creation_date= new Date();
    //List<Rule> rules;

    public CoinquyHouse() { }

    @Ignore
    public CoinquyHouse(@NotNull String id_house, @NotNull String nome_casa) {
        this.id_house =id_house;
        this.house_name = nome_casa;
        this.address = "";
        this.creation_date = new Date();
    }

    protected CoinquyHouse(Parcel in)
    {
        id_house = Objects.requireNonNull(in.readString());
        house_name = Objects.requireNonNull(in.readString());
        address = in.readString();
        long dateMillis = in.readLong();
        creation_date = new Date(dateMillis);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(id_house);
        dest.writeString(house_name);
        dest.writeString(address);
        dest.writeLong(creation_date != null ? creation_date.getTime() : 0);
    }

    public static final Creator<CoinquyHouse> CREATOR = new Creator<CoinquyHouse>() {
        @Override
        public CoinquyHouse createFromParcel(Parcel in) {
            return new CoinquyHouse(in);
        }

        @Override
        public CoinquyHouse[] newArray(int size) {
            return new CoinquyHouse[size];
        }
    };

    public @NotNull String getId_house() {
        return id_house;
    }

    public void setId_house(@NotNull String id_house) {
        this.id_house = id_house;
    }

    public @NotNull String getHouse_name() {
        return house_name;
    }

    public void setHouse_name(@NotNull String house_name) {
        this.house_name = house_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }
}