package minicla03.coinquylife.DATALAYER.database.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

import minicla03.coinquylife.DATALAYER.database.entity.Task;
import minicla03.coinquylife.DATALAYER.database.entity.User;

public class UserWithTasksRelationship {
    @Embedded
    public User user;

    @Relation(
        parentColumn = "id_user",
        entityColumn = "id_user"
    )
    public List<Task> tasks;
}