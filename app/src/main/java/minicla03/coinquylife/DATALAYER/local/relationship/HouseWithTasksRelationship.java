package minicla03.coinquylife.DATALAYER.local.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

import minicla03.coinquylife.DATALAYER.local.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.local.entity.Task;

public class HouseWithTasksRelationship {
    @Embedded
    public CoinquyHouse house;

    @Relation(
        parentColumn = "id_house", //CoinquyHouse
        entityColumn = "id_house" //Task
    )
    public List<Task> tasks;
}