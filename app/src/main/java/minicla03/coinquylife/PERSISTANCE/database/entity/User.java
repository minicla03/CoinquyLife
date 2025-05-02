package minicla03.coinquylife.PERSISTANCE.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
/**
 * Represents a user in the CoinquyLife application.
 * <p>
 * This class models a user and encapsulates their essential information, including:
 * </p>
 * <ul>
 *   <li><b>ID:</b> A unique identifier for the user, automatically generated.</li>
 *   <li><b>Username:</b> The unique username used for login.</li>
 *   <li><b>Password:</b> The user's password for authentication.</li>
 *   <li><b>Name and Surname:</b> The user's personal details.</li>
 *   <li><b>Email:</b> The user's email address.</li>
 *   <li><b>Level:</b> The user's experience level in the system.</li>
 *   <li><b>Total Points:</b> The total score accumulated by the user.</li>
 *   <li><b>Language:</b> The user's preferred language.</li>
 *   <li><b>Profile Image:</b> The user's profile picture stored as a byte array.</li>
 * </ul>
 * <p>
 * Users can participate in shared activities and belong to a {@link CoinquyHouse}.
 * </p>
 */

@Entity(
        tableName = "User",
        foreignKeys = @ForeignKey
                (
                    entity=CoinquyHouse.class,
                    parentColumns ="id_house",
                    childColumns ="houseUser",
                    onDelete= ForeignKey.CASCADE,
                    onUpdate= ForeignKey.CASCADE
                )
        )
public class User
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

    /**
     * Constructs a new User object with the specified details.
     *
     * @param username      The unique username of the user.
     * @param name          The name of the user.
     * @param password      The password of the user.
     * @param surname       The surname of the user.
     * @param email         The email address of the user.
     */
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



