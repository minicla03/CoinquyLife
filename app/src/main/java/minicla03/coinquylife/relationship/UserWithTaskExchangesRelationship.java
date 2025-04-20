package minicla03.coinquylife.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

import minicla03.coinquylife.entity.TaskExchange;
import minicla03.coinquylife.entity.User;

public class UserWithTaskExchangesRelationship {
    @Embedded
    public User user;

    @Relation(
        parentColumn = "id_user",
        entityColumn = "requesterId" // Campo per chi richiede lo scambio
    )
    public List<TaskExchange> requestedExchanges;

    @Relation(
        parentColumn = "id_user",
        entityColumn = "receiverId" // Campo per chi riceve lo scambio
    )
    public List<TaskExchange> receivedExchanges;
}