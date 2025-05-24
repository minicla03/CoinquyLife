package minicla03.coinquylife.DATALAYER.local.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

import minicla03.coinquylife.DATALAYER.local.entity.TaskExchange;
import minicla03.coinquylife.DATALAYER.local.entity.User;

public class UserWithTaskExchangesRelationship {
    @Embedded
    public User user;

    @Relation(
        parentColumn = "id_user",
        entityColumn = "requester" // Campo per chi richiede lo scambio
    )
    public List<TaskExchange> requestedExchanges;

    @Relation(
        parentColumn = "id_user",
        entityColumn = "receiver" // Campo per chi riceve lo scambio
    )
    public List<TaskExchange> receivedExchanges;
}