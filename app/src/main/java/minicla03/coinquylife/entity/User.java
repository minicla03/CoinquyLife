package minicla03.coinquylife.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

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
                ),
        indices = @Index(value = "houseId")
        )

public class User {
    @PrimaryKey(autoGenerate = true)
    @NotNull
    private String id;
    @ColumnInfo(name = "username")
    @NotNull
    private String username;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "password")
    @NotNull
    private String password;
    @ColumnInfo(name = "surname")
    private String surname;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "level")
    private int level;
    @ColumnInfo(name = "total_point")
    private int total_points;
    @ColumnInfo(name = "language_profile")
    private String language;
    @ColumnInfo(name = "img_profile")
    private byte[] profileImage;
    @ColumnInfo(name = "houseUser", index=true)
    private String houseUser;

    /**
     * Constructs a new User object with the specified details.
     *
     * @param username      The unique username of the user.
     * @param name          The name of the user.
     * @param password      The password of the user.
     * @param surname       The surname of the user.
     * @param email         The email address of the user.
     * @param level       The experience level of the user.
     * @param total_points  The total points accumulated by the user.
     * @param Lingua        The preferred language of the user.
     * @param profileImage  The profile image of the user as a byte array.
     */
    public User(@NonNull String username, String name, @NonNull String password, String surname, String email, int level, int total_points, String Lingua, byte[] profileImage) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.name = name;
        this.password = password;
        this.surname = surname;
        this.email = email;
        this.level = level;
        this.total_points = total_points;
        this.language = Lingua;
        this.profileImage = profileImage;
        this.houseUser=null;
    }

    /**
     * Gets the unique identifier of the user.
     *
     * @return The user's unique ID.
     */
    @NonNull
    public String getId() {
        return id;
    }

    /**
     * Gets the username of the user.
     *
     * @return The user's username.
     */
    @NonNull
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username The new username to set.
     */
    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    /**
     * Gets the name of the user.
     *
     * @return The user's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name The new name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the password of the user.
     *
     * @return The user's password.
     */
    @NonNull
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The new password to set.
     */
    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    /**
     * Gets the surname of the user.
     *
     * @return The user's surname.
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * Sets the surname of the user.
     *
     * @param surname The new surname to set.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets the email of the user.
     *
     * @return The user's email address.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email The new email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the level of the user.
     *
     * @return The user's level.
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * Sets the level of the user.
     *
     * @param level The new level to set.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Gets the total points of the user.
     *
     * @return The user's total points.
     */
    public int getTotal_points() {
        return this.total_points;
    }

    /**
     * Sets the total points of the user.
     *
     * @param total_points The new total points to set.
     */
    public void setTotal_points(int total_points) {
        this.total_points = total_points;
    }

    /**
     * Gets the preferred language of the user.
     *
     * @return The user's preferred language.
     */
    public String getLanguage() {
        return this.language;
    }

    /**
     * Sets the preferred language of the user.
     *
     * @param language The new preferred language to set.
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Gets the profile image of the user.
     *
     * @return The user's profile image as a byte array.
     */
    public byte[] getProfileImage() {
        return this.profileImage;
    }

    /**
     * Sets the profile image of the user.
     *
     * @param profileImage The new profile image to set as a byte array.
     */
    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }

    /**
     * Gets the house associated with the user.
     *
     * @return The ID of the house associated with the user.
     */
    public String getHouseUser() {return this.houseUser;}

    /**
     * Sets the house associated with the user.
     *
     * @param houseUser The ID of the house to associate with the user.
     */
    public void setHouseUser(String houseUser) {this.houseUser = houseUser;}

    /**
     * Checks if the specified object is equal to this user.
     *
     * @param o The object to compare with this user.
     * @return {@code true} if the specified object is equal to this user, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username);
    }

    /**
     * Calculates the hash code for this user.
     *
     * @return The hash code based on the user's ID and username.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}



