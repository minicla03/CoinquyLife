package minicla03.coinquylife.DATALAYER.database.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import minicla03.coinquylife.DATALAYER.database.entity.Task;
import minicla03.coinquylife.DATALAYER.database.entity.TaskExchange;

public class TaskExchangeWithTaskRelationship
{
    @Embedded
    public TaskExchange taskExchange;

    @Relation(
        parentColumn = "original_task_id",
        entityColumn = "id_task"
    )
    public Task originalTask;
}