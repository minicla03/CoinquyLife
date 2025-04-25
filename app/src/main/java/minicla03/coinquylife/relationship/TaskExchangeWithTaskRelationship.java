package minicla03.coinquylife.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import minicla03.coinquylife.entity.Task;
import minicla03.coinquylife.entity.TaskExchange;

public class TaskExchangeWithTaskRelationship {
    @Embedded
    public TaskExchange taskExchange;

    @Relation(
        parentColumn = "originalTaskId",
        entityColumn = "id_task" // Campo per il compito originale
    )
    public Task originalTask;
}