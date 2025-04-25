package minicla03.coinquylife.DATALAYER.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(
        tableName = "TaskExchange",
        foreignKeys = {
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "id_user",
                        childColumns = "requester",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "id_user",
                        childColumns = "receiver",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = HouseWork.class,
                        parentColumns = "id_housework",
                        childColumns = "original_task_id",
                        onDelete = ForeignKey.CASCADE
                )
        }
)
public class TaskExchange {

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_exchange") private String idExchange;
    @ColumnInfo(name = "requester") private String requester;
    @ColumnInfo(name = "receiver") private String receiver;
    @ColumnInfo(name = "original_task_id") private String originalTaskId;
    @ColumnInfo(name = "request_date") private Date requestDate;
    @ColumnInfo(name = "approved") private boolean approved;

    public TaskExchange(String requester, String receiver, String originalTaskId, Date requestDate, boolean approved) {
        this.requester = requester;
        this.receiver = receiver;
        this.originalTaskId = originalTaskId;
        this.requestDate = requestDate;
        this.approved = approved;
    }

    public String getIdExchange() {
        return idExchange;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getOriginalTaskId() {
        return originalTaskId;
    }

    public void setOriginalTaskId(String originalTaskId) {
        this.originalTaskId = originalTaskId;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}