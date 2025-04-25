package minicla03.coinquylife.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;

import java.util.Date;
import java.util.UUID;

@Entity(
    tableName = "Task",
    foreignKeys = {
        @ForeignKey(
            entity = User.class,
            parentColumns = "id_user",
            childColumns = "tenant",
            onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
            entity = CoinquyHouse.class,
            parentColumns = "id_house",
            childColumns = "houseId",
            onDelete = ForeignKey.CASCADE
        )
    }
)
public class Task
{
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_task") public String taskId;
    @ColumnInfo(name = "id_user") public String tenant;
    @ColumnInfo(name = "id_house") public String houseId;
    @ColumnInfo(name = "description") public String description;
    @ColumnInfo(name = "date_execution") public Date executionDate;
    @ColumnInfo(name = "earned_points") public int earnedPoints;
    @ColumnInfo(name = "penalty") public int penalty;
    @ColumnInfo(name = "completed") public boolean completed;

    public Task(String tenant, String houseId, String description, Date executionDate, int earnedPoints, int penalty, boolean completed)
    {
        this.taskId = UUID.randomUUID().toString();
        this.tenant = tenant;
        this.houseId = houseId;
        this.description = description;
        this.executionDate = executionDate;
        this.earnedPoints = earnedPoints;
        this.penalty = penalty;
        this.completed = completed;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    public int getEarnedPoints() {
        return earnedPoints;
    }

    public void setEarnedPoints(int earnedPoints) {
        this.earnedPoints = earnedPoints;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}