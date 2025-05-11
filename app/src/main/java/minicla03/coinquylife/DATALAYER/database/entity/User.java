package minicla03.coinquylife.DATALAYER.database.entity;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.UUID;

@Entity(
        tableName = "User",
        foreignKeys = @ForeignKey
                (
                    entity=CoinquyHouse.class,
                    parentColumns ="id_house",
                    childColumns ="houseUser",
                    onDelete= ForeignKey.CASCADE,
                    onUpdate= ForeignKey.CASCADE
                ),
        indices = {@Index(value = "houseUser")}
        )
public class User implements Parcelable
{
    @PrimaryKey @NotNull @ColumnInfo(name = "id_user") private String id_user;
    @ColumnInfo(name = "username") @NotNull private String username;
    @ColumnInfo(name = "name") @NotNull private String name;
    @ColumnInfo(name = "password") @NotNull private String password;
    @ColumnInfo(name = "surname") private String surname;
    @ColumnInfo(name = "email") private String email;
    @ColumnInfo(name = "level", defaultValue = "1") private int level;
    @ColumnInfo(name = "total_point", defaultValue = "0") private int total_points;
    @ColumnInfo(name = "language_profile") private String language;
    @ColumnInfo(name = "img_profile") private byte[] profileImage;
    @ColumnInfo(name = "houseUser") private String houseUser;

    public User() { }

    @Ignore
    public User(@NonNull String username, @NonNull String name, @NonNull String password, String surname, String email) {
        this.id_user = UUID.randomUUID().toString();
        this.username = username;
        this.name = name;
        this.password = password;
        this.surname = surname;
        this.email = email;
        this.level = 0;
        this.total_points = 0;
        this.profileImage = null;
        this.houseUser=null;
    }

    protected User(Parcel in)
    {
        id_user = Objects.requireNonNull(in.readString());
        username = Objects.requireNonNull(in.readString());
        name = Objects.requireNonNull(in.readString());
        password = Objects.requireNonNull(in.readString());
        surname = in.readString();
        email = in.readString();
        level = in.readInt();
        total_points = in.readInt();
        language = in.readString();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
        {
            profileImage = in.readBlob();
        }
        houseUser = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>()
    {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(id_user);
        dest.writeString(username);
        dest.writeString(name);
        dest.writeString(password);
        dest.writeString(surname);
        dest.writeString(email);
        dest.writeInt(level);
        dest.writeInt(total_points);
        dest.writeString(language);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            dest.writeBlob(profileImage);
        }
        dest.writeString(houseUser);
    }

    public @NotNull String getId_user() {
        return id_user;
    }

    public void setId_user(@NotNull String id_user) {
        this.id_user = id_user;
    }

    public @NotNull String getUsername() {
        return username;
    }

    public void setUsername(@NotNull String username) {
        this.username = username;
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTotal_points() {
        return total_points;
    }

    public void setTotal_points(int total_points) {
        this.total_points = total_points;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public byte[] getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }

    public String getHouseUser() {
        return houseUser;
    }

    public void setHouseUser(String houseUser) {
        this.houseUser = houseUser;
    }
}



