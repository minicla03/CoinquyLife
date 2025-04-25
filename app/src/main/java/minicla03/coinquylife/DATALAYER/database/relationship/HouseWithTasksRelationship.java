package minicla03.coinquylife.DATALAYER.database.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

import minicla03.coinquylife.DATALAYER.database.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.database.entity.Task;

public class HouseWithTasksRelationship {
    @Embedded
    public CoinquyHouse house;

    @Relation(
        parentColumn = "id_casa",
        entityColumn = "id_casa"
    )
    public List<Task> tasks;
}